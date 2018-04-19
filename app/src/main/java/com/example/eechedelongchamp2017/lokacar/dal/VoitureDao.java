package com.example.eechedelongchamp2017.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eechedelongchamp2017.lokacar.bo.Agence;
import com.example.eechedelongchamp2017.lokacar.bo.DataContract;
import com.example.eechedelongchamp2017.lokacar.bo.Location;
import com.example.eechedelongchamp2017.lokacar.bo.Marque;
import com.example.eechedelongchamp2017.lokacar.bo.TypeLocatif;
import com.example.eechedelongchamp2017.lokacar.bo.Voiture;
import com.example.eechedelongchamp2017.lokacar.helper.GestionBddHelper;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class VoitureDao {

    private GestionBddHelper dbHelper;

    public VoitureDao(Context context) {
        this.dbHelper = new GestionBddHelper(context);
    }

    // Get ContentValues
    private ContentValues getContentValues(Voiture voiture) {

        ContentValues values = new ContentValues();
        values.put(DataContract._IMMATRICULATION, voiture.getImmatriculation());
        values.put(DataContract._NBPLACES, voiture.getNbPlaces());
        values.put(DataContract._NBPORTES, voiture.getNbPortes());

        if (voiture.isEssence()) values.put(DataContract._IS_ESSENCE, 1);
        else values.put(DataContract._IS_ESSENCE, 0);

        if (voiture.isDiesel()) values.put(DataContract._IS_DIESEL, 1);
        else values.put(DataContract._IS_DIESEL, 0);

        values.put(DataContract._PUISSANCE_MOTEUR, voiture.getPuissanceMoteur());

        if (voiture.isLoue()) values.put(DataContract._IS_LOUE, 1);
        else values.put(DataContract._IS_LOUE, 0);

        if (voiture.isDisponible()) values.put(DataContract._IS_DISPONIBLE, 1);
        else values.put(DataContract._IS_DISPONIBLE, 0);

        values.put(DataContract._PHOTO_NOM, voiture.getPhotoNom());

        /*
        URL url = new URL("http://sree.cc/wp-content/uploads/schogini_team.png");
        URLConnection ucon = url.openConnection();
        InputStream is = ucon.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is,128);
        ByteArrayBuffer barb= new ByteArrayBuffer(128);

        int current = 0;
        while ((current = bis.read()) != -1) {
            barb.append((byte) current);
        }

        values.put(DataContract._PHOTO_CONTENT, barb.toByteArray());
         */

        values.put(DataContract._ID_MARQUE, voiture.getMarque().getId());
        values.put(DataContract._ID_TYPE_LOCATIF, voiture.getTypeLocatif().getId());
        values.put(DataContract._ID_AGENCE, voiture.getAgence().getId());

        return values;
    }

    // Get Voiture from cursor
    private Voiture getVoiture(Cursor cursor) {

        boolean isEssence = false, isDiesel = false, isLoue = false, isDisponible = true;

        String immatriculation = cursor.getString(cursor.getColumnIndex(DataContract._IMMATRICULATION));
        int nbPortes = cursor.getInt(cursor.getColumnIndex(DataContract._NBPORTES));
        int nbPlaces = cursor.getInt(cursor.getColumnIndex(DataContract._NBPLACES));
        int puissanceMoteur = cursor.getInt(cursor.getColumnIndex(DataContract._PUISSANCE_MOTEUR));
        String photoNom = cursor.getString(cursor.getColumnIndex(DataContract._PHOTO_NOM));

        if (cursor.getInt(cursor.getColumnIndex(DataContract._IS_ESSENCE)) == 1)
            isEssence = true;

        if (cursor.getInt(cursor.getColumnIndex(DataContract._NBPLACES)) == 1)
            isDiesel = true;

        if (cursor.getInt(cursor.getColumnIndex(DataContract._IS_LOUE)) == 1)
            isLoue = true;

        if (cursor.getInt(cursor.getColumnIndex(DataContract._IS_DISPONIBLE)) != 1)
            isDisponible = false;

        Blob photoContent = null;
        Marque marque = null;
        TypeLocatif typeLocatif = null;
        List<Location> locations = null;
        Agence agence = null;

        return new Voiture(immatriculation, nbPortes, nbPlaces, isEssence, isDiesel, puissanceMoteur, marque,
                isLoue, isDisponible, photoNom, photoContent, typeLocatif, locations, agence);

    }

    // Select all
    public List<Voiture> selectAll() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_VOITURE,
                null,
                null,
                null,
                null,
                null,
                DataContract._ID_MARQUE);

        List<Voiture> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){

            while (cursor.moveToNext()) {
                objects.add(getVoiture(cursor));
            }

            cursor.close();
        }

        return objects;

    }

    // Select all par Agence
    public List<Voiture> selectAllbyAgence(int idAgence) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_VOITURE,
                null,
                DataContract._ID_AGENCE+" = ?",
                new String[]{""+idAgence},
                null,
                null,
                DataContract._ID_MARQUE);

        List<Voiture> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){

            while (cursor.moveToNext()) {
                objects.add(getVoiture(cursor));
            }

            cursor.close();
        }

        return objects;
    }

    // Select all par Modele
    /*
    public List<Voiture> selectAllbyModele(int idModele) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_VOITURE,
                null,
                DataContract.COL_ID + " = ?",
                new String[]{""+idModele},
                null,
                null,
                DataContract._ID_MARQUE);

        List<Voiture> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){

            while (cursor.moveToNext()) {
                objects.add(getVoiture(cursor));
            }

            cursor.close();
        }

        return objects;
    }
    */

    // Insert
    public void insert(Voiture voiture){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(DataContract.NOM_TABLE_VOITURE, null, getContentValues(voiture));
        db.close();
    }

    // Insert or Update
    public void insertOrUpdate(Voiture voiture){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.query(DataContract.CREATE_TABLE_VOITURE, null,
                DataContract._IMMATRICULATION+" = "+voiture.getImmatriculation(),
                null,null,null,null);

        if(c.getCount() > 0){
            update(voiture);
        }
        else {
            insert(voiture);
        }

        c.close();
        db.close();
    }

    public void update(Voiture voiture) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.update(DataContract.NOM_TABLE_VOITURE, getContentValues(voiture),
                DataContract._IMMATRICULATION + " = " + voiture.getImmatriculation(),
                null);
        db.close();
    }

}
