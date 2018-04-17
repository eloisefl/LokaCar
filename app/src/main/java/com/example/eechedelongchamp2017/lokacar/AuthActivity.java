package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {
    private EditText editionLogin;
 //   private EditText editionMdp;
 //   private Button boutonValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }

    public void onValidationClick(View view){
        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
        editionLogin = (EditText) findViewById(R.id.editLogin);
      //  editionMdp = (EditText) findViewById(R.id.editMdp);
      //  boutonValidation = (Button) findViewById(R.id.buttonValidation);

        intent.putExtra("gerant", editionLogin.getText().toString());
        startActivity(intent);
    }
}
