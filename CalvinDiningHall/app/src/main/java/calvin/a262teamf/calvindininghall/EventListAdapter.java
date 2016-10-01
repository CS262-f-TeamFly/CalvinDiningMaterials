package calvin.a262teamf.calvindininghall;

import android.content.Context;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Kristofer on 9/30/2016.
 */

public class EventListAdapter extends BaseAdapter {
    static class Event {
        public final String name;
        public final GregorianCalendar beginTime;
        public final GregorianCalendar endTime;

        public Event(String name, GregorianCalendar beginTime, GregorianCalendar endTime) {
            this.name = name;
            this.beginTime = beginTime;
            this.endTime = endTime;
        }
    }
    static class DisplayItem {
        public final String time;
        public final Event event;
        public DisplayItem(String time, Event event){
            this.time = time;
            this.event = event;
        }
    }

    final Context context;
    final LayoutInflater layoutInflater;
    final ArrayList<DisplayItem> displayItems;

    public EventListAdapter(Context context, LayoutInflater layoutInflater) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        displayItems = new ArrayList<DisplayItem>();
        // Set up events
        setEvents(new Event[]{});
    }

    public void setEvents(final Event[] events) {
        // http://stackoverflow.com/a/21862750/2948122
        new Handler(context.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                displayItems.clear();
                Log.d("X", "run: uhh, setevents " + events.length);
                if (events.length > 0) {
                    // Sort events by end time
                    Arrays.sort(events, new Comparator<Event>() {
                        @Override
                        public int compare(Event o1, Event o2) {
                            return o1.endTime.compareTo(o2.endTime);
                        }
                    });
                    // Store latest end time into variable
                    int endHour = events[events.length - 1].endTime.get(Calendar.HOUR_OF_DAY);
                    Log.d("X", "endHour comes from " + events[events.length - 1].name + " and is " + endHour);
                    // Sort events by begin time
                    Arrays.sort(events, new Comparator<Event>() {
                        @Override
                        public int compare(Event o1, Event o2) {
                            return o1.beginTime.compareTo(o2.beginTime);
                        }
                    });
                    // Set displayItems
                    DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
                    int startHour = events[0].beginTime.get(Calendar.HOUR_OF_DAY);
                    Log.d("X", "startHour comes from " + events[0].name + " and is " + startHour);
                    GregorianCalendar formattingCalendar = (GregorianCalendar) events[0].beginTime.clone();
                    for (int fieldId = Calendar.MINUTE; fieldId <= Calendar.MILLISECOND; fieldId++) {
                        formattingCalendar.set(fieldId, 0);
                    }
                    Log.v("X", "startHour = " + startHour + ", endHour = " + endHour);
                    for (int i = startHour; i < endHour; i++) {
                        Log.v("X", "Running for loop");
                        Event displayEvent = null;
                        for (Event event : events) {
                            if (event.beginTime.get(Calendar.HOUR_OF_DAY) <= i && i <= event.endTime.get(Calendar.HOUR_OF_DAY)) {
                                displayEvent = event;
                            }
                        }
                        formattingCalendar.set(Calendar.HOUR_OF_DAY, i);
                        DisplayItem displayItem = new DisplayItem(
                                timeFormat.format(formattingCalendar.getTime()),
                                displayEvent);
                        displayItems.add(displayItem);
                    }
                }
                notifyDataSetChanged(); // rerun getView to notice new changes
            }
        });
    }

    @Override
    public int getCount() {
        return this.displayItems.size();
    }

    @Override
    public Object getItem(int position) {
        return displayItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return -1;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("X", "Changing text " + String.valueOf(position));
        TimeLabel tl = new TimeLabel(context);
        DisplayItem displayItem = this.displayItems.get(position);
        if (displayItem.event != null) {
            tl.setName(displayItem.event.name);
        } else {
            tl.setName(displayItem.time);
        }
        return tl;
    }

}