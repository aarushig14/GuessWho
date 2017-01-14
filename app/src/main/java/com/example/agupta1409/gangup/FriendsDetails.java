package com.example.agupta1409.gangup;

import android.content.Intent;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

public class FriendsDetails {


    public static class friend {
        String memberName;
        int profilePic;
        String emailID;
        String phoneNo;

        public friend(String name, int image, String emailID, String phoneNo) {
            this.memberName = name;
            this.profilePic = image;
            this.emailID = emailID;
            this.phoneNo = phoneNo;
        }
    }

    public static ArrayList<friend> getFriendsList(String groupID) {
        ArrayList<FriendsDetails.friend> list = new ArrayList<>(7);
        switch (groupID) {
            case "F.R.I.E.N.D.S.":
                list.add(new friend("Chandler", R.drawable.chandler, "chandler@friends.com", "9999000099"));
                list.add(new friend("Monica", R.drawable.monica, "monica@friends.com", "9999087099"));
                list.add(new friend("Ross", R.drawable.ross, "ross@friends.com", "9991200099"));
                list.add(new friend("Phoebe", R.drawable.phoebe, "phoebe@friends.com", "1099000099"));
                list.add(new friend("Rachel", R.drawable.rachel, "rachel@friends.com", "9889000099"));
                list.add(new friend("Joey", R.drawable.joey, "joey@friends.com", "9800008876"));
                break;
            case "HIMYM":
                list.add(new friend("Ted Mosby", R.drawable.tedmosby, "ted_mosby@himym.com", "8800978654"));
                list.add(new friend("Robin", R.drawable.robin, "robin@himym.com", "8809876554"));
                list.add(new friend("Barney", R.drawable.barney, "barney@himym.com", "8170972654"));
                list.add(new friend("Lily", R.drawable.lily, "lily@himym.com", "9700978654"));
                list.add(new friend("Marshall", R.drawable.marshall, "marshall@himym.com", "9958978654"));
                break;
        }
        return list;
    }
}
