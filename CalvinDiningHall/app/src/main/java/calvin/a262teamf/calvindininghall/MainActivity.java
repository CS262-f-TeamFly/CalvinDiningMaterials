package calvin.a262teamf.calvindininghall;

import java.util.GregorianCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("X", "hi there !");

        // Make EventList
        EventListAdapter timesEventAdapter = new EventListAdapter(getApplicationContext(), getLayoutInflater());
        ((ListView)findViewById(R.id.times)).setAdapter(timesEventAdapter);
        // Test Events
        timesEventAdapter.setEvents(new EventListAdapter.Event[]{
                new EventListAdapter.Event("Breakfast cool", new GregorianCalendar(2016, 10, 1, 6, 0), new GregorianCalendar(2016, 10, 1, 7, 0)),
                new EventListAdapter.Event("2nd Breakfast", new GregorianCalendar(2016, 10, 1, 8, 0), new GregorianCalendar(2016, 10, 1, 9, 0)),
                new EventListAdapter.Event("Lunch", new GregorianCalendar(2016, 10, 1, 11, 0), new GregorianCalendar(2016, 10, 1, 12, 0)),
                new EventListAdapter.Event("Dinner", new GregorianCalendar(2016, 10, 1, 17, 0), new GregorianCalendar(2016, 10, 1, 18, 0)),
        });
        // TODO add swipe from right menu
    }
}