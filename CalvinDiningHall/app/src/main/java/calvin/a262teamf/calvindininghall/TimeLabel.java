package calvin.a262teamf.calvindininghall;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Kristofer on 10/1/2016.
 */

public class TimeLabel extends RelativeLayout {
    private TextView name;

    public TimeLabel(Context context) {
        super(context);
        init();
    }

    public TimeLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TimeLabel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    // http://trickyandroid.com/protip-inflating-layout-for-your-custom-view/
    private void init() {
        inflate(getContext(), R.layout.time_label, this);
        this.name = (TextView)findViewById(R.id.name);
        ((TextView)((LinearLayout)getChildAt(0)).getChildAt(2)).setText("hi there");
    }

    public void setName(String name) {
        this.name.setText(name);
    }
}
