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

public class TeacherLoginActivity extends AppCompatActivity {
private EditText editText,editText2;
private Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);
        editText=(EditText)findViewById(R.id.email);
        editText2=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.email_sign_in_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQLiteOpenHelper mySQLiteOpenHelper=new MySQLiteOpenHelper(getApplicationContext(),"TeachersFeedbackDB",null,1);
                SQLiteDatabase db= mySQLiteOpenHelper.getReadableDatabase();
                //String temp="select * from Teachers";
                ///db.rawQuery(temp,null);
                //Toast.makeText(TeacherLoginActivity.this, db.rawQuery(temp,null).getCount()+"", Toast.LENGTH_SHORT).show();
                String query="select * from Teachers where id="+editText.getText().toString()+" and password='"+editText2.getText().toString()+"'";
            Cursor cursor=null;
                Toast.makeText(TeacherLoginActivity.this, query, Toast.LENGTH_SHORT).show();
             try{
                 cursor=db.rawQuery(query,null);}
                catch(Exception e){
                    Toast.makeText(TeacherLoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
             if(cursor!=null )

             {
                 Toast.makeText(TeacherLoginActivity.this, cursor.getCount()+" "+cursor.moveToPosition(0), Toast.LENGTH_SHORT).show();

Intent intent=null;
               try{  intent=new Intent(getApplicationContext(),TeacherViewActivity.class);
                 intent.putExtra("Name",cursor.getString(cursor.getColumnIndex("name")));
                  // Toast.makeText(TeacherLoginActivity.this, cursor.getString(cursor.getColumnIndex(""))+"Not a blankToast", Toast.LENGTH_LONG).show();
                 intent.putExtra("Contact no.",cursor.getLong(cursor.getColumnIndex("contactNo")));
                 intent.putExtra("Id.",cursor.getInt(cursor.getColumnIndex("id")));
                 db.close();}catch (Exception e){
                   Toast.makeText(TeacherLoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
               }
             startActivity(intent);
                 finish();}
                 else Toast.makeText(TeacherLoginActivity.this, "Invalid id/password", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
