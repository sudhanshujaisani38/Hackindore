package com.example.admin.myapplication1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class UploadAttendanceActivity extends AppCompatActivity {
private ListView listView;
private Button button;
private ArrayList<String> arrayList=new ArrayList<>();
ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendancelist);
        listView=(ListView)findViewById(R.id.listView);
        AttendanceAdapter attendanceAdapter=new AttendanceAdapter();
        listView.setAdapter(attendanceAdapter);
        button=(Button)findViewById(R.id.submitAttendance);

        MySQLiteOpenHelper mySQLiteOpenHelper=new MySQLiteOpenHelper(getApplicationContext(),"TeachersFeedbackDB",null,1);
        SQLiteDatabase db= mySQLiteOpenHelper.getReadableDatabase();
        String query="select name from Students;";
        Cursor cursor=null;
        try{
            cursor=db.rawQuery(query,null);}
        catch(Exception e){
            //Toast.makeText(TeacherLoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        while (cursor.moveToNext()){
            arrayList.add(cursor.getString(cursor.getColumnIndex("name")));
            attendanceAdapter.notifyDataSetChanged();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //selct phone no from table where boolean = true;
                //send message to all these nos
                //for all booleans->set boolean=false
                MySQLiteOpenHelper mySQLiteOpenHelper=new MySQLiteOpenHelper(getApplicationContext(),"TeachersFeedbackDB",null,1);
                SQLiteDatabase db= mySQLiteOpenHelper.getReadableDatabase();
                String query="select contactNo from Students where flag=1";
                Cursor cursor=db.rawQuery(query,null);
                while (cursor.moveToNext())
                {
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(cursor.getLong(cursor.getColumnIndex("contactNo"))+"",null,"Give your feedback on our app and check your attendance",null,null);
                }
db.close();
            }
        });
    }

    class AttendanceAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if(view==null)
            {
                LayoutInflater layoutInflater=getLayoutInflater();
                view=layoutInflater.inflate(R.layout.attendance_entry,null);
            }
            final TextView textView=(TextView)view.findViewById(R.id.textView3);
            textView.setText(arrayList.get(position));
            CheckBox checkBox=(CheckBox)view.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)//set boolean=true
                    {
                        MySQLiteOpenHelper mySQLiteOpenHelper=new MySQLiteOpenHelper(getApplicationContext(),"TeachersFeedbackDB",null,1);
                        SQLiteDatabase db= mySQLiteOpenHelper.getWritableDatabase();

                        String query="update Students set flag=1 where name = '"+textView.getText().toString()+"'";
                        db.execSQL(query);
                    }
                }
            });
            return view;
        }
    }
}
