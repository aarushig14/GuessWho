package com.example.agupta1409.gangup;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by a.gupta1409 on 02-07-2016.
 */
public class FragmentFriends extends Fragment {

    static TextView name;
    static ImageView imageView;
    static TextView email;
    static TextView phoneNo;
    static View v;
    static int studentId;
    static String groupID;

    public static FragmentFriends newInstance(int position,String groupId) {
        FragmentFriends fragment = new FragmentFriends();
        Log.d("TAGs","new Instance called");
        groupID = groupId;
        studentId = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("TAGs", "onCreateView:");
        v = inflater.inflate(R.layout.activity_friends_details, container, false);
        setLayout(studentId);
        return v;
    }

    public void setLayout(int position) {
        Log.d("TAGs", "setLayout:");

        name = (TextView) v.findViewById(R.id.tv_name);
        imageView = (ImageView) v.findViewById(R.id.image_fragment);
        email = (TextView) v.findViewById(R.id.tv_email);
        phoneNo = (TextView) v.findViewById(R.id.tv_phoneNo);


        FriendsDetails.friend friend = FriendsDetails.getFriendsList(groupID).get(position);
        name.setText(friend.memberName);
        imageView.setImageResource(friend.profilePic);
        email.setText(friend.emailID);
        phoneNo.setText(friend.phoneNo);

    }


}
