package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.eechedelongchamp2017.lokacar.adapter.MesVoituresGenreAdapter;
import com.example.eechedelongchamp2017.lokacar.adapter.RecycledVoituresAdapter;
import com.example.eechedelongchamp2017.lokacar.adapter.RecycledVoituresGenreAdapter;
import com.example.eechedelongchamp2017.lokacar.bo.Marque;
import com.example.eechedelongchamp2017.lokacar.bo.Modele;
import com.example.eechedelongchamp2017.lokacar.bo.Voiture;
import com.example.eechedelongchamp2017.lokacar.dal.VoitureDao;
import com.example.eechedelongchamp2017.lokacar.fragments.ListeVoitureGenreFragment;
import com.example.eechedelongchamp2017.lokacar.fragments.ListeVoituresFragment;
import com.example.eechedelongchamp2017.lokacar.fragments.MesVoitureGenreFragment;

import java.util.ArrayList;
import java.util.List;

public class MesVoituresActivity extends AppCompatActivity
    implements
        ListeVoituresFragment.OnListFragmentInteractionListener,
        MesVoitureGenreFragment.OnFragmentInteractionListener
{

    private ListeVoituresFragment voituresFragment;
    private MesVoitureGenreFragment voituresGenreFragment;
    private ListView listview_voituresgenres;
    private MesVoituresGenreAdapter adapter;

    private String LOG_TAG = "TAG_LOKACAR";

    private VoitureDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_voitures);

        // Récuperation des deux fragments
        voituresFragment = (ListeVoituresFragment) getSupportFragmentManager()
                .findFragmentById(R.id.voiture_fragment);
        voituresGenreFragment = (MesVoitureGenreFragment) getSupportFragmentManager()
                .findFragmentById(R.id.voiture_genre_fragment);

        // Données Fragment
        dao = new VoitureDao(MesVoituresActivity.this);
        List<Voiture> list = dao.selectAll();
        voituresFragment.setAdapteer(new RecycledVoituresAdapter(list,MesVoituresActivity.this));

        // Données ListeView
        if (voituresGenreFragment != null && voituresGenreFragment.isInLayout()) {
            listview_voituresgenres = findViewById(R.id.listview_voituresgenres);
            adapter = new MesVoituresGenreAdapter(MesVoituresActivity.this, R.layout.fragment_mes_voiture_genre_content, list);
            listview_voituresgenres.setAdapter(adapter);
        }
    }

    // Ajout du menu principal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(MesVoituresActivity.this);
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Selection des items du menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mes_voitures:
                // ne rien faire
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    // Implementation VoituresListFragment
    @Override
    public void onListFragmentInteraction(Voiture item) {

        // adapter = new MesVoituresGenreAdapter(MesVoituresActivity.this, R.layout.fragment_mes_voiture_genre_content, list);
        // listview_voituresgenres.setAdapter(adapter);

        Intent intent = new Intent(MesVoituresActivity.this, MesVoituresGenreActivity.class);
        intent.putExtra("voiture", item);
        startActivity(intent);

    }

    // Implementation VoituresGenreListFragment
    @Override
    public void onFragmentInteraction(Uri uri) {

    }



}
