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

public class Exercise_Chest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_chest);
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
                    startActivity(new Intent(Exercise_Chest.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Exercise_Chest.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Exercise_Chest.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        openExercise(R.id.BenchPress, "Bench Press", R.raw.bench_press,
                "1. Lie flat on the bench, feet on the ground.\n2. Lower the bar to your chest with control.\n3. Push the bar back up until arms are extended.");

        openExercise(R.id.IncludeDumbell, "Incline Dumbbell Press", R.raw.incline_press,
                "1. Sit on an incline bench holding dumbbells.\n2. Press them upward until arms are extended.\n3. Lower back down with control.");

        openExercise(R.id.FlyChest, "Incline Dumbbell Fly", R.raw.incline_fly,
                "1. Lie on an incline bench, dumbbells above chest.\n2. Open arms wide with a slight elbow bend.\n3. Bring dumbbells back together above your chest.");
        openExercise(R.id.CableCross, "Cable Cross", R.raw.cable_cross,
                "1. Stand between cable machines, grab handles.\n2. Pull handles forward and down in an arc.\n3. Return slowly to the starting position.");

        openExercise(R.id.PushUp, "Push Up", R.raw.push_up,
                "1. Start in a plank position, hands shoulder-width apart.\n2. Lower your body until chest nearly touches the floor.\n3. Push back up to starting position.");

        openExercise(R.id.DumbellPullover, "Dumbbell Pullover", R.raw.dumbbell_pullover,
                "1. Lie on a bench, holding a dumbbell above chest.\n2. Lower it back behind your head with control.\n3. Pull it back up to starting position.");
    }

    private void openExercise(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        card.setOnClickListener(v -> {
            Intent intent = new Intent(Exercise_Chest.this, Workout_Info.class);
            intent.putExtra(Workout_Info.EXTRA_TITLE, title);
            intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
            intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
            startActivity(intent);
        });
    }
}