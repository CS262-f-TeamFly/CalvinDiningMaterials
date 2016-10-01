package calvin.a262teamf.calvindininghall;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
    }

    public TimeLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TimeLabel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.name = (TextView)findViewById(R.id.name);
    }

    public void setName(String name) {
        this.name.setText(name);
    }
}
