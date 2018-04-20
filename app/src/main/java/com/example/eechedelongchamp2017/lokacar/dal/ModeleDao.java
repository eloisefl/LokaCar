package com.example.eechedelongchamp2017.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eechedelongchamp2017.lokacar.bo.DataContract;
import com.example.eechedelongchamp2017.lokacar.bo.Marque;
import com.example.eechedelongchamp2017.lokacar.bo.Modele;
import com.example.eechedelongchamp2017.lokacar.helper.GestionBddHelper;

import java.util.ArrayList;
import java.util.List;

public class ModeleDao {

    private GestionBddHelper dbHelper;
    private MarqueDao daoMarque;

    public ModeleDao(Context context) {
        this.dbHelper = new GestionBddHelper(context);
        daoMarque = new MarqueDao(context);
    }

    // Get ContentValues (without id)
    private ContentValues getContentValues(Modele obj) {
        ContentValues values = new ContentValues();
        values.put(DataContract.COL_NOM, obj.getNom());
        values.put(DataContract._ID_MARQUE, obj.getMarque().getId());
        return values;
    }

    // Get Modele from cursor
    private Modele getModele(Cursor cursor) {

        int id = cursor.getInt(cursor.getColumnIndex(DataContract.COL_ID));
        String nom = cursor.getString(cursor.getColumnIndex(DataContract.COL_NOM));

        int idMarque = cursor.getInt(cursor.getColumnIndex(DataContract._ID_MARQUE));;
        Marque marque = daoMarque.selectById(idMarque);

        return new Modele(id, nom, marque);
    }

    // select all
    public List<Modele> selectAll() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_MODELE,
                null,
                null,
                null,
                null,
                null,
                null);

        List<Modele> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                objects.add(getModele(cursor));
            }
            cursor.close();
        }

        return objects;
    }

    // select all by marque
    public List<Modele> selectAllByMarque(int idMarque) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_MODELE,
                null,
                DataContract._ID_MARQUE+" = "+idMarque,
                null,
                null,
                null,
                null);

        List<Modele> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                objects.add(getModele(cursor));
            }
            cursor.close();
        }

        return objects;
    }

    // select by id
    public Modele selectById(int id) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Modele modele = null;

        Cursor cursor = db.query(
                DataContract.NOM_TABLE_MODELE,
                null,
                DataContract.COL_ID + " = " + id,
                null,
                null,
                null,
                null);

        if(cursor != null && cursor.moveToFirst()){
            modele = getModele(cursor);
            cursor.close();
        }

        return modele;
    }

    // Insert
    public void insert(Modele obj){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert(DataContract.NOM_TABLE_MODELE, null, getContentValues(obj));
        obj.setId((int)id);
        db.close();
    }

    // Delete
    public int delete(int id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int res = db.delete(DataContract.NOM_TABLE_MODELE,
                DataContract.COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        return res;

    }

}
