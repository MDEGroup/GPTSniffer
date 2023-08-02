



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class CharsPerLineActivity extends Activity {
    private static final String TAG = "CharsPerLineActivity";

    private TextView mStatusView;
    private View mContainerView;
    private TextView mTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatusView = (TextView) findViewById(R.id.status);
        mContainerView = findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);

        mTextView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Log.d(TAG, "Parent: " + mContainerView.getWidth()
                                + ", Child: " + mTextView.getWidth());
                        int maxCharsPerLine = CharsPerLineUtil.getMaxCharsPerLine(mTextView);
                        boolean badCpl = maxCharsPerLine < CharsPerLineUtil.RECOMMENDED_MIN_CPL
                                || maxCharsPerLine > CharsPerLineUtil.RECOMMENDED_MAX_CPL;
                        mStatusView.setTextColor(badCpl ? 0xffff4444 : 0x88ffffff);
                        mStatusView.setText("Maximum measure: " + maxCharsPerLine + " CPL");
                    }
                });
    }
}
