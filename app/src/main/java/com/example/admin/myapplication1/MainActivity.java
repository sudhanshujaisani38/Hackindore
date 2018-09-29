package com.example.admin.myapplication1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton,imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton=(ImageButton)findViewById(R.id.imageButton);
        imageButton2=(ImageButton)findViewById(R.id.imageButton2);
        MySQLiteOpenHelper msoh=new MySQLiteOpenHelper(getApplicationContext(),"TeachersFeedbackDB",null,1);
        SQLiteDatabase db=msoh.getWritableDatabase();
        try{
            String stri="delete  from Teachers";
            db.execSQL(stri);
            stri="delete from Students";
            db.execSQL(stri);
            Toast.makeText(this, "Succesful", Toast.LENGTH_SHORT).show();
        String query="insert into Teachers values(345,'sudhanshu',8989511025,'Sudh2731')";
        db.execSQL(query);
         query="insert into Teachers values(357,'romil',9424674483,'romil2731')";
        db.execSQL(query);
         query="insert into Teachers values(372,'prachi',9179041964,'prachi2731')";
        db.execSQL(query);
        query="insert into Teachers values(926,'nitya',8989934174,'nitya2731')";
        db.execSQL(query);
            query="insert into Teachers values(376,'shivank',8945934174,'shivank2731')";
            db.execSQL(query);
        query="insert into Students values(342,'somya',8989511025,'somya2731',0)";
        db.execSQL(query);
        query="insert into Students values(354,'parth',9424674483,'parth2731',0)";
        db.execSQL(query);
        query="insert into Students values(386,'vrinda',8923434174,'vrinda2731',0)";
        db.execSQL(query);
        query="insert into Students values(404,'om',8989933014,'om2731',0)";
        db.execSQL(query);
        query="select * from Teachers";
        db.close();
        db=msoh.getReadableDatabase();
            String str=db.rawQuery(query,null).getCount()+"";
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            db.close();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,TeacherLoginActivity.class);
                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
