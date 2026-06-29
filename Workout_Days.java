package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Workout_Days extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_days);

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
                    startActivity(new Intent(Workout_Days.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Workout_Days.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Workout_Days.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        ImageView ivTodayPlanBg = findViewById(R.id.ivTodayPlanBg);
        CardView cardTodayPlan = findViewById(R.id.cardTodayPlan);

        TextView tvTodayPlanTitle = null;
        try {
            ViewGroup frameLayout = (ViewGroup) cardTodayPlan.getChildAt(0);
            ViewGroup linearLayout = (ViewGroup) frameLayout.getChildAt(2);
            tvTodayPlanTitle = (TextView) linearLayout.getChildAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SharedPreferences sharedPreferences = getSharedPreferences("WorkoutPrefs", Context.MODE_PRIVATE);

        String currentTitle = getIntent().getStringExtra("PLAN_TITLE");
        int currentImage = getIntent().getIntExtra("PLAN_IMAGE", -1);

        if (currentTitle == null) {
            currentTitle = sharedPreferences.getString("saved_title", "Full Body");
        }
        if (currentImage == -1) {
            currentImage = sharedPreferences.getInt("saved_image", R.drawable.workout1);
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("saved_title", currentTitle);
        editor.putInt("saved_image", currentImage);
        editor.apply();

        if (ivTodayPlanBg != null) ivTodayPlanBg.setImageResource(currentImage);
        if (tvTodayPlanTitle != null) tvTodayPlanTitle.setText(currentTitle);


        CardView day1Card = findViewById(R.id.WorkoutDay1);
        CardView day2Card = findViewById(R.id.WorkoutDay2);
        CardView day3Card = findViewById(R.id.WorkoutDay3);
        CardView day4Card = findViewById(R.id.WorkoutDay4);
        CardView day5Card = findViewById(R.id.WorkoutDay5);

        boolean isBuiltIn = currentTitle.equals("Full body (Advanced For Female)") ||
                currentTitle.equals("Full body (Begginer For Female)") ||
                currentTitle.equals("Weight loss (Female)") ||
                currentTitle.equals("Full body (Advanced For Male)") ||
                currentTitle.equals("Full body (Begginer For Male)") ||
                currentTitle.equals("Full Body") ||
                currentTitle.equals("Weight loss (Male)");

        if (isBuiltIn) {
            if (day1Card != null) day1Card.setVisibility(View.VISIBLE);
            if (day2Card != null) day2Card.setVisibility(View.VISIBLE);
            if (day3Card != null) day3Card.setVisibility(View.VISIBLE);
            if (day4Card != null) day4Card.setVisibility(View.GONE);
            if (day5Card != null) day5Card.setVisibility(View.GONE);

            if ("Full body (Advanced For Female)".equals(currentTitle)) {
                setDayCardData(day1Card, "Day 1: Hypertrophy and Endurance (Monday)", 10);
                setDayCardData(day2Card, "Day 2: Power and Performance (Wednesday)", 11);
                setDayCardData(day3Card, "Day 3: Growth and Abs (Friday)", 12);
            } else if ("Full body (Begginer For Female)".equals(currentTitle)) {
                setDayCardData(day1Card, "Day 1: Strength and Explosiveness (Monday)", 20);
                setDayCardData(day2Card, "Day 2: Muscle Growth (Wednesday)", 21);
                setDayCardData(day3Card, "Day 3: Growth and Abs (Friday)", 22);
            } else if ("Weight loss (Female)".equals(currentTitle)) {
                setDayCardData(day1Card, "Day 1: Strength and Tone (Monday)", 30);
                setDayCardData(day2Card, "Day 2: Cardio and Endurance (Wednesday)", 31);
                setDayCardData(day3Card, "Day 3: Fat Burn and Power (Friday)", 32);
            } else if ("Full body (Advanced For Male)".equals(currentTitle)) {
                setDayCardData(day1Card, "Day 1: Strength and Explosiveness (Monday)", 40);
                setDayCardData(day2Card, "Day 2: Back growth and Biceps (Wednesday)", 41);
                setDayCardData(day3Card, "Day 3: Leg growth (Friday)", 42);
            } else if ("Full body (Begginer For Male)".equals(currentTitle) || "Full Body".equals(currentTitle)) {
                setDayCardData(day1Card, "Day 1: Strength and Explosiveness (Monday)", 50);
                setDayCardData(day2Card, "Day 2: Back growth (Wednesday)", 51);
                setDayCardData(day3Card, "Day 3: Leg growth (Friday)", 52);
            } else if ("Weight loss (Male)".equals(currentTitle)) {
                setDayCardData(day1Card, "Day 1: Strength and Explosiveness (Monday)", 60);
                setDayCardData(day2Card, "Day 2: Conditioning and Stability (Wednesday)", 61);
                setDayCardData(day3Card, "Day 3: Heavy Strength and Power (Friday)", 62);
            }
        } else {
            setupCustomDayCard(day1Card, "Monday");
            setupCustomDayCard(day2Card, "Tuesday");
            setupCustomDayCard(day3Card, "Wednesday");
            setupCustomDayCard(day4Card, "Thursday");
            setupCustomDayCard(day5Card, "Friday");
        }
    }

    private void setDayCardData(CardView card, String subtitleText, int planDayCode) {
        if (card != null) {
            try {
                ViewGroup mainLayout = (ViewGroup) card.getChildAt(0);
                ViewGroup textLayout = (ViewGroup) mainLayout.getChildAt(2);
                TextView subtitle = (TextView) textLayout.getChildAt(1);

                if (subtitle != null) {
                    subtitle.setText(subtitleText);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_Days.this, Workout_Session.class);
                intent.putExtra("IS_CUSTOM", false);
                intent.putExtra("PLAN_DAY_CODE", planDayCode);
                startActivity(intent);
            });
        }
    }

    private void setupCustomDayCard(CardView card, String dayName) {
        SharedPreferences sharedPreferences = getSharedPreferences("WorkoutPrefs", Context.MODE_PRIVATE);
        String exercises = sharedPreferences.getString("plan_" + dayName, "");

        if (exercises == null || exercises.trim().isEmpty()) {
            if (card != null) card.setVisibility(View.GONE);
            return;
        }

        if (card != null) {
            card.setVisibility(View.VISIBLE);
            try {
                ViewGroup mainLayout = (ViewGroup) card.getChildAt(0);
                ViewGroup textLayout = (ViewGroup) mainLayout.getChildAt(2);
                TextView title = (TextView) textLayout.getChildAt(0);
                TextView subtitle = (TextView) textLayout.getChildAt(1);

                if (title != null) title.setText(dayName);
                if (subtitle != null) subtitle.setText("Custom Workout");
            } catch (Exception e) {
                e.printStackTrace();
            }

            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_Days.this, Workout_Session.class);
                intent.putExtra("IS_CUSTOM", true);
                intent.putExtra("CUSTOM_DAY", dayName);
                startActivity(intent);
            });
        }
    }
}