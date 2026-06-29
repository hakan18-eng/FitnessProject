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

public class Exercise_Back extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_back);
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
                    startActivity(new Intent(Exercise_Back.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Exercise_Back.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Exercise_Back.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        openExercise(R.id.PullUpBack, "Pull Up", R.raw.pull_up,
                "1. Grab the bar with a wide overhand grip.\n2. Pull your body up until your chin clears the bar.\n3. Lower yourself back down with control.");

        openExercise(R.id.CloseGripLatPulldown, "Close Grip Lat Pulldown", R.raw.clode_grip_lat_pulldown,
                "1. Sit at the lat pulldown machine, grab the close grip handle.\n2. Pull the bar down toward your chest.\n3. Slowly return to the starting position.");

        openExercise(R.id.WideCableRow, "Wide Cable Row", R.raw.wide_cable_row,
                "1. Sit at the cable row machine with a wide grip bar.\n2. Pull the handle toward your torso, squeezing your back.\n3. Extend arms back to the starting position.");

        openExercise(R.id.TBarRowWide, "T Bar Row Wide", R.raw.t_bar_row_wade,
                "1. Stand over the T-bar with a wide grip.\n2. Pull the bar up toward your chest.\n3. Lower it back down with control.");

        openExercise(R.id.LatPulldown, "Lat Pulldown", R.raw.lat_pulldown,
                "1. Sit at the machine, grab the bar with a wide grip.\n2. Pull the bar down to chest level.\n3. Slowly return to the starting position.");

        openExercise(R.id.TRXrow, "TRX Row", R.raw.trx_row,
                "1. Hold the TRX straps and lean back, body straight.\n2. Pull your chest toward your hands.\n3. Lower back down with control.");

        openExercise(R.id.RopePullover, "Rope Pullover", R.raw.rope_pullover,
                "1. Grab the rope attachment on the cable machine.\n2. Pull the rope down and back in an arc.\n3. Return slowly to the starting position.");

        openExercise(R.id.RopeFacePullover, "Rope Face Pullover", R.raw.rope_face_pullover,
                "1. Grab the rope attachment at face height.\n2. Pull the rope toward your face, elbows high.\n3. Return slowly to the starting position.");

        openExercise(R.id.NarrowGripRow, "Narrow Grip Row", R.raw.narrow_grip_row,
                "1. Sit at the cable row machine with a narrow grip handle.\n2. Pull the handle toward your torso.\n3. Extend arms back to the starting position.");
    }

    private void openExercise(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        card.setOnClickListener(v -> {
            Intent intent = new Intent(Exercise_Back.this, Workout_Info.class);
            intent.putExtra(Workout_Info.EXTRA_TITLE, title);
            intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
            intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
            startActivity(intent);
        });
    }
}