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

public class Exercise_Legs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_legs);
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
                    startActivity(new Intent(Exercise_Legs.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Exercise_Legs.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Exercise_Legs.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }

        openExercise(R.id.Squats, "Squats", R.raw.squats,
                "1. Stand with feet shoulder-width apart.\n2. Lower your body by bending your knees and hips.\n3. Push back up to the starting position.");

        openExercise(R.id.JumpLunges, "Jump Lunges", R.raw.jump_lunges,
                "1. Start in a lunge position.\n2. Jump up, switching legs in the air.\n3. Land softly in the opposite lunge position.");

        openExercise(R.id.BarbellSquats, "Barbell Squats", R.raw.barbell_squats,
                "1. Place a barbell across your upper back.\n2. Squat down, keeping your back straight.\n3. Push back up to the starting position.");

        openExercise(R.id.CalfRaise, "Calf Raise", R.raw.calf_raise,
                "1. Stand with feet shoulder-width apart.\n2. Raise your heels off the ground, standing on your toes.\n3. Lower back down with control.");

        openExercise(R.id.DumbellSquats, "Dumbbell Squats", R.raw.dumbell_squats,
                "1. Hold dumbbells at your sides, feet shoulder-width apart.\n2. Squat down, keeping your back straight.\n3. Push back up to the starting position.");

        openExercise(R.id.DumbellLunges, "Dumbbell Lunges", R.raw.dumbell_lunges,
                "1. Hold dumbbells at your sides.\n2. Step forward into a lunge, lowering your back knee.\n3. Push back up and repeat with the other leg.");

        openExercise(R.id.Adductor, "Adductor", R.raw.abbductor,
                "1. Sit on the adductor machine with pads against your inner thighs.\n2. Squeeze your legs together against the resistance.\n3. Return slowly to the starting position.");

        openExercise(R.id.LegPress, "Leg Press", R.raw.leg_press,
                "1. Sit on the leg press machine, feet on the platform.\n2. Push the platform away by extending your legs.\n3. Return slowly to the starting position.");

        openExercise(R.id.LegCurl, "Leg Curl", R.raw.leg_curl,
                "1. Lie face down on the leg curl machine.\n2. Curl your legs upward toward your glutes.\n3. Lower back down with control.");

        openExercise(R.id.LegExtension, "Leg Extension", R.raw.leg_extension,
                "1. Sit on the leg extension machine, pad against your shins.\n2. Extend your legs forward until straight.\n3. Lower back down with control.");
    }

    private void openExercise(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        card.setOnClickListener(v -> {
            Intent intent = new Intent(Exercise_Legs.this, Workout_Info.class);
            intent.putExtra(Workout_Info.EXTRA_TITLE, title);
            intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
            intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
            startActivity(intent);
        });
    }
}