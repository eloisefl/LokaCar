package com.example.eechedelongchamp2017.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eechedelongchamp2017.lokacar.bo.DataContract;
import com.example.eechedelongchamp2017.lokacar.bo.Marque;
import com.example.eechedelongchamp2017.lokacar.bo.TypeLocatif;
import com.example.eechedelongchamp2017.lokacar.helper.GestionBddHelper;

import java.util.ArrayList;
import java.util.List;

public class MarqueDao {

    private GestionBddHelper dbHelper;

    public MarqueDao(Context context) {
        this.dbHelper = new GestionBddHelper(context);
    }

    // Get ContentValues (without id)
    private ContentValues getContentValues(Marque obj) {
        ContentValues values = new ContentValues();
        values.put(DataContract.COL_NOM, obj.getNom());
        return values;
    }

    // Get Marque from cursor
    private Marque getMarque(Cursor cursor) {

        int id = cursor.getInt(cursor.getColumnIndex(DataContract.COL_ID));
        String nom = cursor.getString(cursor.getColumnIndex(DataContract.COL_NOM));

        return new Marque(id, nom);

    }

    // select all
    public List<Marque> selectAll() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_MARQUE,
                null,
                null,
                null,
                null,
                null,
                null);

        List<Marque> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                objects.add(getMarque(cursor));
            }
            cursor.close();
        }

        return objects;
    }

    // select by id
    public Marque selectById(int id) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Marque marque = null;

        Cursor cursor = db.query(
                DataContract.NOM_TABLE_MARQUE,
                null,
                DataContract.COL_ID + " = " + id,
                null,
                null,
                null,
                null);

        if(cursor != null && cursor.moveToFirst()){
            marque = getMarque(cursor);
            cursor.close();
        }

        return marque;
    }

    // Insert
    public void insert(Marque obj){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert(DataContract.NOM_TABLE_MARQUE, null, getContentValues(obj));
        obj.setId((int)id);
        db.close();
    }

    // Delete
    public int delete(int id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int res = db.delete(DataContract.NOM_TABLE_MARQUE,
                DataContract.COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        return res;

    }
}
