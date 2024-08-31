package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button buttonCategories=findViewById(R.id.buttonCategories);
        buttonCategories.setOnClickListener(v -> goToCategories());

        Button buttonStatistics=findViewById(R.id.buttonStatistics);
        buttonStatistics.setOnClickListener(v -> goToStatistics());

        Button buttonTips=findViewById(R.id.buttonTips);
        buttonTips.setOnClickListener(v -> goToTips());

        Button buttonRecyclingRegister=findViewById(R.id.buttonRecyclingRegister);
        buttonRecyclingRegister.setOnClickListener(v -> goToRecyclingRegister());

    }


    public void goToCategories() {
        Intent intent = new Intent(this,Categories.class);
        startActivity(intent);

    }

    public void goToStatistics() {
        Intent intent = new Intent(this,Statistics.class);
        startActivity(intent);

    }

    public void goToTips() {
        Intent intent = new Intent(this,Tips.class);
        startActivity(intent);

    }

    public void goToRecyclingRegister() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}