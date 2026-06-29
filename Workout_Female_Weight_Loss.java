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

public class Workout_Female_Weight_Loss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_female_weight_loss);

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
                Intent intent = new Intent(Workout_Female_Weight_Loss.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                Intent intent = new Intent(Workout_Female_Weight_Loss.this, Handbook.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                Intent intent = new Intent(Workout_Female_Weight_Loss.this, Profile.class);
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
                        .putString("saved_title", "Weight loss (Female)")
                        .putInt("saved_image", R.drawable.begginer)
                        .apply();

                Toast.makeText(this, "Workout Plan Activated!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            });
        }

        setupCardClick(R.id.Squats, "Squats", R.raw.squats, "1. Stand with feet shoulder-width apart.\n2. Squat down deeply pushing hips back.\n3. Keep torso up and return through heels.");
        setupCardClick(R.id.PushUp, "Push up", R.raw.push_up, "1. Position body straight on hands and toes.\n2. Lower upper chest controlled toward the mat.\n3. Return up steadily with total core brace.");
        setupCardClick(R.id.BulgarianSplitSquat, "Bulgarian split squat", R.raw.bulgarian_split_squat, "1. Elevate rear leg safely back onto a gym bench.\n2. Descend single leg until front quad is flat.\n3. Push up using front leg tension.");
        setupCardClick(R.id.DumbellRaise, "Dumbell raise", R.raw.dumbell_raise, "1. Hold small dumbbells forward down.\n2. Raise arms out front to eye level level line.\n3. Decelerate weights back to base.");
        setupCardClick(R.id.Plank, "Plank", R.raw.plank, "1. Set rigid horizontal line on toes and elbows.\n2. Tuck pelvis in and tighten core stabilizers.\n3. Maintain constant position without dropping.");

        setupCardClick(R.id.Treadmill2, "Treadmill", R.raw.tredmill, "1. Steady fat burning running interval step.\n2. Keep uniform shoulder position.\n3. Cool off smoothly with low pace walking.");
        setupCardClick(R.id.DumbellLunges, "Dumbell lunges", R.raw.dumbell_lunges, "1. Hold parallel dumbbells straight at sides.\n2. Step alternating legs into progressive lunge.\n3. Drive stepping heel back to launch position.");
        setupCardClick(R.id.LateralRaise, "Lateral raise", R.raw.lateral_raise, "1. Elevate small weights wide out outward smoothly.\n2. Keep isolated pressure on lateral shoulder caps.\n3. Lower with controlled contraction.");
        setupCardClick(R.id.Cycling, "Cycling", R.raw.cycling, "1. High rotation linear bike simulation.\n2. Ensure strong deep abdominal breathing.\n3. Burn stored system glycogen safely.");
        setupCardClick(R.id.CLimber, "Climber", R.raw.climber, "1. Safe stepping dynamic conditioning activity.\n2. Maintain consistent vertical pace cycles.\n3. Elevate core temperature parameters.");

        setupCardClick(R.id.GluteBridge, "Glute bridge", R.raw.glute_bridge, "1. Lie down supine, pull heels close to hips.\n2. Drive pelvis high into ceiling ceiling contraction.\n3. Return down slowly under control.");
        setupCardClick(R.id.LatPulldown, "Lat pulldown", R.raw.lat_pulldown, "1. Sit tall pulling system bar to upper clavicles.\n2. Focus pull on latissimus back regions.\n3. Allow clean slow muscle extension upwards.");
        setupCardClick(R.id.LegExtension, "Leg extension", R.raw.leg_extension, "1. Position knee joint clean with lever pivot.\n2. Squeeze quads tightly stretching legs straight.\n3. Return lower leg control back.");
        setupCardClick(R.id.LegRaise, "Leg raise", R.raw.leg_raise, "1. Flat back position resting spine entirely.\n2. Raise straight legs to clean vertical projection.\n3. Descend with slow pressure from absolute abs.");
        setupCardClick(R.id.CLimber2, "Climber", R.raw.climber, "1. Second high definition conditioning stage.\n2. Keep light athletic feet movement rhythm.\n3. Increase fat burn parameters completely.");
        setupCardClick(R.id.Treadmill5, "Treadmill", R.raw.tredmill, "1. Final linear steady state fat loss run.\n2. Maintain standard upright upper frame posture.\n3. Transition smoothly to safe walking recovery.");
    }

    private void setupCardClick(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_Female_Weight_Loss.this, Workout_Info.class);
                intent.putExtra(Workout_Info.EXTRA_TITLE, title);
                intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
                intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
                startActivity(intent);
            });
        }
    }
}