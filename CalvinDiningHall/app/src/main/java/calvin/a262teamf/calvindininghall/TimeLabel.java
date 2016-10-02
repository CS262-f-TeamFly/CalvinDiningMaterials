package calvin.a262teamf.calvindininghall;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
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

    // http://stackoverflow.com/a/17277714/2948122
    private void setIsCurrent(Boolean isCurrent) {
        // Get theme
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getContext().getTheme();
        theme.resolveAttribute(R.attr.colorAccent, typedValue, true);
        int color = typedValue.data;
        if (isCurrent) { // Highlight block
            setBackgroundColor(0xff00ff00);
        } else { // Dehighlight block
            setBackgroundColor(0xff0000ff);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.name = (TextView)findViewById(R.id.name);
    }

    public void set(Boolean isCurrent, String name) {
        setIsCurrent(isCurrent);
        this.name.setText(name);
    }
}
