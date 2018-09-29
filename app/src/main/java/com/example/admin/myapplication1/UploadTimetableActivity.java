package com.example.admin.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UploadTimetableActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_timetable);
        imageView=(ImageView)findViewById(R.id.imageView);
        button2=(Button)findViewById(R.id.uploaadTT);
        button=(Button)findViewById(R.id.selectFile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Select image using GalleryPicker
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Upload image into the database
            }
        });
    }
}
