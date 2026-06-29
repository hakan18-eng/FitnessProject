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

public class Workout_Female_Begginer_FullBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_female_begginer_full_body);

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
                Intent intent = new Intent(Workout_Female_Begginer_FullBody.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                Intent intent = new Intent(Workout_Female_Begginer_FullBody.this, Handbook.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                Intent intent = new Intent(Workout_Female_Begginer_FullBody.this, Profile.class);
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
                        .putString("saved_title", "Full body (Begginer For Female)")
                        .putInt("saved_image", R.drawable.begginer_female)
                        .apply();

                Toast.makeText(this, "Workout Plan Activated!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            });
        }

        setupCardClick(R.id.Treadmill, "Treadmill", R.raw.tredmill, "1. Start walking slowly to warm up.\n2. Keep a steady, comfortable pace.\n3. Cool down slowly at the end.");
        setupCardClick(R.id.Squats, "Squats", R.raw.squats, "1. Stand with feet shoulder-width apart.\n2. Lower your hips down as if sitting in a chair.\n3. Push through your heels to return up.");
        setupCardClick(R.id.GluteBridge, "Hip thrust", R.raw.glute_bridge, "1. Lie on your back with knees bent and feet flat.\n2. Squeeze your glutes and lift your hips high.\n3. Lower down under control.");
        setupCardClick(R.id.Plank, "Plank", R.raw.plank, "1. Hold a straight body position resting on forearms and toes.\n2. Keep your core braced and tight.\n3. Do not let your hips sag.");
        setupCardClick(R.id.SeatedCrunch, "Seated crunch", R.raw.seated_crunch, "1. Sit comfortably on the machine and grip the handles.\n2. Crunch forward using your abdominal muscles.\n3. Slowly return to the starting position.");

        setupCardClick(R.id.Treadmill2, "Treadmill", R.raw.tredmill, "1. Mid-week conditioning focus.\n2. Maintain a steady fat-burning pace.\n3. Walk down to complete recovery.");
        setupCardClick(R.id.OverHeadPress, "Overhead press", R.raw.overhead_press, "1. Hold weights at shoulder level.\n2. Press them directly overhead smoothly.\n3. Lower back down under strict control.");
        setupCardClick(R.id.TricepsPushdown, "Triceps pushdown", R.raw.triceps_pushdown, "1. Face the cable machine attachment.\n2. Extend your arms downwards completely.\n3. Control the return phase.");
        setupCardClick(R.id.AddominalCrunch, "Addominal crunch", R.raw.abdominal_crunch, "1. Lie flat on your back with knees bent.\n2. Lift your shoulders off the mat using your abs.\n3. Lower down slowly.");
        setupCardClick(R.id.LegRaise, "Leg raise", R.raw.leg_raise, "1. Lie flat with your hands under your hips for support.\n2. Raise your legs up together keeping them straight.\n3. Lower them slowly without touching the floor.");

        setupCardClick(R.id.Treadmill3, "Treadmill", R.raw.tredmill, "1. Final weekly cardiovascular stimulation.\n2. Focus on continuous linear pace.\n3. Relax into walking steps to finish.");
        setupCardClick(R.id.LatPulldown, "Lat pulldown", R.raw.lat_pulldown, "1. Grip the bar slightly wider than shoulders.\n2. Pull down smoothly to your upper chest.\n3. Resist the weight as it goes up.");
        setupCardClick(R.id.NarrowGripRow, "Seated narrow grip row", R.raw.narrow_grip_row, "1. Sit straight facing the pulley platform.\n2. Pull the handle towards your belly button.\n3. Squeeze your back muscles completely.");
        setupCardClick(R.id.DumbellCurl, "Dumbell curl", R.raw.dumbell_curl, "1. Hold dumbbells at your sides.\n2. Curl weights up toward shoulders.\n3. Lower down with constant control.");
        setupCardClick(R.id.CrunchesTwist, "Crunches twist", R.raw.crunches_twist, "1. Position hands behind your head while lying down.\n2. Crunch up and twist torso, alternate sides.\n3. Keep your core under tension.");
    }

    private void setupCardClick(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_Female_Begginer_FullBody.this, Workout_Info.class);
                intent.putExtra(Workout_Info.EXTRA_TITLE, title);
                intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
                intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
                startActivity(intent);
            });
        }
    }
}