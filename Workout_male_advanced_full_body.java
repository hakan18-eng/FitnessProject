package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Workout_male_advanced_full_body extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_male_advanced_full_body);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.nav_handbook);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Intent intent = new Intent(Workout_male_advanced_full_body.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                Intent intent = new Intent(Workout_male_advanced_full_body.this, Handbook.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                Intent intent = new Intent(Workout_male_advanced_full_body.this, Profile.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });

        Button btnStartWorkout = findViewById(R.id.btnAdd);
        if (btnStartWorkout != null) {
            btnStartWorkout.setOnClickListener(v -> {
                getSharedPreferences("WorkoutPrefs", Context.MODE_PRIVATE).edit()
                        .putString("saved_title", "Full body (Advanced For Male)")
                        .putInt("saved_image", R.drawable.advanced)
                        .apply();

                Toast.makeText(this, "Workout Plan Activated!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            });
        }

        setupCardClick(R.id.Treadmill, "Treadmill", R.raw.tredmill, "1. Run with advanced speed.\n2. Maintain intervals.\n3. Cool down smoothly.");
        setupCardClick(R.id.BenchPress, "Bench press", R.raw.bench_press, "1. Lie flat on bench.\n2. Lower bar to chest level.\n3. Push up explosively.");
        setupCardClick(R.id.IncludeDumbell, "Incline dumbell press", R.raw.incline_press, "1. Set incline bench.\n2. Raise dumbbells together.\n3. Lower with slow control.");
        setupCardClick(R.id.OverHeadPress, "Overhead press", R.raw.overhead_press, "1. Lift bar to shoulders.\n2. Press bar directly up.\n3. Control the descent.");
        setupCardClick(R.id.LateralRaise, "Lateral raise", R.raw.lateral_raise, "1. Stand straight.\n2. Raise arms out to sides.\n3. Squeeze side delts.");
        setupCardClick(R.id.RearDelt2, "Rear delt", R.raw.rear_delt, "1. Bend forward slightly.\n2. Pull elbows back high.\n3. Isolate back deltoids.");
        setupCardClick(R.id.TricepsPushdown, "Triceps pushdown", R.raw.triceps_pushdown, "1. Use cable bar attachment.\n2. Extend arms down completely.\n3. Lock your elbows.");

        setupCardClick(R.id.LatPulldown3, "Lat Pulldown", R.raw.lat_pulldown, "1. Grip wide bar.\n2. Pull directly to collarbone.\n3. Control the return phase.");
        setupCardClick(R.id.WideCableRow, "Wide cable row", R.raw.wide_cable_row, "1. Seated position.\n2. Row wide handle to chest.\n3. Retract shoulder blades.");
        setupCardClick(R.id.RopePullover, "Rope pullover", R.raw.rope_pullover, "1. Stand back from high cable.\n2. Pull rope to upper thighs.\n3. Keep arms mostly straight.");
        setupCardClick(R.id.BarbellCurl, "Barbell curl", R.raw.barbell_curl, "1. Stand holding bar down.\n2. Flex elbows upwards.\n3. Lower bar without swinging.");
        setupCardClick(R.id.HammerCurl, "Hammer curl", R.raw.hammer_curl, "1. Neutral grip dumbbells.\n2. Lift towards shoulders.\n3. Squeeze forearms and biceps.");

        setupCardClick(R.id.Treadmill3, "Treadmill", R.raw.tredmill, "1. Final leg day warm up.\n2. Intense short cardio sprint.\n3. Relax into walking.");
        setupCardClick(R.id.DumbellSquats, "Dumbell squats", R.raw.dumbell_squats, "1. Heavy dumbbells at sides.\n2. Squat down past parallel.\n3. Push through whole foot.");
        setupCardClick(R.id.LegPress, "Leg press", R.raw.leg_press, "1. Place feet on sled.\n2. Lower knees towards chest.\n3. Press up safely, don't lock knees.");
        setupCardClick(R.id.CalfRaise, "Calf Raise", R.raw.calf_raise, "1. Stand straight with weight.\n2. Push through tip of toes.\n3. Stretch heels low down.");
        setupCardClick(R.id.DumbellLunges, "Dumbell lunges", R.raw.dumbell_lunges, "1. Take long step forward.\n2. Lower back knee to floor.\n3. Step back up sharply.");
        setupCardClick(R.id.LegCurl, "Leg Curl", R.raw.leg_curl, "1. Lie face down on machine.\n2. Flex heels toward glutes.\n3. Control weight back down.");
    }

    private void setupCardClick(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_male_advanced_full_body.this, Workout_Info.class);
                intent.putExtra(Workout_Info.EXTRA_TITLE, title);
                intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
                intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
                startActivity(intent);
            });
        }
    }
}