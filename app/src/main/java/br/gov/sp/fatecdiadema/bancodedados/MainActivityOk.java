package br.gov.sp.fatecdiadema.bancodedados;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityOk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ok);

        Button btnAdministrarUsuarios = findViewById(R.id.btnAdministrarUsuarios);
        Button btnFechar = findViewById(R.id.btnFecharT2);

        btnAdministrarUsuarios.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivityOk.this, MainActivity.class);
            startActivity(intent);
        });
        btnFechar.setOnClickListener(view -> finish());
    }
}
