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

public class Exercise_Triceps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_triceps);
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
                    startActivity(new Intent(Exercise_Triceps.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Exercise_Triceps.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Exercise_Triceps.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        openExercise(R.id.TricepsPushdown, "Triceps Pushdown", R.raw.triceps_pushdown,
                "1. Stand facing the cable machine, grab the bar attachment.\n2. Push the bar down by extending your elbows.\n3. Return slowly to the starting position.");

        openExercise(R.id.DumbellTricepsExtension, "Dumbbell Triceps Extension", R.raw.dumbell_triceps_extension,
                "1. Hold a dumbbell overhead with both hands.\n2. Lower it behind your head by bending your elbows.\n3. Extend back up to the starting position.");

        openExercise(R.id.PushUpTriceps, "Push Up for Triceps", R.raw.push_up_triceps,
                "1. Start in a plank position, hands close together.\n2. Lower your body by bending your elbows close to your sides.\n3. Push back up to starting position.");

        openExercise(R.id.KneePushUp, "Knee Up Push Up", R.raw.knee_push_up,
                "1. Start in a plank position with knees on the ground.\n2. Lower your body until chest nearly touches the floor.\n3. Push back up to starting position.");

        openExercise(R.id.ReverseDips, "Reverse Dips", R.raw.reverse_dips,
                "1. Sit on the edge of a bench, hands gripping the edge.\n2. Lower your body by bending your elbows.\n3. Push back up to the starting position.");

        openExercise(R.id.OverheadTricepsExtension, "Overhead Triceps Extension", R.raw.overhead_triceps_extension,
                "1. Stand holding a dumbbell or cable attachment overhead.\n2. Lower it behind your head by bending your elbows.\n3. Extend back up to the starting position.");
    }

    private void openExercise(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        card.setOnClickListener(v -> {
            Intent intent = new Intent(Exercise_Triceps.this, Workout_Info.class);
            intent.putExtra(Workout_Info.EXTRA_TITLE, title);
            intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
            intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
            startActivity(intent);
        });
    }
}