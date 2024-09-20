package com.test.mad_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dphelp extends SQLiteOpenHelper
{
    private static final String dbname="patients1.db";
    private static final int version = 1;

    public dphelp( Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table patients(id integer primary key autoincrement,name text,address text,phone text,total_bill text,date text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS patients");
        onCreate(db);
    }

    public String addRecord(String p1, String p2, String p3, String p4,String p5)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",p1);
        cv.put("address",p2);
        cv.put("phone",p3);
        cv.put("total_bill",p4);
        cv.put("Date",p5);
     long res= db.insert(" patients",null,cv);
        if(res== -1)
        {
            return "failed";
        }
        else
            return "sucessfully insert";
    }

}
