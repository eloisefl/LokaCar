package com.example.eechedelongchamp2017.lokacar.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GestionBddHelper extends SQLiteOpenHelper{
    public final static  String TABLE_NAME = "Gerant";
    private final static String DATABASE_NAME = "LokaCar.db";
    private final static int DATABASE_VERSION = 1;

    public final static String COL_ID = "ID";
    public final static String COL_LOGIN = "LOGIN";
    public final static String COL_MDP = "MDP";

    public GestionBddHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_LOGIN + " TEXT ,"
                + COL_MDP + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
