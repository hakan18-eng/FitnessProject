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

public class Gender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.nav_handbook);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Intent intent = new Intent(Gender.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            else if (id == R.id.nav_handbook) {
                Intent intent = new Intent(Gender.this, Handbook.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            else if (id == R.id.nav_profile) {
                Intent intent = new Intent(Gender.this, Profile.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });

        setupCard(R.id.cardMale, Workout_Plan.class);
        setupCard(R.id.cardFemale, Workout_plan_female.class);
    }

    private void setupCard(int viewId, Class<?> targetActivity) {
        CardView card = findViewById(viewId);
        card.setOnClickListener(v -> {
            Intent intent = new Intent(Gender.this, targetActivity);
            startActivity(intent);
        });
    }
}