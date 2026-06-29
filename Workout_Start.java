package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Workout_Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_start);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvExerciseName = findViewById(R.id.tvExerciseName);
        ImageView ivExerciseGif = findViewById(R.id.ivExerciseGif);
        TextView tvRepsValue = findViewById(R.id.tvRepsValue);
        TextView tvSetNumber = findViewById(R.id.tvSetNumber);
        TextView tvTimeValue = findViewById(R.id.tvTimeValue);
        Button btnDoneSet = findViewById(R.id.btnDoneSet);

        Intent intent = getIntent();
        String exerciseName = intent.getStringExtra("EXERCISE_NAME");
        int videoRes = intent.getIntExtra("EXERCISE_VIDEO_RES", 0);
        String sets = intent.getStringExtra("EXERCISE_SETS");
        String reps = intent.getStringExtra("EXERCISE_REPS");
        String time = intent.getStringExtra("EXERCISE_TIME");

        if (tvExerciseName != null) tvExerciseName.setText(exerciseName);
        if (ivExerciseGif != null && videoRes != 0) ivExerciseGif.setImageResource(videoRes);
        if (tvRepsValue != null) tvRepsValue.setText(reps);
        if (tvTimeValue != null) tvTimeValue.setText(time);
        if (tvSetNumber != null) tvSetNumber.setText(sets);

        if (btnDoneSet != null) {
            btnDoneSet.setOnClickListener(v -> {
                SharedPreferences userPrefs = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE);
                String currentEmail = userPrefs.getString("current_logged_email", "default_user");

                SharedPreferences statsPrefs = getSharedPreferences("WorkoutStats", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = statsPrefs.edit();

                String category = getCategoryFromExercise(exerciseName);
                String uniqueKey = currentEmail + "_" + category;
                int savedSets = statsPrefs.getInt(uniqueKey, 0);

                editor.putInt(uniqueKey, savedSets + 1);
                editor.apply();

                Intent timerIntent = new Intent(Workout_Start.this, Workout_Timer.class);
                startActivity(timerIntent);
                finish();
            });
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_handbook);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(Workout_Start.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Workout_Start.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Workout_Start.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }
    }

    private String getCategoryFromExercise(String name) {
        if (name == null) return "Upper Body";

        String lowerName = name.toLowerCase();

        if (lowerName.contains("squat") || lowerName.contains("leg") || lowerName.contains("calf") || lowerName.contains("lunge") || lowerName.contains("adductor")) {
            return "Legs";
        } else if (lowerName.contains("glute") || lowerName.contains("bridge") || lowerName.contains("donkey") || lowerName.contains("deadlift")) {
            return "Gluteus";
        } else if (lowerName.contains("treadmill") || lowerName.contains("cycling") || lowerName.contains("climber") || lowerName.contains("sprint") || lowerName.contains("cardio")) {
            return "Cardio";
        } else {
            return "Upper Body";
        }
    }
}