
public class TextView extends View {
 
    
    private String mText;
 
    
    private int mTextColor;
    
    
    private Context mContext;
 
    
    public TextView(Context context) {
      mText = "";
      mTextColor = 0;
      mContext = context;
    }
 
    
    public void setText(String text) {
        mText = text;
    }
 
    
    public void setTextColor(int color) {
        mTextColor = color;
    }
 
    
    public String getText() {
        return mText;
    }
 
    
    public int getTextColor() {
        return mTextColor;
    }
}
