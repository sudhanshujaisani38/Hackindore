package com.example.admin.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectClassActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button button;
    private  ArrayList<String> arrayList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_class);
        arrayList.add("CSA");
        arrayList.add("CSB");
        arrayList.add("CSC");
//String arrayList[]=new String[]{"CSA","CSB","CSC"};
        spinner=(Spinner)findViewById(R.id.spinner);
        button=(Button)findViewById(R.id.button2);
        ArrayAdapter<String> arrayAdapter=
                new ArrayAdapter<String>(this ,android.R.layout.simple_spinner_item,arrayList);
        spinner.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectClassActivity.this,UploadAttendanceActivity.class);
              //  intent.putExtra("classname",spinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
}
