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

public class Exercise_Shoulders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_shoulders);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_handbook);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(Exercise_Shoulders.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Exercise_Shoulders.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Exercise_Shoulders.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        openExercise(R.id.ArnoldPress, "Arnold Press", R.raw.arnold_press,
                "1. Sit holding dumbbells at shoulder height, palms facing you.\n2. Press upward while rotating palms forward.\n3. Lower back down with control, rotating back.");

        openExercise(R.id.BarbellUprightRow, "Barbell Upright Row", R.raw.barbell_upright_row,
                "1. Stand holding a barbell with an overhand grip.\n2. Pull the bar up toward your chin, elbows leading.\n3. Lower back down with control.");

        openExercise(R.id.DumbellRaise, "Dumbbell Raise", R.raw.dumbell_raise,
                "1. Stand holding dumbbells at your sides.\n2. Raise your arms out to shoulder height.\n3. Lower back down with control.");

        openExercise(R.id.RearDelt, "Rear Delt", R.raw.rear_delt,
                "1. Sit on the rear delt machine, chest against the pad.\n2. Pull the handles back, squeezing your shoulder blades.\n3. Return slowly to the starting position.");

        openExercise(R.id.ReverseFly, "Reverse Fly", R.raw.reverse_fly,
                "1. Bend forward slightly holding dumbbells, arms hanging down.\n2. Raise your arms out to the sides, squeezing your shoulder blades.\n3. Lower back down with control.");

        openExercise(R.id.LateralRaise, "Lateral Raise", R.raw.lateral_raise,
                "1. Stand holding dumbbells at your sides.\n2. Raise your arms out to the sides until shoulder height.\n3. Lower back down with control.");

        openExercise(R.id.OverHeadPress, "Overhead Press", R.raw.overhead_press,
                "1. Stand holding a barbell at shoulder height.\n2. Press the bar overhead until arms are extended.\n3. Lower back down to shoulder height.");
    }

    private void openExercise(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        card.setOnClickListener(v -> {
            Intent intent = new Intent(Exercise_Shoulders.this, Workout_Info.class);
            intent.putExtra(Workout_Info.EXTRA_TITLE, title);
            intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
            intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
            startActivity(intent);
        });
    }
}