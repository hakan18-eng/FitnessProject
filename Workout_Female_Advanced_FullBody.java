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

public class Workout_Female_Advanced_FullBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_female_advanced_full_body);

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
                Intent intent = new Intent(Workout_Female_Advanced_FullBody.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                Intent intent = new Intent(Workout_Female_Advanced_FullBody.this, Handbook.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                Intent intent = new Intent(Workout_Female_Advanced_FullBody.this, Profile.class);
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
                        .putString("saved_title", "Full body (Advanced For Female)")
                        .putInt("saved_image", R.drawable.female6)
                        .apply();

                Toast.makeText(this, "Workout Plan Activated!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            });
        }

        setupCardClick(R.id.Treadmill, "Treadmill", R.raw.tredmill, "1. Start with a moderate warmup pace.\n2. Increase speed for cardiovascular conditioning.\n3. Finish with a steady cooldown.");
        setupCardClick(R.id.Squats, "Squats", R.raw.squats, "1. Stand with feet shoulder-width apart.\n2. Lower your hips down while keeping chest proud.\n3. Drive back up through your heels.");
        setupCardClick(R.id.GluteBridge, "Hip thrust", R.raw.glute_bridge, "1. Place upper back on bench, barbell over hips.\n2. Drive hips vertically upward, squeezing glutes.\n3. Lower with control.");
        setupCardClick(R.id.BulgarianSplitSquat, "Bulgarian split squat", R.raw.bulgarian_split_squat, "1. Rest one foot behind you on a bench.\n2. Squat down until front thigh is parallel.\n3. Push through front foot to return.");
        setupCardClick(R.id.Plank, "Plank", R.raw.plank, "1. Align forearms on floor directly under shoulders.\n2. Keep a completely straight, rigid body structure.\n3. Brace core and hold tight.");
        setupCardClick(R.id.SeatedCrunch, "Seated crunch", R.raw.seated_crunch, "1. Position yourself correctly on the crunch machine.\n2. Compress torso forward using abdominal tension.\n3. Slow return control.");

        setupCardClick(R.id.Treadmill2, "Treadmill", R.raw.tredmill, "1. Mid-week active aerobic session.\n2. Maintain consistent running velocity.\n3. Walk down dynamically to lower heart rate.");
        setupCardClick(R.id.OverHeadPress, "Overhead press", R.raw.overhead_press, "1. Hold bar at high upper chest level.\n2. Drive bar directly upwards overhead.\n3. Bring down with strict deceleration control.");
        setupCardClick(R.id.IncludeDumbell, "Incline dumbell press", R.raw.incline_press, "1. Lean securely on an incline gym bench.\n2. Press dumbbells vertically together above you.\n3. Lower weights along structural path slowly.");
        setupCardClick(R.id.TricepsPushdown, "Triceps pushdown", R.raw.triceps_pushdown, "1. Face high pulley assembly.\n2. Flex triceps down until arms are locked straight.\n3. Release slowly to starting posture.");
        setupCardClick(R.id.AddominalCrunch, "Addominal crunch", R.raw.abdominal_crunch, "1. Lie flat on mat, knees safely flexed.\n2. Elevate shoulder blades upward compressing ribs.\n3. Release slowly under gravity resistance.");

        setupCardClick(R.id.Treadmill3, "Treadmill", R.raw.tredmill, "1. Final weekly interval conditioning stage.\n2. Focus on linear metabolic stimulation.\n3. Conclude with proper dynamic pacing recovery.");
        setupCardClick(R.id.LatPulldown, "Lat pulldown", R.raw.lat_pulldown, "1. Take wide grip on long cable bar.\n2. Draw down smoothly to superior chest zone.\n3. Extend arms back up against line resistance.");
        setupCardClick(R.id.NarrowGripRow, "Seated narrow grip row", R.raw.narrow_grip_row, "1. Sit straight facing cable platform.\n2. Pull low attachment row handle towards waist area.\n3. Squeeze scapulae together entirely.");
        setupCardClick(R.id.DumbellCurl, "Dumbell curl", R.raw.dumbell_curl, "1. Hold weights straight with arms down.\n2. Flex elbows upwards rotating palms inward.\n3. Lower with continuous eccentric muscle tension.");
        setupCardClick(R.id.CrunchesTwist, "Crunches twist", R.raw.crunches_twist, "1. Keep supine position, hands gently touching head.\n2. Rotate upper body bringing elbow toward alternate knee.\n3. Maintain constant tension.");
        setupCardClick(R.id.LegRaise, "Leg raise", R.raw.leg_raise, "1. Keep spine completely flat down against mat.\n2. Raise straight legs up to right angle position.\n3. Lower down under strict abdominal control.");
    }

    private void setupCardClick(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_Female_Advanced_FullBody.this, Workout_Info.class);
                intent.putExtra(Workout_Info.EXTRA_TITLE, title);
                intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
                intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
                startActivity(intent);
            });
        }
    }
}