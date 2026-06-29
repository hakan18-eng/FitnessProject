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

public class Exercise_Gluteus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_gluteus);
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
                    startActivity(new Intent(Exercise_Gluteus.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Exercise_Gluteus.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Exercise_Gluteus.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        openExercise(R.id.LegBarbellLunges, "Leg Barbell Lunges", R.raw.leg_barbell_lunges,
                "1. Stand holding a barbell on your shoulders.\n2. Step forward into a lunge, lowering your back knee.\n3. Push back up and repeat with the other leg.");

        openExercise(R.id.BandedCrabWalk, "Banded Crab Walk", R.raw.banded_crab_walk,
                "1. Place a resistance band around your ankles.\n2. Get into a half-squat stance.\n3. Step sideways, keeping tension on the band.");

        openExercise(R.id.BandedLateralRaise, "Banded Lateral Raise", R.raw.banded_lateral_raise,
                "1. Place a resistance band around your thighs.\n2. Get into a half-squat stance.\n3. Raise one leg out to the side and return.");

        openExercise(R.id.GluteBridge, "Glute Bridge", R.raw.glute_bridge,
                "1. Lie on your back with knees bent, feet flat.\n2. Push your hips upward, squeezing your glutes.\n3. Lower back down with control.");

        openExercise(R.id.BulgarianSplitSquat, "Bulgarian Split Squat", R.raw.bulgarian_split_squat,
                "1. Place one foot behind you on a bench.\n2. Lower into a squat with your front leg.\n3. Push back up and repeat.");

        openExercise(R.id.Deadlift, "Deadlift", R.raw.deadlift,
                "1. Stand with feet hip-width apart, barbell in front of you.\n2. Bend at the hips and knees to grab the bar.\n3. Lift by extending your hips and knees, keeping your back straight.");

        openExercise(R.id.DonkeyKick, "Donkey Kick", R.raw.donkey_kick,
                "1. Get on all fours, hands under shoulders.\n2. Kick one leg back and up, keeping the knee bent.\n3. Lower back down with control.");

        openExercise(R.id.GlutesExtension, "Glutes Extension", R.raw.glutes_extension,
                "1. Position yourself on the hip extension machine.\n2. Extend your hips backward, squeezing your glutes.\n3. Return slowly to the starting position.");

        openExercise(R.id.PileDumbellSquats, "Plie Dumbbell Squats", R.raw.pile_dumbell_squats,
                "1. Stand with feet wide, toes pointed out, holding a dumbbell.\n2. Squat down, keeping your back straight.\n3. Push back up to the starting position.");
    }

    private void openExercise(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        card.setOnClickListener(v -> {
            Intent intent = new Intent(Exercise_Gluteus.this, Workout_Info.class);
            intent.putExtra(Workout_Info.EXTRA_TITLE, title);
            intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
            intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
            startActivity(intent);
        });
    }
}