package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLoginIn=findViewById(R.id.buttonLoginIn);
        buttonLoginIn.setOnClickListener(v -> goToLogin());

        TextView textRegister = findViewById(R.id.textRegister);
        textRegister.setOnClickListener(v -> goToRegister());

    }
    public void goToLogin() {
        Intent intent = new Intent(this,menu.class);
        startActivity(intent);
    }
    public void goToRegister() {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }


}