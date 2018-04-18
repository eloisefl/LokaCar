package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eechedelongchamp2017.lokacar.bo.Gerant;
import com.example.eechedelongchamp2017.lokacar.dal.GerantDao;

import java.util.ArrayList;
import java.util.List;

public class AuthActivity extends AppCompatActivity {
    private GerantDao gerantDao;
    private EditText editionLogin;
    private List<Gerant> listeGerant;
    private EditText editionMdp;
 //   private Button boutonValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // On va chercher la Liste des Gérants dans la BDD pour vérifier l'authentification :
        listeGerant = new ArrayList <>();
        gerantDao = new GerantDao(AuthActivity.this);
        listeGerant = gerantDao.selectAll();
    }

    public void onValidationClick(View view){
        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
        editionLogin = (EditText) findViewById(R.id.editLogin);
        editionMdp = (EditText) findViewById(R.id.editMdp);
        //  boutonValidation = (Button) findViewById(R.id.buttonValidation);

        for (Gerant gerant:listeGerant) {
            if ( gerant.getLogin().toString().equalsIgnoreCase(editionLogin.getText().toString())
                 &&
                 gerant.getMdp().toString().equalsIgnoreCase(editionMdp.getText().toString()) )
            {
                intent.putExtra("gerant", gerant.getNom()+ " " + gerant.getPrenom());
                startActivity(intent);
            }
        }

    }
}
