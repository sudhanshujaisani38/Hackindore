package com.example.admin.myapplication1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewAttendanceActivity extends AppCompatActivity {
TextView textView,textView2,textView3,textView4,textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendence);
        textView=(TextView)findViewById(R.id.attendance1);
        textView2=(TextView)findViewById(R.id.attendance2);
        textView3=(TextView)findViewById(R.id.attendance3);
        textView4=(TextView)findViewById(R.id.attendance4);
        textView5=(TextView)findViewById(R.id.attendance5);

        //fetch attendance from db

    }
}
