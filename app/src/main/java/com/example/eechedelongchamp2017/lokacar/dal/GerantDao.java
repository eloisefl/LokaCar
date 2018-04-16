package com.example.eechedelongchamp2017.lokacar.dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.eechedelongchamp2017.lokacar.bo.Gerant;
import com.example.eechedelongchamp2017.lokacar.helper.GestionBddHelper;


public class GerantDao {
    private SQLiteDatabase db;
    private GestionBddHelper helper;

    public GerantDao (Context context){
        helper = new GestionBddHelper(context);
        db = helper.getWritableDatabase();
    }

    public List<Gerant> selectAll(){
        List<Gerant> listeGerant = new ArrayList<>();

        Cursor c = db.query(
                    GestionBddHelper.TABLE_NAME,
                    new String[]{
                            GestionBddHelper.COL_ID,
                            GestionBddHelper.COL_LOGIN,
                            GestionBddHelper.COL_MDP
                            },
                    null,
                    null,
                    null,
                    null,
                    null
        );

        if (c != null && c.moveToFirst()) {
            do {
                Gerant gerant = new Gerant(
                        c.getInt(c.getColumnIndex(GestionBddHelper.COL_ID)),
                        c.getString(c.getColumnIndex(GestionBddHelper.COL_LOGIN)),
                        c.getString(c.getColumnIndex(GestionBddHelper.COL_MDP))
                );
                listeGerant.add(gerant);
            } while (c.moveToNext());
        }
        return listeGerant;
    }
}
