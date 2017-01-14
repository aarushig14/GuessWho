package com.example.agupta1409.gangup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Events extends AppCompatActivity {

    ArrayList<Event.event> eventArrayList;
    ListView listView;
    Event event;
    String groupId;
    static final int REQ_CODE = 4567;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Intent recieved_intent = getIntent();
        groupId = recieved_intent.getStringExtra(MainActivity.GROUP_ID);

        event = new Event();
        eventArrayList = event.getEvents(groupId);
        listView = (ListView) findViewById(R.id.list_event);

        eventListAdapter adapter = new eventListAdapter(eventArrayList);
        listView.setAdapter(adapter);


    }

    public void addEvent(View view){
        Toast.makeText(getBaseContext(),"Feature not available",Toast.LENGTH_SHORT).show();
    }

    public class eventListAdapter extends BaseAdapter{

        public class ViewHolder{
            TextView eventDescrition;
            ImageView eventImage;
        }

        private ArrayList<Event.event> mEvents;

        public eventListAdapter(ArrayList<Event.event> mEvents) {
            this.mEvents = mEvents;
        }

        @Override
        public int getCount() {
            return mEvents.size();
        }

        @Override
        public Object getItem(int position) {
            return mEvents.get(position);
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();
            ViewHolder holder ;


                convertView = li.inflate(R.layout.events_list_item,null);
                holder = new ViewHolder();
                holder.eventDescrition = (TextView) convertView.findViewById(R.id.event_description);
                holder.eventImage = (ImageView) convertView.findViewById(R.id.event_image);
                convertView.setTag(holder);


            Event.event thisEvent = (Event.event) getItem(position);
            holder.eventDescrition.setText(thisEvent.event);
            holder.eventImage.setImageResource(thisEvent.image);

            return convertView;
        }
    }

    public void addEventFromUser(View view){
        Intent i = new Intent(this,AddEvent.class);
        i.setAction(Intent.ACTION_VIEW);
        startActivityForResult(i,REQ_CODE);

    }
}
