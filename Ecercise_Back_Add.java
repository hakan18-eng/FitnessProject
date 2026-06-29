package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Ecercise_Back_Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecercise_back_add);

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
                    startActivity(new Intent(Ecercise_Back_Add.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Ecercise_Back_Add.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Ecercise_Back_Add.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        Button btnAddPullUp = findViewById(R.id.btnAddPullUp);
        Button btnAddCloseGripLat = findViewById(R.id.btnAddCloseGripLat);
        Button btnAddWideCableRow = findViewById(R.id.btnAddWideCableRow);
        Button btnAddTBarRowWide = findViewById(R.id.btnAddTBarRowWide);
        Button btnAddLatPulldown = findViewById(R.id.btnAddLatPulldown);
        Button btnAddTRXrow = findViewById(R.id.btnAddTRXrow);
        Button btnAddRopePullover = findViewById(R.id.btnAddRopePullover);
        Button btnAddRopeFacePullover = findViewById(R.id.btnAddRopeFacePullover);
        Button btnAddNarrowGripRow = findViewById(R.id.btnAddNarrowGripRow);

        btnAddPullUp.setOnClickListener(v -> addExerciseToPlan("Pull up"));
        btnAddCloseGripLat.setOnClickListener(v -> addExerciseToPlan("Close grip lat pulldown"));
        btnAddWideCableRow.setOnClickListener(v -> addExerciseToPlan("Wide cable row"));
        btnAddTBarRowWide.setOnClickListener(v -> addExerciseToPlan("T bar row wide"));
        btnAddLatPulldown.setOnClickListener(v -> addExerciseToPlan("Lat pulldown"));
        btnAddTRXrow.setOnClickListener(v -> addExerciseToPlan("TRX row"));
        btnAddRopePullover.setOnClickListener(v -> addExerciseToPlan("Rope pullover"));
        btnAddRopeFacePullover.setOnClickListener(v -> addExerciseToPlan("Rope face pullover"));
        btnAddNarrowGripRow.setOnClickListener(v -> addExerciseToPlan("Narrow grip row"));
    }

    private void addExerciseToPlan(String exerciseName) {
        SharedPreferences tempPrefs = getSharedPreferences("TempWorkout", Context.MODE_PRIVATE);

        String currentDay = tempPrefs.getString("current_selected_day", "Monday");
        String currentList = tempPrefs.getString("exercise_list_" + currentDay, "");

        tempPrefs.edit().putString("exercise_list_" + currentDay, currentList + exerciseName + ",").apply();

        Toast.makeText(this, exerciseName + " added to " + currentDay + "!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Create_Workout_Plan.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

}