
final class Pair<V> {

    public static <T> Optional<Pair<T>> of(final long key,
                                           final Optional<T> value) {
        return value.map(v -> new Pair<>(key, v));
    }

    public final long key;
    public final V value;

    public Pair(final long key, final V value) {
        this.key = key;
        this.value = value;
    }

    public Pair<V> shiftKey(long shift) {
        return new Pair<>(this.key + shift, this.value);
    }
}

public class RadixTree<T> implements Iterable<Pair<T>> {

    

    public static final int kBitsPerLayer = 1;
    public static final int kLayerSize = (1 << kBitsPerLayer);

    public static final long kLayerMask = (-1L) - (-1L >>> kBitsPerLayer);
    public static final int kLayerBitShift =
        Long.numberOfTrailingZeros(kLayerMask);

    

    private Optional<T> mValue;
    private final Optional<RadixTree<T>>[] mChildren;
    private final int mDepth;

    

    @SuppressWarnings("unchecked")
    private RadixTree(int depth) {
        mValue = Optional.empty();
        mChildren = (Optional<RadixTree<T>>[]) new Optional<?>[ kLayerSize ];
        mDepth = depth;

        for (int i = 0; i < kLayerSize; ++i) {
            mChildren[i] = Optional.empty();
        }
    }

    public RadixTree() { this(0); }

    

    public Optional<T> get(final long index) {
        if (index == 0) {
            return mValue;
        }

        final int child = (int)((index & kLayerMask) >>> kLayerBitShift);
        final long childIndex = index << kBitsPerLayer;

        return mChildren[child].flatMap(c -> c.get(childIndex));
    }

    public Optional<T> set(final long index, final T x) {
        if (index == 0) {
            final Optional<T> previous = mValue;

            mValue = Optional.of(x);

            return previous;
        }

        final int child = (int)((index & kLayerMask) >>> kLayerBitShift);
        final long childIndex = index << kBitsPerLayer;

        mChildren[child] = mChildren[child].or(
            () -> Optional.of(new RadixTree<>(mDepth + 1)));
        return mChildren[child].flatMap(c -> c.set(childIndex, x));
    }

    public Optional<T> remove(final long index) {
        if (index == 0) {
            final Optional<T> previous = mValue;

            mValue = Optional.empty();

            return previous;
        }

        final int child = (int)((index & kLayerMask) >>> kLayerBitShift);
        final long childIndex = index << kBitsPerLayer;

        return mChildren[child].flatMap(c -> c.remove(childIndex));
    }

    

    private final long shift(int i) {
        return ((long)i) << (kLayerBitShift - kBitsPerLayer * mDepth);
    }

    

    public Optional<Pair<T>> min() {
        return Pair.of(0, mValue).or(() -> {
            for (int i = 0; i < kLayerSize; ++i) {
                final Optional<Pair<T>> m =
                    mChildren[i].flatMap(child -> child.min());

                if (m.isPresent()) {
                    final int s = i;
                    return m.map(c -> c.shiftKey(shift(s)));
                }
            }

            return Optional.empty();
        });
    }

    public Optional<Pair<T>> next(long index) {
        if (index == 0) {
            if (mValue.isPresent()) {
                return Pair.of(index, mValue);
            }
        }

        final int child = (int)((index & kLayerMask) >>> kLayerBitShift);
        final long childIndex = index << kBitsPerLayer;

        return mChildren[child]
            .flatMap(c -> c.next(childIndex).map(k -> k.shiftKey(shift(child))))
            .or(() -> {
                for (int i = child + 1; i < kLayerSize; ++i) {
                    final Optional<Pair<T>> m =
                        mChildren[i].flatMap(c -> c.min());

                    if (m.isPresent()) {
                        final int s = i;
                        return m.map(k -> k.shiftKey(shift(s)));
                    }
                }

                return Optional.empty();
            });
    }

    

    public Optional<Pair<T>> max() {
        for (int i = kLayerSize - 1; i >= 0; --i) {
            final Optional<Pair<T>> m =
                mChildren[i].flatMap(child -> child.max());

            if (m.isPresent()) {
                final int s = i;
                return m.map(c -> c.shiftKey(shift(s)));
            }
        }

        return Pair.of(0, mValue);
    }

    public Optional<Pair<T>> prev(long index) {
        final int child = (int)((index & kLayerMask) >>> kLayerBitShift);
        final long childIndex = index << kBitsPerLayer;

        return mChildren[child]
            .flatMap(c -> c.prev(childIndex).map(k -> k.shiftKey(shift(child))))
            .or(() -> {
                for (int i = child - 1; i >= 0; --i) {
                    final Optional<Pair<T>> m =
                        mChildren[i].flatMap(c -> c.max());

                    if (m.isPresent()) {
                        final int s = i;
                        return m.map(k -> k.shiftKey(shift(s)));
                    }
                }

                return Optional.empty();
            });
    }

    

    public Iterator<Pair<T>> iterator() {
        final var parent = this;
        return new Iterator<Pair<T>>() {
            Optional<Pair<T>> next = min();

            public boolean hasNext() { return next.isPresent(); }

            public Pair<T> next() {
                final Pair<T> result = next.get();
                next = result.key != -1 ? parent.next(result.key + 1)
                                        : Optional.empty();
                return result;
            }
        };
    }

    public Iterator<Pair<T>> reverseIterator() {
        final var parent = this;
        return new Iterator<Pair<T>>() {
            Optional<Pair<T>> next = max();

            public boolean hasNext() { return next.isPresent(); }

            public Pair<T> next() {
                final Pair<T> result = next.get();
                next = result.key != 0 ? parent.prev(result.key - 1)
                                       : Optional.empty();
                return result;
            }
        };
    }

    

    public static void main(String... args) {

        RadixTree<Long> table = new RadixTree<>();

        for (long a = 0; a < 100000000; ++a) {
            table.set((long)(Math.random() * Integer.MAX_VALUE),
                      a);
        }

        int k = 0;
        int i = 1;
        for (Pair<Long> l : table) {
            if (++k > i * i) {
                System.out.println(l.key + ": " + l.value);
                k = 0;
                ++i;
            }
        }

        System.out.println();
    }
}
