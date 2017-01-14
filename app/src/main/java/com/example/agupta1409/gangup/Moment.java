package com.example.agupta1409.gangup;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Moment extends AppCompatActivity {

    ArrayList<Event.event> eventImage;
    ArrayList<FriendsDetails.friend> friendsImage;
    GridView gridView;
    ArrayList<Integer> images;
    int totalImages;
    String groupId;
    public static final String IMAGE_ID = "imageId";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moment);

        Intent recieved_intent = getIntent();
        groupId = recieved_intent.getStringExtra(MainActivity.GROUP_ID);

        images = new ArrayList<>();
        eventImage = (new Event()).getEvents(groupId);
        friendsImage = FriendsDetails.getFriendsList(groupId);
        totalImages = eventImage.size() + friendsImage.size();
        int i = 0;
        while(i<eventImage.size()){
            images.add(eventImage.get(i).image);
            i++;
        }
        i=0;
        while(i<friendsImage.size()){
            images.add(friendsImage.get(i).profilePic);
            i++;
        }

        gridView = (GridView) findViewById(R.id.gridView);
        final GridViewAdapter adapter  = new GridViewAdapter(this,R.layout.grid_row_item_layout,images);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(),EnlargedImage.class);
                i.putExtra(IMAGE_ID,images.get(position));
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });


    }


    public class GridViewAdapter extends ArrayAdapter{

        private Context ctx ;
        private int layoutResCode;
        ArrayList<Integer> listResCode;

        public class ViewHolder{
            ImageView imageView;
        }

        public GridViewAdapter(Context context, int resource, ArrayList<Integer> listResCode) {
            super(context, resource, listResCode);
            this.listResCode = listResCode;
            this.ctx = context;
            this.layoutResCode = resource;
        }

        @Override
        public Object getItem(int position) {
            return listResCode.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater li = getLayoutInflater();

            if(convertView == null){
                convertView = li.inflate(R.layout.grid_row_item_layout,null);
                holder = new ViewHolder();
                holder.imageView = (ImageView) convertView.findViewById(R.id.grid_item_image);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.imageView.setImageResource(images.get(position));
            return convertView;
        }
    }

}
