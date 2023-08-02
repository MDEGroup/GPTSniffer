

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

public class TranslucentActivity extends Activity {
    private GoogleMap mGoogleMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent);
        mGoogleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.7523, -73.9888), 14));

        DrawInsetsFrameLayout drawInsetsFrameLayout = (DrawInsetsFrameLayout) findViewById(R.id.my_draw_insets_layout);
        drawInsetsFrameLayout.setOnInsetsCallback(new DrawInsetsFrameLayout.OnInsetsCallback() {
            @Override
            public void onInsetsChanged(Rect insets) {
                
                mGoogleMap.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            }
        });
    }
}
