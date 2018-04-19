package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eechedelongchamp2017.lokacar.bo.Agence;
import com.example.eechedelongchamp2017.lokacar.bo.DataContract;
import com.example.eechedelongchamp2017.lokacar.bo.Gerant;
import com.example.eechedelongchamp2017.lokacar.bo.Marque;
import com.example.eechedelongchamp2017.lokacar.bo.Tarif;
import com.example.eechedelongchamp2017.lokacar.bo.TypeLocatif;
import com.example.eechedelongchamp2017.lokacar.dal.AgenceDao;
import com.example.eechedelongchamp2017.lokacar.dal.GerantDao;
import com.example.eechedelongchamp2017.lokacar.dal.MarqueDao;
import com.example.eechedelongchamp2017.lokacar.dal.TarifDao;
import com.example.eechedelongchamp2017.lokacar.dal.TypeLocatifDao;

import java.util.ArrayList;
import java.util.List;

public class AuthActivity extends AppCompatActivity {
    private GerantDao gerantDao;
    private AgenceDao agenceDao;
    private TextView editionInconnu;
    private EditText editionLogin;
    private List<Gerant> listeGerant;
    private EditText editionMdp;
 //   private Button boutonValidation;

    private MarqueDao daoMarque;
    private TypeLocatifDao daoTypeLoc;
    private TarifDao daoTarif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // Init dao
        gerantDao = new GerantDao(AuthActivity.this);
        daoMarque = new MarqueDao(AuthActivity.this);
        daoTypeLoc = new TypeLocatifDao(AuthActivity.this);
        daoTarif = new TarifDao(AuthActivity.this);

        // Init des données
        initData();

    }

    public void onValidationClick(View view){
        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
        editionInconnu= (TextView) findViewById(R.id.textInconnu);
        editionLogin = (EditText) findViewById(R.id.editLogin);
        editionMdp = (EditText) findViewById(R.id.editMdp);
        //  boutonValidation = (Button) findViewById(R.id.buttonValidation);

        // On va chercher la Liste des Gérants dans la BDD pour vérifier l'authentification :
        listeGerant = new ArrayList <>();
        listeGerant = gerantDao.selectAll();
        for (Gerant gerant:listeGerant) {
            if ( gerant.getLogin().toString().equalsIgnoreCase(editionLogin.getText().toString())
                 &&
                 gerant.getMdp().toString().equalsIgnoreCase(editionMdp.getText().toString()) )
            {
               Log.i("GERANT", gerant.toString());
                agenceDao = new AgenceDao(AuthActivity.this);
                Agence agence = agenceDao.selectById(gerant.getId()) ;
                intent.putExtra("nomAgence", agence.getNomAgence());
                intent.putExtra("gerant", gerant.getNom() + " " + gerant.getPrenom());
                startActivity(intent);
                break;
            }else {
                editionInconnu.setVisibility(View.VISIBLE);
            }
        }
    }

    public void initData() {

        // 1ère insertion dans la base Gérant pour pouvoir s'identifier :
        Gerant gerant = new Gerant("FRECHEDE", "Eloïse", null,
                "0884541628", "eloise.frechede@free.fr", "efrechede", "123");
        gerantDao.insertGerant(gerant);

        // 1ère insertion dans la base Agence :
        Agence agence = new Agence("NANTES", null, new Gerant(1));
        agenceDao = new AgenceDao(AuthActivity.this);
        agenceDao.insertAgence(agence);

        // Insert MARQUES
        daoMarque.insert(new Marque("Renault"));
        daoMarque.insert(new Marque("Nissan"));
        daoMarque.insert(new Marque("Porsche"));
        daoMarque.insert(new Marque("Batmobile"));

        // Insert TYPE LOCATIF & PRIX
        TypeLocatif troisportes = new TypeLocatif("3 portes");
        TypeLocatif cinqportes = new TypeLocatif("5 portes");
        TypeLocatif familiale = new TypeLocatif("familiale");
        daoTypeLoc.insert(troisportes);
        daoTypeLoc.insert(cinqportes);
        daoTypeLoc.insert(familiale);

        daoTarif.insert(new Tarif(40, true, false, troisportes));
        daoTarif.insert(new Tarif(25, false, true, troisportes));
        daoTarif.insert(new Tarif(70, true, false, cinqportes));
        daoTarif.insert(new Tarif(50, false, true, cinqportes));
        daoTarif.insert(new Tarif(100, true, false, familiale));
        daoTarif.insert(new Tarif(70, false, true, familiale));
    }

}
