package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences prefs = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE);
        String loggedEmail = prefs.getString("current_logged_email", null);

        if (loggedEmail != null && !loggedEmail.isEmpty()) {
            String profileName = prefs.getString("name_" + loggedEmail, null);
            if (profileName == null || profileName.isEmpty()) {
                startActivity(new Intent(Login.this, Create_Profile.class));
            } else {
                startActivity(new Intent(Login.this, MainActivity.class));
            }
            finish();
            return;
        }

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginButton);
        TextView registerText = findViewById(R.id.registerText);

        registerText.setOnClickListener(v -> {
            startActivity(new Intent(Login.this, Register.class));
            finish();
        });

        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            String savedPassword = prefs.getString("password_" + email, null);

            if (savedPassword != null && savedPassword.equals(password)) {
                prefs.edit().putString("current_logged_email", email).apply();

                String profileName = prefs.getString("name_" + email, null);

                if (profileName == null || profileName.isEmpty()) {
                    startActivity(new Intent(Login.this, Create_Profile.class));
                } else {
                    startActivity(new Intent(Login.this, MainActivity.class));
                }
                finish();

            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}