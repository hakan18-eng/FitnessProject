package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Create_Workout_Plan extends AppCompatActivity {

    private String selectedDay = "Monday";
    private TextView tvMonday, tvTuesday, tvWednesday, tvThursday, tvFriday;
    private LinearLayout llExercisesContainer;
    private SharedPreferences tempPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout_plan);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        tempPrefs = getSharedPreferences("TempWorkout", Context.MODE_PRIVATE);
        selectedDay = tempPrefs.getString("current_selected_day", "Monday");

        tvMonday = findViewById(R.id.tvMonday);
        tvTuesday = findViewById(R.id.tvTuesday);
        tvWednesday = findViewById(R.id.tvWednesday);
        tvThursday = findViewById(R.id.tvThursday);
        tvFriday = findViewById(R.id.tvFriday);
        llExercisesContainer = findViewById(R.id.llExercisesContainer);
        EditText etWorkoutName = findViewById(R.id.etWorkoutName);
        TextView btnAddExercise = findViewById(R.id.btnAddNewExercise);
        Button btnSavePlan = findViewById(R.id.btnSavePlan);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        setupDayClickListeners();
        updateDaysUI();
        loadExercisesForSelectedDay();

        btnAddExercise.setOnClickListener(v -> {
            Intent intent = new Intent(Create_Workout_Plan.this, Exercice.class);
            intent.putExtra("MODE", "ADD_EXERCISE");
            startActivity(intent);
        });

        btnSavePlan.setOnClickListener(v -> {
            String workoutName = etWorkoutName.getText().toString().trim();
            String monExercises = tempPrefs.getString("exercise_list_Monday", "");

            if (workoutName.isEmpty() || monExercises.isEmpty()) {
                Toast.makeText(this, "Please enter a name and add at least one exercise to Monday!", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences officialPrefs = getSharedPreferences("WorkoutPrefs", Context.MODE_PRIVATE);
            officialPrefs.edit()
                    .putString("saved_title", workoutName)
                    .putInt("saved_image", R.drawable.advanced)
                    .putString("plan_Monday", tempPrefs.getString("exercise_list_Monday", ""))
                    .putString("plan_Tuesday", tempPrefs.getString("exercise_list_Tuesday", ""))
                    .putString("plan_Wednesday", tempPrefs.getString("exercise_list_Wednesday", ""))
                    .putString("plan_Thursday", tempPrefs.getString("exercise_list_Thursday", ""))
                    .putString("plan_Friday", tempPrefs.getString("exercise_list_Friday", ""))
                    .apply();

            tempPrefs.edit().clear().apply();

            Toast.makeText(this, "Workout Plan Saved!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Create_Workout_Plan.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.nav_handbook) {
                startActivity(new Intent(this, Handbook.class));
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, Profile.class));
                return true;
            }
            return false;
        });
    }

    private void setupDayClickListeners() {
        tvMonday.setOnClickListener(v -> selectDay("Monday"));
        tvTuesday.setOnClickListener(v -> selectDay("Tuesday"));
        tvWednesday.setOnClickListener(v -> selectDay("Wednesday"));
        tvThursday.setOnClickListener(v -> selectDay("Thursday"));
        tvFriday.setOnClickListener(v -> selectDay("Friday"));
    }

    private void selectDay(String day) {
        selectedDay = day;
        tempPrefs.edit().putString("current_selected_day", selectedDay).apply();
        updateDaysUI();
        loadExercisesForSelectedDay();
    }

    private void updateDaysUI() {
        setDayActive(tvMonday, selectedDay.equals("Monday"));
        setDayActive(tvTuesday, selectedDay.equals("Tuesday"));
        setDayActive(tvWednesday, selectedDay.equals("Wednesday"));
        setDayActive(tvThursday, selectedDay.equals("Thursday"));
        setDayActive(tvFriday, selectedDay.equals("Friday"));
    }

    private void setDayActive(TextView tv, boolean isActive) {
        if (isActive) {
            tv.setBackgroundColor(Color.parseColor("#00BFA5"));
            tv.setTextColor(Color.parseColor("#121212"));
            tv.setTypeface(null, android.graphics.Typeface.BOLD);
        } else {
            tv.setBackgroundColor(Color.parseColor("#222222"));
            tv.setTextColor(Color.parseColor("#8E8E93"));
            tv.setTypeface(null, android.graphics.Typeface.NORMAL);
        }
    }

    private void loadExercisesForSelectedDay() {
        llExercisesContainer.removeAllViews();
        String savedExercises = tempPrefs.getString("exercise_list_" + selectedDay, "");

        if (!savedExercises.isEmpty()) {
            String[] exercises = savedExercises.split(",");
            for (String ex : exercises) {
                if (!ex.trim().isEmpty()) {
                    createExerciseCard(ex.trim());
                }
            }
        }
    }

    private void createExerciseCard(String exerciseName) {
        float density = getResources().getDisplayMetrics().density;

        CardView card = new CardView(this);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(0, 0, 0, (int)(12 * density));
        card.setLayoutParams(cardParams);
        card.setRadius(14 * density);
        card.setCardElevation(6 * density);
        card.setCardBackgroundColor(Color.TRANSPARENT);

        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)(110 * density)));
        ll.setBackgroundResource(R.drawable.card_border);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setGravity(Gravity.CENTER_VERTICAL);
        ll.setPadding((int)(10 * density), (int)(10 * density), (int)(10 * density), (int)(10 * density));

        ImageView iv = new ImageView(this);
        LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams((int)(90 * density), (int)(90 * density));
        iv.setLayoutParams(ivParams);
        iv.setBackgroundColor(Color.BLACK);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setImageResource(getExerciseImage(exerciseName));

        View spacer = new View(this);
        LinearLayout.LayoutParams spacerParams = new LinearLayout.LayoutParams((int)(12 * density), ViewGroup.LayoutParams.MATCH_PARENT);
        spacer.setLayoutParams(spacerParams);

        TextView tv = new TextView(this);
        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
        tv.setLayoutParams(tvParams);
        tv.setText(exerciseName);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(18f);
        tv.setTypeface(null, android.graphics.Typeface.BOLD);

        Button btnDelete = new Button(this);
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams((int)(80 * density), (int)(50 * density));
        btnDelete.setLayoutParams(btnParams);
        btnDelete.setText("DELETE");
        btnDelete.setTextSize(12f);
        btnDelete.setTypeface(null, android.graphics.Typeface.BOLD);
        btnDelete.setTextColor(Color.parseColor("#FF5252"));
        btnDelete.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1C1C1E")));
        btnDelete.setPadding(0, 0, 0, 0);

        btnDelete.setOnClickListener(v -> deleteExercise(exerciseName));

        ll.addView(iv);
        ll.addView(spacer);
        ll.addView(tv);
        ll.addView(btnDelete);
        card.addView(ll);

        llExercisesContainer.addView(card);
    }

    private void deleteExercise(String exerciseName) {
        String currentList = tempPrefs.getString("exercise_list_" + selectedDay, "");
        List<String> list = new ArrayList<>(Arrays.asList(currentList.split(",")));
        list.remove(exerciseName);

        StringBuilder newList = new StringBuilder();
        for (String s : list) {
            if (!s.trim().isEmpty()) {
                newList.append(s.trim()).append(",");
            }
        }

        tempPrefs.edit().putString("exercise_list_" + selectedDay, newList.toString()).apply();
        loadExercisesForSelectedDay();
    }

    private int getExerciseImage(String name) {
        switch (name) {
            case "Pull up": return R.drawable.back_pull_up;
            case "Close grip lat pulldown": return R.drawable.clode_grip_lat_pulldown;
            case "Wide cable row": return R.drawable.wide_cable_row;
            case "T bar row wide": return R.drawable.t_bar_row_wade;
            case "Lat pulldown": return R.drawable.lat_pulldown;
            case "TRX row": return R.drawable.trx_row;
            case "Rope pullover": return R.drawable.rope_pullover;
            case "Rope face pullover": return R.drawable.rope_face_pullover;
            case "Narrow grip row": return R.drawable.narrow_grip_row;
            case "Abcoaster crunch": return R.drawable.abcoaster_crunch;
            case "Addominal crunch": return R.drawable.addominal_crunch;
            case "Leg raise chair": return R.drawable.leg_press_abs;
            case "Crunches twist": return R.drawable.crunches_twist;
            case "Decline crunch": return R.drawable.decline_crunch;
            case "Floor crunch": return R.drawable.floor_crunch;
            case "Leg raise": return R.drawable.leg_raise;
            case "Plank": return R.drawable.plank;
            case "Seated crunch": return R.drawable.seated_crunch;
            case "Dumbell curl": return R.drawable.dumbell_curl;
            case "Barbell curl": return R.drawable.barbell_curl;
            case "Hammer curl": return R.drawable.hammer_curl;
            case "Cable curl": return R.drawable.cable_curl;
            case "Treadmill": return R.drawable.tredmill;
            case "CLimber": return R.drawable.climber;
            case "Cycling": return R.drawable.cycling;
            case "Bench press": return R.drawable.bench_press;
            case "Incline dumbbell press": return R.drawable.include_dumbell;
            case "Incline dumbbell fly": return R.drawable.fly_chest;
            case "Cable cross": return R.drawable.cable_cross;
            case "Push up": return R.drawable.push_up;
            case "Dumbbell pullover": return R.drawable.dumbell_pullover;
            case "Barbell wrist curl": return R.drawable.barbell_wrist_curl;
            case "Dumbell wrist curl": return R.drawable.dumbell_wrist_curl;
            case "Leg barbell lunges": return R.drawable.leg_barbell_lunges;
            case "Banded crab walk": return R.drawable.banded_crab_walk;
            case "Banded lateral raise": return R.drawable.banded_lateral_raise;
            case "Glute bridge": return R.drawable.glute_bridge;
            case "Bulgarian split squat": return R.drawable.bulgarian_split_squat;
            case "Deadlift": return R.drawable.deadlift;
            case "Donkey kick": return R.drawable.donkey_kick;
            case "Glutes extension": return R.drawable.glutes_extension;
            case "Plie dumbbell squats": return R.drawable.pile_dumbell_squats;
            case "Squats": return R.drawable.squats;
            case "Jump lunges": return R.drawable.jump_lunges;
            case "Barbell squats": return R.drawable.barbell_squats;
            case "Calf Raise": return R.drawable.calf_raise;
            case "Dumbell squats": return R.drawable.dumbell_squats;
            case "Dumbell lunges": return R.drawable.dumbell_lunges;
            case "Adductor": return R.drawable.abbductor;
            case "Leg press": return R.drawable.leg_press;
            case "Leg curl": return R.drawable.leg_curl;
            case "Leg extension": return R.drawable.leg_extension;
            case "Arnold press": return R.drawable.arnold_press;
            case "Barbell upright row": return R.drawable.barbell_upright_row;
            case "Dumbell raise": return R.drawable.dumbell_raise;
            case "Rear delt": return R.drawable.rear_delt;
            case "Reverse fly": return R.drawable.reverse_fly;
            case "Lateral raise": return R.drawable.lateral_raise;
            case "Over head press": return R.drawable.overhead_press;
            case "Triceps pushdown": return R.drawable.triceps_pushdown;
            case "Dumbell triceps extension": return R.drawable.dumbell_triceps_extension;
            case "Push up for triceps": return R.drawable.push_up_triceps;
            case "Knee up push up": return R.drawable.knee_push_up;
            case "Reverse dips": return R.drawable.reverse_dips;
            case "Overhead triceps extension": return R.drawable.overhead_triceps_extension;
            default: return R.drawable.ic_logo2;
        }
    }
}