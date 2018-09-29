package com.example.admin.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class TeacherViewActivity extends AppCompatActivity {
    private ImageButton imageButton,imageButton2,imageButton3,imageButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_view);
        imageButton=(ImageButton)findViewById(R.id.imageButton3);
        imageButton2=(ImageButton)findViewById(R.id.imageButton4);
        imageButton3=(ImageButton)findViewById(R.id.imageButton5);
        imageButton4=(ImageButton)findViewById(R.id.imageButton6);
        final Intent prevIntent=getIntent();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),TeacherProfileActivity.class);
                intent.putExtra("Name",prevIntent.getStringExtra("Name"));
                intent.putExtra("Contact no.",prevIntent.getLongExtra("Contact no.",0));
                intent.putExtra("Id.",prevIntent.getIntExtra("Id.",0));


                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Intent intent=new Intent(getApplicationContext(),ViewFeedbacks.class;);
               // startActivity(intent);
                Toast.makeText(TeacherViewActivity.this, "Ye abhi nhi kia hai", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), FeedbacksVisualizationApp.class);

                startActivity(intent);

            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),UploadTimetableActivity.class);
                startActivity(intent);


            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherViewActivity.this,SelectClassActivity.class);
                startActivity(intent);
            }
        });
    }
}
