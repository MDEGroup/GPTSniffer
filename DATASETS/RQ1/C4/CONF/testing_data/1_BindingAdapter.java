

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public abstract class BindableAdapter<T> extends BaseAdapter {
  private final Context context;
  private final LayoutInflater inflater;

  public BindableAdapter(Context context) {
    this.context = context;
    this.inflater = LayoutInflater.from(context);
  }
  
  public Context getContext() {
    return context;
  }

  @Override public abstract T getItem(int position);

  @Override public final View getView(int position, View view, ViewGroup container) {
    if (view == null) {
      view = newView(inflater, position, container);
      if (view == null) {
        throw new IllegalStateException("newView result must not be null.");
      }
    }
    bindView(getItem(position), position, view);
    return view;
  }

  
  public abstract View newView(LayoutInflater inflater, int position, ViewGroup container);

  
  public abstract void bindView(T item, int position, View view);

  @Override public final View getDropDownView(int position, View view, ViewGroup container) {
    if (view == null) {
      view = newDropDownView(inflater, position, container);
      if (view == null) {
        throw new IllegalStateException("newDropDownView result must not be null.");
      }
    }
    bindDropDownView(getItem(position), position, view);
    return view;
  }

  
  public View newDropDownView(LayoutInflater inflater, int position, ViewGroup container) {
    return newView(inflater, position, container);
  }

  
  public void bindDropDownView(T item, int position, View view) {
    bindView(item, position, view);
  }
}
