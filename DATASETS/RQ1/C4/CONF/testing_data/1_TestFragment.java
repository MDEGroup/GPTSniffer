public class TestFragment extends Fragment {
	@Override public @Nullable View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		RecyclerView list = new RecyclerView(container.getContext());
		list.setLayoutParams(new MarginLayoutParams(MarginLayoutParams.MATCH_PARENT, MarginLayoutParams.MATCH_PARENT));
		list.setLayoutManager(new LinearLayoutManager(container.getContext()));
		list.setAdapter(new ProgressAdapter(Arrays.asList(
				
				"http:
				"http:
				"https:
				"https:
				"https:
				"https:
				"http:
				"https:
				"http:
				"http:
				"https:
				"https:
				"https:
				"http:
				"https:
				"https:
				"http:
		)));
		return list;
	}

	private static class ProgressViewHolder extends ViewHolder {
		private final ImageView image;
		private final TextView text;
		private final ProgressBar progress;
		
		private final ProgressTarget<String, Bitmap> target;
		ProgressViewHolder(View root) {
			super(root);
			image = (ImageView)root.findViewById(R.id.image);
			text = (TextView)root.findViewById(R.id.text);
			progress = (ProgressBar)root.findViewById(R.id.progress);
			target = new MyProgressTarget<>(new BitmapImageViewTarget(image), progress, image, text);
		}
		void bind(String url) {
			target.setModel(url); 
			Glide
					.with(image.getContext())
					.load(url)
					.asBitmap()
					.placeholder(R.drawable.github_232_progress)
					.centerCrop() 
					.into(target)
			;
		}
	}

	
	private static class MyProgressTarget<Z> extends ProgressTarget<String, Z> {
		private final TextView text;
		private final ProgressBar progress;
		private final ImageView image;
		public MyProgressTarget(Target<Z> target, ProgressBar progress, ImageView image, TextView text) {
			super(target);
			this.progress = progress;
			this.image = image;
			this.text = text;
		}

		@Override public float getGranualityPercentage() {
			return 0.1f; 
		}

		@Override protected void onConnecting() {
			progress.setIndeterminate(true);
			progress.setVisibility(View.VISIBLE);
			image.setImageLevel(0);
			text.setVisibility(View.VISIBLE);
			text.setText("connecting");
		}
		@Override protected void onDownloading(long bytesRead, long expectedLength) {
			progress.setIndeterminate(false);
			progress.setProgress((int)(100 * bytesRead / expectedLength));
			image.setImageLevel((int)(10000 * bytesRead / expectedLength));
			text.setText(String.format("downloading %.2f/%.2f MB %.1f%%",
					bytesRead / 1e6, expectedLength / 1e6, 100f * bytesRead / expectedLength));
		}
		@Override protected void onDownloaded() {
			progress.setIndeterminate(true);
			image.setImageLevel(10000);
			text.setText("decoding and transforming");
		}
		@Override protected void onDelivered() {
			progress.setVisibility(View.INVISIBLE);
			image.setImageLevel(0); 
			text.setVisibility(View.INVISIBLE);
		}
	}

	private static class ProgressAdapter extends Adapter<ProgressViewHolder> {
		private final List<String> models;
		public ProgressAdapter(List<String> models) {
			this.models = models;
		}
		@Override public ProgressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.github_232_item, parent, false);
			return new ProgressViewHolder(view);
		}
		@Override public void onBindViewHolder(ProgressViewHolder holder, int position) {
			holder.bind(models.get(position));
		}
		@Override public int getItemCount() {
			return models.size();
		}
	}
}
