package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.eechedelongchamp2017.lokacar.bo.Gerant;
import com.example.eechedelongchamp2017.lokacar.dal.GerantDao;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private GerantDao gerantDao;
    private TextView titre_bienvenue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Definition du nom du gerant dans le TextView
        Intent intent = getIntent();
        titre_bienvenue = findViewById(R.id.titre_bienvenue);
        if (intent != null && intent.getStringExtra("gerant") != null)
            titre_bienvenue.setText(String.format(
                    "Bienvenue %s !", intent.getStringExtra("gerant")));


        /*
         * Google Charting API
         * Camembert & Bars
         * https://developers.google.com/chart/image/docs/gallery/pie_charts
         */
        WebView webviewCamembert = findViewById(R.id.camembert_locations);
        webviewCamembert.loadUrl("http://chart.apis.google.com/chart?cht=p3&chs=376x150&chco=0000FF" +
                "&chd=t:60,40&chdl=louees|disponibles");

        WebView webviewBars = findViewById(R.id.bars_locations);
        webviewBars.loadUrl("http://chart.apis.google.com/chart?cht=bvs&chs=500x200&chco=4D89F9,C6D9FD" +
                "&chd=t:80,10,60,20&chxt=x,y&chxl=0:|Jan|Fev|Mar|Avr");

    }

    // Ajout du menu principal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(MainActivity.this);
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Selection des items du menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mes_voitures:
                Intent intent = new Intent(MainActivity.this, MesVoituresActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickAjouterVoiture(View view) {

        Intent intent = new Intent(MainActivity.this, AjouterVoitureActivity.class);
        startActivity(intent);

    }
}
