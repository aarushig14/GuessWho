package com.example.agupta1409.gangup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddEvent extends AppCompatActivity {

    static final int REQ_IMAGE = 1234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        Button btnUploadImage =  (Button) findViewById(R.id.upload_pic);
        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_INSERT);
                i.setType("image/*");
                startActivityForResult(i,REQ_IMAGE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_IMAGE){
            ImageView imageView = (ImageView) findViewById(R.id.image_event_added);
//            imageView.setImageResource(data.);

        }
    }
}
