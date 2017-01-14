package com.example.agupta1409.gangup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText key;
    public final static String GROUP_ID = "groupID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.groupID);
        key = (EditText) findViewById(R.id.groupKey);

        if(!getIntent().hasCategory(LAUNCHER_APPS_SERVICE)) {
            Intent recieved_intent = getIntent();
            name.setText(recieved_intent.getStringExtra(Register.NEW_GROUP_ID));
            key.setText(recieved_intent.getStringExtra(Register.NEW_GROUP_KEY));
        }

    }

    public void gotoRegister(View view) {

        Intent i = new Intent(this, Register.class);
        i.setAction(Intent.ACTION_VIEW);
        startActivity(i);

    }

    public void gotoMain(View view) {

        String groupID = name.getText().toString();
        String groupKey = key.getText().toString();

        if(groupKey.equals(GroupDetails.getKey(groupID))) {
            Intent i = new Intent(this, Main2Activity.class);
            i.setAction(Intent.ACTION_VIEW);
            i.putExtra(GROUP_ID,groupID);
            startActivity(i);
        }else{
            Toast.makeText(MainActivity.this,"No Such Group Exists",Toast.LENGTH_SHORT).show();
        }

    }

    public void resetData(View view){
        name.setText("");
        key.setText("");
    }
}
