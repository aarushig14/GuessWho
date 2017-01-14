package com.example.agupta1409.gangup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class EnlargedImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarged_image);

        Intent recieved_intent = new Intent();
        ImageView image = (ImageView) findViewById(R.id.enlarged_image);
        int imageRes = recieved_intent.getIntExtra(Moment.IMAGE_ID,0);
        if(imageRes!=0) {
            image.setImageResource(imageRes);
        }else{
            Toast.makeText(EnlargedImage.this,"Image not Loaded",Toast.LENGTH_SHORT).show();
        }
        Button btnShare = (Button) findViewById(R.id.button_share);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_STREAM,R.id.enlarged_image);
                i.setType("image/*");
                startActivity(Intent.createChooser(i,"Share image to..."));
            }
        });

    }
}
