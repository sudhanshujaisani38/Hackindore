package com.example.admin.myapplication1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLoginActivity extends AppCompatActivity {
    private EditText editText, editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        editText = (EditText) findViewById(R.id.studentlogin2);
        editText2 = (EditText) findViewById(R.id.studentlogin3);
        button = (Button) findViewById(R.id.studentlogin4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQLiteOpenHelper mySQLiteOpenHelper=new MySQLiteOpenHelper(getApplicationContext(),"TeachersFeedbackDB",null,1);
                SQLiteDatabase db= mySQLiteOpenHelper.getReadableDatabase();
                String query="select * from Students where rollNo="+editText.getText().toString()+" and password='"+editText2.getText().toString()+"';";
                Cursor cursor=null;
                try{
                    cursor=db.rawQuery(query,null);}
                catch(Exception e){
                    Toast.makeText(StudentLoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                if(cursor!=null)
                {
                    Toast.makeText(StudentLoginActivity.this, "hello", Toast.LENGTH_SHORT).show();


                    Intent intent=new Intent(getApplicationContext(),StudentProfileActivity.class);
//                    intent.putExtra("Name",cursor.getString(cursor.getColumnIndex("name")));
//                    intent.putExtra("Contact no.",cursor.getLong(cursor.getColumnIndex("contactNo")));
//                    intent.putExtra("Enrollment no.",cursor.getInt(cursor.getColumnIndex("rollNo")));
                    startActivity(intent);
                    db.close();

                    finish();}
                else Toast.makeText(StudentLoginActivity.this, "Invalid id/password", Toast.LENGTH_SHORT).show();


            }
        });

    }
}