package com.example.agupta1409.gangup;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

public class KnowYourFriends extends AppCompatActivity {

    static ArrayList<FriendsDetails.friend> friendList;
    ListView friendListView;

    FragmentManager manager = getSupportFragmentManager();
    String groupID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_your_friends);

        Intent recieved_intent =getIntent();
        groupID = recieved_intent.getStringExtra(MainActivity.GROUP_ID);

        friendList = FriendsDetails.getFriendsList(groupID);
        friendListView = (android.widget.ListView) findViewById(R.id.list_view);

        FriendListAdapter Adapter = new FriendListAdapter(friendList);
        friendListView.setAdapter(Adapter);

        friendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Student", "onItemClick:");
                FragmentFriends frg = FragmentFriends.newInstance(position,groupID);
                Log.d("TAGs","frsgment called");
                FragmentTransaction fragTrax = manager.beginTransaction();
                Log.d("TAGs","frg trx called");
                fragTrax.replace(R.id.frag_container, frg, null);
                Log.d("TAGs","frg replace called");
                fragTrax.commit();
            }
        });

    }



//
//    public int getImage(int position){
//        int imageId =0;
//        imageId = friendList.get(position).image;
//        return imageId;
//    }


    private class FriendListAdapter extends BaseAdapter {

        class Holder {
            ImageView photo;
        }


        private ArrayList<FriendsDetails.friend> mFriends;

        public FriendListAdapter(ArrayList<FriendsDetails.friend> mFriends) {
            this.mFriends = mFriends;
        }

        @Override
        public int getCount() {
            return mFriends.size();
        }

        @Override
        public FriendsDetails.friend getItem(int position) {
            return mFriends.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();
            Holder holder;

            if (convertView == null) {
                Log.d("MainActivity", "content view: null");
                convertView = li.inflate(R.layout.list_item, null); // parent nhi ho skta coz addView call krta hai and yhaan hum view group bana rhe hain addView view grp ko add nahi kr sakta
                holder = new Holder();
                holder.photo = (ImageView) convertView.findViewById(R.id.image_list_item);
                convertView.setTag(holder);

            } else {

                Log.d("MainActivity", "content view: not null");
                holder = (Holder) convertView.getTag(); // existing memory references  se mil gaye dubara layout inflate krne ki jrurt nhi haii

            }

            FriendsDetails.friend thisFriend = getItem(position);
            holder.photo.setImageResource(thisFriend.profilePic);
            return convertView;
        }
    }

    public void gotoWhatsapp(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(sendIntent,"Share image to..."));
    }


}
