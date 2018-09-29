package com.example.admin.myapplication1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper  extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String query="create table Teachers (id integer primary key ,name varchar(20),contactNo long,password varchar(20));";
   db.execSQL(query);
        query="create table Students (rollNo integer primary key ,name varchar(20),contactNo long,password varchar(20),flag integer);";
        db.execSQL(query);
        query="create table Attendance (rollNo integer primary key ,subject1 integer,subject2 integer,subject3 integer,subject4 integer,subject5 integer,foreign key (rollNo) references Students(rollNo));";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
