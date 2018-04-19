package com.example.eechedelongchamp2017.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eechedelongchamp2017.lokacar.bo.DataContract;
import com.example.eechedelongchamp2017.lokacar.bo.TypeLocatif;
import com.example.eechedelongchamp2017.lokacar.helper.GestionBddHelper;

import java.util.ArrayList;
import java.util.List;

public class TypeLocatifDao {

    private GestionBddHelper dbHelper;

    public TypeLocatifDao(Context context) {
        this.dbHelper = new GestionBddHelper(context);
    }

    // Get ContentValues (without id)
    private ContentValues getContentValues(TypeLocatif obj) {
        ContentValues values = new ContentValues();
        values.put(DataContract.COL_NOM, obj.getNom());
        return values;
    }

    // Get TypeLocatif from cursor
    private TypeLocatif getTypeLocatif(Cursor cursor) {

        int id = cursor.getInt(cursor.getColumnIndex(DataContract.COL_ID));
        String nom = cursor.getString(cursor.getColumnIndex(DataContract.COL_NOM));

        return new TypeLocatif(id, nom);

    }

    // select all
    public List<TypeLocatif> selectAll() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_TYPE_LOCATIF,
                null,
                null,
                null,
                null,
                null,
                null);

        List<TypeLocatif> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                objects.add(getTypeLocatif(cursor));
            }
            cursor.close();
        }

        return objects;
    }

    // select by id
    public TypeLocatif selectById(int id) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        TypeLocatif typeLocatif = null;

        Cursor cursor = db.query(
                DataContract.NOM_TABLE_TYPE_LOCATIF,
                null,
                DataContract.COL_ID + " = " + id,
                null,
                null,
                null,
                null);

        if(cursor != null && cursor.moveToFirst()){
            typeLocatif = getTypeLocatif(cursor);
            cursor.close();
        }

        return typeLocatif;
    }

    // Insert
    public void insert(TypeLocatif obj){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert(DataContract.NOM_TABLE_TYPE_LOCATIF, null, getContentValues(obj));
        obj.setId((int)id);
        db.close();
    }

    // Delete
    public int delete(int id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int res = db.delete(DataContract.NOM_TABLE_TYPE_LOCATIF,
                DataContract.COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        return res;

    }

}
