/**
 * Simplest custom view possible, using CircularProgressDrawable
 */
public class CustomView extends View {

  private CircularProgressDrawable mDrawable;

  public CustomView(Context context) {
    this(context, null);
  }

  public CustomView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    mDrawable = new CircularProgressDrawable(Color.RED, 10);
    mDrawable.setCallback(this);
  }

  @Override
  protected void onVisibilityChanged(View changedView, int visibility) {
    super.onVisibilityChanged(changedView, visibility);
    if (visibility == VISIBLE) {
      mDrawable.start();
    } else {
      mDrawable.stop();
    }
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mDrawable.setBounds(0, 0, w, h);
  }

  @Override
  public void draw(Canvas canvas) {
    super.draw(canvas);
    mDrawable.draw(canvas);
  }

  @Override
  protected boolean verifyDrawable(Drawable who) {
    return who == mDrawable || super.verifyDrawable(who);
  }
}