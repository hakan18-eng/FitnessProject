package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Exercice extends AppCompatActivity {

    CardView chest, back, legs, shoulders, biceps, triceps,
            forearm, abs, gluteus, cardio;

    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_handbook);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(Exercice.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Exercice.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Exercice.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        boolean isAddingMode = getIntent().hasExtra("MODE") &&
                "ADD_EXERCISE".equals(getIntent().getStringExtra("MODE"));

        chest = findViewById(R.id.cardChestMenu);
        back = findViewById(R.id.cardBackMenu);
        legs = findViewById(R.id.cardLegsMenu);
        shoulders = findViewById(R.id.CardShouldersMenu);
        biceps = findViewById(R.id.cardBicepsMenu);
        triceps = findViewById(R.id.cardTricepsMenu);
        forearm = findViewById(R.id.cardForearmMenu);
        abs = findViewById(R.id.cardAbsMenu);
        gluteus = findViewById(R.id.cardGluteusMenu);
        cardio = findViewById(R.id.cardCardioMenu);

        chest.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Chest_Add.class));
            else startActivity(new Intent(this, Exercise_Chest.class));
        });

        back.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Ecercise_Back_Add.class));
            else startActivity(new Intent(this, Exercise_Back.class));
        });

        legs.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Legs_Add.class));
            else startActivity(new Intent(this, Exercise_Legs.class));
        });

        shoulders.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Shoulders_Add.class));
            else startActivity(new Intent(this, Exercise_Shoulders.class));
        });

        biceps.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Biceps_Add.class));
            else startActivity(new Intent(this, Exercise_Biceps.class));
        });

        triceps.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Triceps_Add.class));
            else startActivity(new Intent(this, Exercise_Triceps.class));
        });

        forearm.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Forearm_Add.class));
            else startActivity(new Intent(this, Exercise_Forearm.class));
        });

        abs.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Abs_Add.class));
            else startActivity(new Intent(this, Exercise_Abs.class));
        });

        gluteus.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Gluteus_Add.class));
            else startActivity(new Intent(this, Exercise_Gluteus.class));
        });

        cardio.setOnClickListener(v -> {
            if (isAddingMode) startActivity(new Intent(this, Exercise_Cardio_Add.class));
            else startActivity(new Intent(this, Exercise_Cardio.class));
        });
    }
}