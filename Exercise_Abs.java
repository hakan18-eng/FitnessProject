package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Exercise_Abs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_abs);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_handbook);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(Exercise_Abs.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Exercise_Abs.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Exercise_Abs.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        openExercise(R.id.AbcoasterCrunch, "Abcoaster Crunch", R.raw.abcoaster_crunch,
                "1. Sit comfortably on the seat and grab the handles.\n2. Crunch forward, contracting your abs.\n3. Slowly return to start.");

        openExercise(R.id.AddominalCrunch, "Addominal Crunch", R.raw.abdominal_crunch,
                "1. Lie on your back, knees bent.\n2. Lift shoulders off the floor using your abs.\n3. Lower back down slowly.");

        openExercise(R.id.LegRaiseAbs, "Leg Raise Chair", R.raw.leg_raise_abs,
                "1. Hang or sit on the chair.\n2. Raise your knees toward your chest.\n3. Lower slowly with control.");

        openExercise(R.id.CrunchesTwist, "Crunches Twist", R.raw.crunches_twist,
                "1. Lie on your back, hands behind head.\n2. Twist your torso, bringing elbow to opposite knee.\n3. Alternate sides.");

        openExercise(R.id.DeclineCrunch, "Decline Crunch", R.raw.decline_crunch,
                "1. Secure feet on a decline bench.\n2. Crunch upward, engaging your abs.\n3. Lower back with control.");

        openExercise(R.id.FloorCrunch, "Floor Crunch", R.raw.floor_crunch,
                "1. Lie flat, knees bent, feet on floor.\n2. Crunch upward without pulling your neck.\n3. Lower slowly.");

        openExercise(R.id.LegRaise, "Leg Raise", R.raw.leg_raise,
                "1. Lie flat on your back.\n2. Raise legs straight up.\n3. Lower slowly without touching the floor.");

        openExercise(R.id.Plank, "Plank", R.raw.plank,
                "1. Hold a straight body position on forearms and toes.\n2. Keep core tight.\n3. Hold for the desired time.");

        openExercise(R.id.SeatedCrunch, "Seated Crunch", R.raw.seated_crunch,
                "1. Sit on the machine, grab the handles.\n2. Crunch forward using your abs.\n3. Return slowly to start.");
    }

    private void openExercise(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        card.setOnClickListener(v -> {
            Intent intent = new Intent(Exercise_Abs.this, Workout_Info.class);
            intent.putExtra(Workout_Info.EXTRA_TITLE, title);
            intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
            intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
            startActivity(intent);
        });
    }
}