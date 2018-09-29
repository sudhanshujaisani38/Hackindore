package com.example.admin.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TeacherProfileActivity extends AppCompatActivity {
    TextView textView,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        textView=(TextView)findViewById(R.id.name);
        textView2=(TextView)findViewById(R.id.contact);
        textView3=(TextView)findViewById(R.id.Designation);
        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("Name"));
        textView2.setText(intent.getLongExtra("Contact no.",0)+"");
        textView3.setText(intent.getIntExtra("Id.",0));
        //read from db and update textViews
    }
}
