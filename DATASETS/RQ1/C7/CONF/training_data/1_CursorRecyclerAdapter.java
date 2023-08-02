



public abstract class CursorRecyclerAdapter<VH
		extends android.support.v7.widget.RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>
implements Filterable, CursorFilter.CursorFilterClient {
	private boolean mDataValid;
	private int mRowIDColumn;
	private Cursor mCursor;
	private ChangeObserver mChangeObserver;
	private DataSetObserver mDataSetObserver;
	private CursorFilter mCursorFilter;
	private FilterQueryProvider mFilterQueryProvider;

	public CursorRecyclerAdapter( Cursor cursor) {
		init(cursor);
	}

	void init(Cursor c) {
		boolean cursorPresent = c != null;
		mCursor = c;
		mDataValid = cursorPresent;
		mRowIDColumn = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;

		mChangeObserver = new ChangeObserver();
		mDataSetObserver = new MyDataSetObserver();

		if (cursorPresent) {
			if (mChangeObserver != null) c.registerContentObserver(mChangeObserver);
			if (mDataSetObserver != null) c.registerDataSetObserver(mDataSetObserver);
		}
	}

	
	@Override
	public void onBindViewHolder(VH holder, int i){
		if (!mDataValid) {
			throw new IllegalStateException("this should only be called when the cursor is valid");
		}
		if (!mCursor.moveToPosition(i)) {
			throw new IllegalStateException("couldn't move cursor to position " + i);
		}
		onBindViewHolderCursor(holder, mCursor);
	}

	
	public abstract void onBindViewHolderCursor(VH holder, Cursor cursor);

	@Override
	public int getItemCount() {
		if (mDataValid && mCursor != null) {
			return mCursor.getCount();
		} else {
			return 0;
		}
	}

	
	@Override
	public long getItemId(int position) {
		if (mDataValid && mCursor != null) {
			if (mCursor.moveToPosition(position)) {
				return mCursor.getLong(mRowIDColumn);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public Cursor getCursor(){
		return mCursor;
	}

	
	public void changeCursor(Cursor cursor) {
		Cursor old = swapCursor(cursor);
		if (old != null) {
			old.close();
		}
	}

	
	public Cursor swapCursor(Cursor newCursor) {
		if (newCursor == mCursor) {
			return null;
		}
		Cursor oldCursor = mCursor;
		if (oldCursor != null) {
			if (mChangeObserver != null) oldCursor.unregisterContentObserver(mChangeObserver);
			if (mDataSetObserver != null) oldCursor.unregisterDataSetObserver(mDataSetObserver);
		}
		mCursor = newCursor;
		if (newCursor != null) {
			if (mChangeObserver != null) newCursor.registerContentObserver(mChangeObserver);
			if (mDataSetObserver != null) newCursor.registerDataSetObserver(mDataSetObserver);
			mRowIDColumn = newCursor.getColumnIndexOrThrow("_id");
			mDataValid = true;
			
			notifyDataSetChanged();
		} else {
			mRowIDColumn = -1;
			mDataValid = false;
			
			
			notifyItemRangeRemoved(0, getItemCount());
		}
		return oldCursor;
	}

	
	public CharSequence convertToString(Cursor cursor) {
		return cursor == null ? "" : cursor.toString();
	}

	
	public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
		if (mFilterQueryProvider != null) {
			return mFilterQueryProvider.runQuery(constraint);
		}

		return mCursor;
	}

	public Filter getFilter() {
		if (mCursorFilter == null) {
			mCursorFilter = new CursorFilter(this);
		}
		return mCursorFilter;
	}

	
	public FilterQueryProvider getFilterQueryProvider() {
		return mFilterQueryProvider;
	}

	
	public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
		mFilterQueryProvider = filterQueryProvider;
	}

	
	protected void onContentChanged() {

	}

	private class ChangeObserver extends ContentObserver {
		public ChangeObserver() {
			super(new Handler());
		}

		@Override
		public boolean deliverSelfNotifications() {
			return true;
		}

		@Override
		public void onChange(boolean selfChange) {
			onContentChanged();
		}
	}

	private class MyDataSetObserver extends DataSetObserver {
		@Override
		public void onChanged() {
			mDataValid = true;
			notifyDataSetChanged();
		}

		@Override
		public void onInvalidated() {
			mDataValid = false;
			
			notifyItemRangeRemoved(0, getItemCount());
		}
	}

	

}

class CursorFilter extends Filter {

	CursorFilterClient mClient;

	interface CursorFilterClient {
		CharSequence convertToString(Cursor cursor);
		Cursor runQueryOnBackgroundThread(CharSequence constraint);
		Cursor getCursor();
		void changeCursor(Cursor cursor);
	}

	CursorFilter(CursorFilterClient client) {
		mClient = client;
	}

	@Override
	public CharSequence convertResultToString(Object resultValue) {
		return mClient.convertToString((Cursor) resultValue);
	}

	@Override
	protected FilterResults performFiltering(CharSequence constraint) {
		Cursor cursor = mClient.runQueryOnBackgroundThread(constraint);

		FilterResults results = new FilterResults();
		if (cursor != null) {
			results.count = cursor.getCount();
			results.values = cursor;
		} else {
			results.count = 0;
			results.values = null;
		}
		return results;
	}

	@Override
	protected void publishResults(CharSequence constraint, FilterResults results) {
		Cursor oldCursor = mClient.getCursor();

		if (results.values != null && results.values != oldCursor) {
			mClient.changeCursor((Cursor) results.values);
		}
	}
}
