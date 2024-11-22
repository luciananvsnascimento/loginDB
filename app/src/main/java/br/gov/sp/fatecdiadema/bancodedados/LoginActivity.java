package br.gov.sp.fatecdiadema.bancodedados;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUsername = findViewById(R.id.textInEdUserT1);
        EditText edtPassword = findViewById(R.id.textInEdSenhaT1);
        Button btnLogin = findViewById(R.id.loginButton);

        btnLogin.setOnClickListener(view -> {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();

            // Simulação de validação
            if ("admin".equals(username) && "1234".equals(password)) {
                Intent intent = new Intent(LoginActivity.this, MainActivityOk.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
