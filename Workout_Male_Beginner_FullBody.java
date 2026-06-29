package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class Workout_Male_Beginner_FullBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_male_beginner_full_body);

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
                startActivity(new Intent(Workout_Male_Beginner_FullBody.this, MainActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                startActivity(new Intent(Workout_Male_Beginner_FullBody.this, Handbook.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(Workout_Male_Beginner_FullBody.this, Profile.class));
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
                        .putString("saved_title", "Full body (Begginer For Male)")
                        .putInt("saved_image", R.drawable.begginer3)
                        .apply();

                Toast.makeText(this, "Workout Plan Activated!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            });
        }

        setupCardClick(R.id.Treadmill, "Treadmill", R.raw.tredmill, "1. Start walking at 5 km/h.\n2. Run at 8 km/h.\n3. Walk 2 mins to cool down.");
        setupCardClick(R.id.PushUp, "Push up", R.raw.push_up, "1. Place hands shoulder-width apart.\n2. Lower body until chest almost touches floor.\n3. Push back up dynamically.");
        setupCardClick(R.id.IncludeDumbell, "Incline dumbbell press", R.raw.incline_press, "1. Lie on incline bench.\n2. Press dumbbells upward smoothly.\n3. Return down with control.");
        setupCardClick(R.id.OverHeadPress, "Overhead press", R.raw.overhead_press, "1. Stand straight holding barbell at shoulders.\n2. Press barbell directly overhead.\n3. Lower with strict path control.");
        setupCardClick(R.id.TricepsPushdown, "Triceps pushdown", R.raw.triceps_pushdown, "1. Face cable machine, grip handle.\n2. Extend arms downward completely.\n3. Squeeze triceps at bottom.");
        setupCardClick(R.id.Treadmill2, "Treadmill", R.raw.tredmill, "1. Moderate dynamic fat burn running.\n2. Keep steady breathing rhythm.\n3. Slow down safely.");
        setupCardClick(R.id.LatPulldown, "Lat pulldown", R.raw.lat_pulldown, "1. Sit at machine, wide bar grip.\n2. Pull bar down to upper chest.\n3. Release up under control.");
        setupCardClick(R.id.PullUpBack, "Pull up", R.raw.pull_up, "1. Grip bar with palms facing away.\n2. Pull chin above bar level.\n3. Lower down completely smoothly.");
        setupCardClick(R.id.WideCableRow, "Wide cable row", R.raw.wide_cable_row, "1. Sit facing machine.\n2. Pull bar toward lower ribs.\n3. Extend arms back.");
        setupCardClick(R.id.RearDelt, "Rear delt", R.raw.rear_delt, "1. Lean forward slightly.\n2. Pull weights outward.\n3. Keep tension on rear delts.");
        setupCardClick(R.id.Treadmill3, "Treadmill", R.raw.tredmill, "1. Run safely.\n2. High intensity interval.\n3. Finish with warmdown.");
        setupCardClick(R.id.DumbellSquats, "Dumbell squats", R.raw.dumbell_squats, "1. Stand with dumbbells at sides.\n2. Lower hips back and down.\n3. Push through heels to return.");
        setupCardClick(R.id.CalfRaise, "Calf raise", R.raw.calf_raise, "1. Stand on step edge.\n2. Lower heels down.\n3. Raise up onto toes.");
        setupCardClick(R.id.DeclineCrunch, "Decline crunch", R.raw.decline_crunch, "1. Lie back on decline bench.\n2. Crunch upward using abs.\n3. Return under control.");
    }

    private void setupCardClick(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_Male_Beginner_FullBody.this, Workout_Info.class);
                intent.putExtra(Workout_Info.EXTRA_TITLE, title);
                intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
                intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
                startActivity(intent);
            });
        }
    }
}