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

public class Workout_Male_Weight_Loss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_male_weight_loss);

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
                startActivity(new Intent(Workout_Male_Weight_Loss.this, MainActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                startActivity(new Intent(Workout_Male_Weight_Loss.this, Handbook.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(Workout_Male_Weight_Loss.this, Profile.class));
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
                        .putString("saved_title", "Weight loss (Male)")
                        .putInt("saved_image", R.drawable.begginer1)
                        .apply();

                Toast.makeText(this, "Workout Plan Activated!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            });
        }

        setupCardClick(R.id.Treadmill, "Treadmill", R.raw.tredmill, "1. Start with warm up pace 5 km/h.\n2. Incline to level 3 after 5 mins.\n3. Keep dynamic hand motion.");
        setupCardClick(R.id.BenchPress, "Bench press", R.raw.bench_press, "1. Lie flat down securely on standard bench.\n2. Place hands wider than shoulder width.\n3. Lower bar smoothly touching middle chest.");
        setupCardClick(R.id.IncludeDumbell, "Incline dumbbell press", R.raw.incline_press, "1. Set adjustable bench around 30-45 degrees.\n2. Raise weights straight up dynamically.\n3. Bring weights down keeping elbow alignment.");
        setupCardClick(R.id.LatPulldown, "Lat pulldown", R.raw.lat_pulldown, "1. Take wide comfortable bar grip position.\n2. Pull attachment straight down towards collarbone.\n3. Extend back up under high friction control.");
        setupCardClick(R.id.FlyChest, "Incline dumbbell fly", R.raw.incline_fly, "1. Maintain continuous back posture on incline bench.\n2. Open arms wide simulating giant hugging motion.\n3. Squeeze pectorals hard at peak height.");
        setupCardClick(R.id.Treadmill2, "Treadmill", R.raw.tredmill, "1. High intensity cardiovascular training stage.\n2. Speed up to 10 km/h interval loops.\n3. Recover to base speed gradually.");
        setupCardClick(R.id.LegPress, "Leg press", R.raw.leg_press, "1. Place feet high in platform center.\n2. Disengage safety lock mechanics safely.\n3. Lower sled down carefully to right angle knee.");
        setupCardClick(R.id.LegCurl, "Leg curl", R.raw.leg_curl, "1. Position body face down on leg curl frame.\n2. Position roller behind low Achilles heel.\n3. Flex hamstrings intensely backward entirely.");
        setupCardClick(R.id.LegExtension, "Leg extension", R.raw.leg_extension, "1. Rest back firmly into support padding.\n2. Place shins clean against bottom roller.\n3. Drive legs straight into absolute extension.");
        setupCardClick(R.id.RearDelt, "Rear delt", R.raw.rear_delt, "1. Stand tall holding light dumbbells.\n2. Bend forward from waist keeping back flat.\n3. Raise weights out to sides squeezing rear shoulders.");
        setupCardClick(R.id.Cycling, "Cycling", R.raw.cycling, "1. Choose level 6 resistance setting.\n2. Keep standard revolutions per minute above 80.\n3. Maintain constant leg drive force.");
        setupCardClick(R.id.ArnoldPress, "Arnold press", R.raw.arnold_press, "1. Sit straight up holding dumbbells facing you.\n2. Rotate wrists outward while pressing overhead.\n3. Reverse movement back down.");
        setupCardClick(R.id.LateralRaise, "Lateral raise", R.raw.lateral_raise, "1. Hold dumbbells lightly at sides.\n2. Elevate arms outward parallel to floor.\n3. Control deceleration phase down.");
        setupCardClick(R.id.BarbellWristCurl, "Barbell wrist curl", R.raw.barbell_wrist_curl, "1. Rest forearms down securely on a bench flat surface.\n2. Let weight roll into fingers safely.\n3. Curl wrists upward entirely.");
        setupCardClick(R.id.CLimber, "Climber", R.raw.climber, "1. Secure handles safely on stepper.\n2. Drive steps down alternating feet.\n3. Build dynamic fat burning conditioning.");
        setupCardClick(R.id.Treadmill5, "Treadmill", R.raw.tredmill, "1. Final steady state fat depletion run.\n2. Keep stable linear form.\n3. Finish with adequate walking recovery.");
    }

    private void setupCardClick(int viewId, String title, int videoRes, String description) {
        CardView card = findViewById(viewId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_Male_Weight_Loss.this, Workout_Info.class);
                intent.putExtra(Workout_Info.EXTRA_TITLE, title);
                intent.putExtra(Workout_Info.EXTRA_VIDEO, videoRes);
                intent.putExtra(Workout_Info.EXTRA_DESCRIPTION, description);
                startActivity(intent);
            });
        }
    }
}