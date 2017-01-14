package com.example.agupta1409.gangup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
    EditText groupName;
    EditText groupKey;
    Button createGroup;
    public static final String NEW_GROUP_ID = "groupID";
    public static final String NEW_GROUP_KEY = "groupKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        groupName = (EditText) findViewById(R.id.et_group_name);
        groupKey = (EditText) findViewById(R.id.et_group_key);

    }

    public void gotoMainAgain(View v) {
        GroupDetails.addGroup(groupName.getText().toString(),groupKey.getText().toString());
        Toast.makeText(Register.this, "Group as been created.Login Again", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        i.setAction(Intent.ACTION_VIEW);
        i.putExtra(NEW_GROUP_ID,groupName.getText().toString());
        i.putExtra(NEW_GROUP_KEY,groupKey.getText().toString());
        startActivity(i);
    }
}
