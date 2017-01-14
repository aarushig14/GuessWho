package com.example.agupta1409.gangup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    String groupID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent recieved_Intent = getIntent();
        groupID = recieved_Intent.getStringExtra(MainActivity.GROUP_ID);
        ((TextView) findViewById(R.id.tv_group_name)).setText(groupID);

    }

    public void gotoKnowYourFriends(View view) {
        Intent i = new Intent(this, KnowYourFriends.class);
        i.setAction(Intent.ACTION_VIEW);
        i.putExtra(MainActivity.GROUP_ID, groupID);
        startActivity(i);
    }

    public void gotoEvents(View view) {
        Intent i = new Intent(this, Events.class);
        i.setAction(Intent.ACTION_VIEW);
        i.putExtra(MainActivity.GROUP_ID, groupID);
        startActivity(i);
    }

    public void gotoMoments(View view) {
        Intent i = new Intent(this, Moment.class);
        i.setAction(Intent.ACTION_VIEW);
        i.putExtra(MainActivity.GROUP_ID, groupID);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Main2Activity.this,"You have been Logged out.Login Again",Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}
