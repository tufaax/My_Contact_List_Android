package com.example.mycontactlist;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLClientInfoException;

public class ContactDBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION = 4;

    private static final String CREATE_TABLE_CONTACT =
            "create table contact (_id integer primary key autoincrement, "
            + "contactname text not null, streetaddress text, "
            + "city text, state text, zipcode text, "
            + "phonenumber text, cellnumber text, "
            + "email text, birthday text);";

     public ContactDBHelper(Context context){
         super(context, DATABASE_NAME,null, DATABASE_VERSION);
     }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL("DROP TABLE contact");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

         Log.w(ContactDBHelper.class.getName(),
                 "Upgrading database from versiong" + oldVersion + " to "
         + newVersion + ", which will destroy all old data");
         onCreate(db);
    }
}


