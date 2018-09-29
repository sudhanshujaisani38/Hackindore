package com.example.admin.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentProfileActivity extends AppCompatActivity {
private TextView textView,textView2,textView3;
private Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_profile);
        textView=(TextView)findViewById(R.id.studentprofile1);
        textView2=(TextView)findViewById(R.id.studentprofile2);
        textView3=(TextView)findViewById(R.id.studentprofile3);
        button1=(Button)findViewById(R.id.studentprofile5);
        button2=(Button)findViewById(R.id.studentprofile6);
        button3=(Button)findViewById(R.id.studentprofile7);
        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("Name"));
        textView2.setText(intent.getStringExtra("Contact no."));
        textView3.setText(intent.getStringExtra("Enrollment no."));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentProfileActivity.this,ViewAttendanceActivity.class);
                startActivity(intent);
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentProfileActivity.this,TimeTableActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentProfileActivity.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
