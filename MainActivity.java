package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private int currentImage;
    private String currentTitle;
    private ImageView ivTodayPlanBg;
    private TextView tvTodayPlanTitle = null;
    private CardView cardTodayPlan;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.nav_home);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_handbook) {
                startActivity(new Intent(MainActivity.this, Handbook.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(MainActivity.this, Profile.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });

        CardView cardChooseWorkout = findViewById(R.id.cardChooseWorkout);
        cardTodayPlan = findViewById(R.id.cardTodayPlan);
        ivTodayPlanBg = findViewById(R.id.ivTodayPlanBg);

        try {
            ViewGroup frameLayout = (ViewGroup) cardTodayPlan.getChildAt(0);
            ViewGroup linearLayout = (ViewGroup) frameLayout.getChildAt(2);
            tvTodayPlanTitle = (TextView) linearLayout.getChildAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cardChooseWorkout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Handbook.class);
            startActivity(intent);
        });

        sharedPreferences = getSharedPreferences("WorkoutPrefs", Context.MODE_PRIVATE);

        Intent incomingIntent = getIntent();
        if (incomingIntent != null && incomingIntent.hasExtra("WORKOUT_TITLE")) {
            int newImage = incomingIntent.getIntExtra("WORKOUT_IMAGE", R.drawable.man6);
            String newTitle = incomingIntent.getStringExtra("WORKOUT_TITLE");

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("saved_image", newImage);
            editor.putString("saved_title", newTitle);
            editor.apply();
        }

        CardView cardFemaleWeightLoss = findViewById(R.id.cardFemaleWeightLoss);
        if (cardFemaleWeightLoss != null) {
            cardFemaleWeightLoss.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Workout_Female_Weight_Loss.class)));
        }

        CardView cardMaleWeightLoss = findViewById(R.id.cardMaleWeightLoss);
        if (cardMaleWeightLoss != null) {
            cardMaleWeightLoss.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Workout_Male_Weight_Loss.class)));
        }

        CardView cardMaleAdvanced = findViewById(R.id.cardMaleAdvanced);
        if (cardMaleAdvanced != null) {
            cardMaleAdvanced.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Workout_male_advanced_full_body.class)));
        }

        loadSavedWorkoutPlan();
        updateStatsGraph();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadSavedWorkoutPlan();
        updateStatsGraph();
    }

    private void loadSavedWorkoutPlan() {
        if (sharedPreferences != null) {
            currentImage = sharedPreferences.getInt("saved_image", R.drawable.man6);
            currentTitle = sharedPreferences.getString("saved_title", "Choose Workout Plans");

            if (ivTodayPlanBg != null) {
                ivTodayPlanBg.setImageResource(currentImage);
            }
            if (tvTodayPlanTitle != null) {
                tvTodayPlanTitle.setText(currentTitle);
            }

            if (cardTodayPlan != null) {
                cardTodayPlan.setOnClickListener(v -> {
                    if (!"Choose Workout Plans".equals(currentTitle)) {
                        Intent intent = new Intent(MainActivity.this, Workout_Days.class);
                        intent.putExtra("PLAN_TITLE", currentTitle);
                        intent.putExtra("PLAN_IMAGE", currentImage);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, Handbook.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    private void updateStatsGraph() {
        SharedPreferences userPrefs = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE);
        String currentEmail = userPrefs.getString("current_logged_email", "default_user");

        SharedPreferences statsPrefs = getSharedPreferences("WorkoutStats", Context.MODE_PRIVATE);

        int upperBodySets = statsPrefs.getInt(currentEmail + "_Upper Body", 0);
        int cardioSets = statsPrefs.getInt(currentEmail + "_Cardio", 0);
        int legsSets = statsPrefs.getInt(currentEmail + "_Legs", 0);
        int gluteusSets = statsPrefs.getInt(currentEmail + "_Gluteus", 0);

        TextView tvWorkoutCount = findViewById(R.id.tvWorkoutCount);
        TextView tvUpperBodyReps = findViewById(R.id.tvUpperBodyReps);
        TextView tvCardioReps = findViewById(R.id.tvCardioReps);
        TextView tvLegsReps = findViewById(R.id.tvLegsReps);
        TextView tvGluteusReps = findViewById(R.id.tvGluteusReps);

        View vUpperBodyBar = findViewById(R.id.vUpperBodyBar);
        View vCardioBar = findViewById(R.id.vCardioBar);
        View vLegsBar = findViewById(R.id.vLegsBar);
        View vGluteusBar = findViewById(R.id.vGluteusBar);

        int totalWorkouts = upperBodySets + cardioSets + legsSets + gluteusSets;
        if (tvWorkoutCount != null) tvWorkoutCount.setText(String.valueOf(totalWorkouts));

        if (tvUpperBodyReps != null) tvUpperBodyReps.setText(upperBodySets + " sets");
        if (tvCardioReps != null) tvCardioReps.setText(cardioSets + " sets");
        if (tvLegsReps != null) tvLegsReps.setText(legsSets + " sets");
        if (tvGluteusReps != null) tvGluteusReps.setText(gluteusSets + " sets");

        setBarHeight(vUpperBodyBar, upperBodySets);
        setBarHeight(vCardioBar, cardioSets);
        setBarHeight(vLegsBar, legsSets);
        setBarHeight(vGluteusBar, gluteusSets);
    }

    private void setBarHeight(View bar, int sets) {
        if (bar != null) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) bar.getLayoutParams();
            float weight = Math.min(100f, sets * 4f);
            if (sets == 0) weight = 0f;
            params.weight = weight;
            bar.setLayoutParams(params);
        }
    }
}