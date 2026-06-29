package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Workout_Session extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_session);

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
                startActivity(new Intent(Workout_Session.this, MainActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                startActivity(new Intent(Workout_Session.this, Handbook.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(Workout_Session.this, Profile.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });

        TextView tvDayTitle = findViewById(R.id.tvDayTitle);
        Button btnFinishWorkout = findViewById(R.id.btnStartWorkout);

        CardView cardTreadmill = findViewById(R.id.Treadmill);
        CardView cardTreadmill2 = findViewById(R.id.Treadmill2);
        CardView cardTreadmill3 = findViewById(R.id.Treadmill3);
        CardView cardTreadmill4 = findViewById(R.id.Treadmill4);
        CardView cardTreadmill5 = findViewById(R.id.Treadmill5);
        CardView cardCycling = findViewById(R.id.Cycling);
        CardView cardClimber = findViewById(R.id.CLimber);
        CardView cardClimber2 = findViewById(R.id.CLimber2);

        CardView cardPlank = findViewById(R.id.Plank);
        CardView cardLegRaise = findViewById(R.id.LegRaise);
        CardView cardCrunchesTwist = findViewById(R.id.CrunchesTwist);
        CardView cardDeclineCrunch = findViewById(R.id.DeclineCrunch);
        CardView cardAbdominal = findViewById(R.id.AddominalCrunch);
        CardView cardSeatedCrunch = findViewById(R.id.SeatedCrunch);

        CardView cardBenchPress = findViewById(R.id.BenchPress);
        CardView cardInclineDumbell = findViewById(R.id.IncludeDumbell);
        CardView cardFlyChest = findViewById(R.id.FlyChest);
        CardView cardPushUp = findViewById(R.id.PushUp);

        CardView cardLatPulldown = findViewById(R.id.LatPulldown);
        CardView cardLatPulldown3 = findViewById(R.id.LatPulldown3);
        CardView cardPullUpBack = findViewById(R.id.PullUpBack);
        CardView cardWideCableRow = findViewById(R.id.WideCableRow);
        CardView cardRopePullover = findViewById(R.id.RopePullover);
        CardView cardNarrowGrip = findViewById(R.id.NarrowGripRow);

        CardView cardBarbellCurl = findViewById(R.id.BarbellCurl);
        CardView cardHammerCurl = findViewById(R.id.HammerCurl);
        CardView cardDumbellCurl = findViewById(R.id.DumbellCurl);
        CardView cardWristCurl = findViewById(R.id.BarbellWristCurl);

        CardView cardSquats = findViewById(R.id.Squats);
        CardView cardLegPress = findViewById(R.id.LegPress);
        CardView cardBulgarian = findViewById(R.id.BulgarianSplitSquat);
        CardView cardLegCurl = findViewById(R.id.LegCurl);
        CardView cardDumbellSquats = findViewById(R.id.DumbellSquats);
        CardView cardCalfRaise = findViewById(R.id.CalfRaise);
        CardView cardDumbellLunges = findViewById(R.id.DumbellLunges);
        CardView cardLegExtension = findViewById(R.id.LegExtension);

        CardView cardLateralRaise = findViewById(R.id.LateralRaise);
        CardView cardRearDelt = findViewById(R.id.RearDelt);
        CardView cardRearDelt2 = findViewById(R.id.RearDelt2);
        CardView cardArnoldPress = findViewById(R.id.ArnoldPress);
        CardView cardTriceps = findViewById(R.id.TricepsPushdown);

        CardView cardCableCurl = findViewById(R.id.CableCurl);
        CardView cardDumbellTricepsExt = findViewById(R.id.DumbellTricepsExtension);
        CardView cardPushUpTriceps = findViewById(R.id.PushUpTriceps);
        CardView cardKneePushUp = findViewById(R.id.KneePushUp);
        CardView cardReverseDips = findViewById(R.id.ReverseDips);
        CardView cardOverheadTricepsExt = findViewById(R.id.OverheadTricepsExtension);
        CardView cardDumbellWristCurl = findViewById(R.id.DumbellWristCurl);
        CardView cardLegBarbellLunges = findViewById(R.id.LegBarbellLunges);
        CardView cardBandedCrabWalk = findViewById(R.id.BandedCrabWalk);
        CardView cardBandedLateralRaise = findViewById(R.id.BandedLateralRaise);
        CardView cardGluteBridge = findViewById(R.id.GluteBridge);
        CardView cardDeadlift = findViewById(R.id.Deadlift);
        CardView cardDonkeyKick = findViewById(R.id.DonkeyKick);
        CardView cardGlutesExtension = findViewById(R.id.GlutesExtension);
        CardView cardPileDumbellSquats = findViewById(R.id.PileDumbellSquats);
        CardView cardDumbellPullover = findViewById(R.id.DumbellPullover);
        CardView cardCableCross = findViewById(R.id.CableCross);
        CardView cardCloseGripLatPulldown = findViewById(R.id.CloseGripLatPulldown);
        CardView cardTBarRowWide = findViewById(R.id.TBarRowWide);
        CardView cardTRXrow = findViewById(R.id.TRXrow);
        CardView cardRopeFacePullover = findViewById(R.id.RopeFacePullover);
        CardView cardAbcoasterCrunch = findViewById(R.id.AbcoasterCrunch);
        CardView cardLegRaiseAbs = findViewById(R.id.LegRaiseAbs);
        CardView cardFloorCrunch = findViewById(R.id.FloorCrunch);
        CardView cardJumpLunges = findViewById(R.id.JumpLunges);
        CardView cardBarbellSquats = findViewById(R.id.BarbellSquats);
        CardView cardAdductor = findViewById(R.id.Adductor);
        CardView cardBarbellUprightRow = findViewById(R.id.BarbellUprightRow);
        CardView cardDumbellRaise = findViewById(R.id.DumbellRaise);
        CardView cardReverseFly = findViewById(R.id.ReverseFly);
        CardView cardOverHeadPress = findViewById(R.id.OverHeadPress);

        hideAllCards(
                cardTreadmill, cardTreadmill2, cardTreadmill3, cardTreadmill4, cardTreadmill5,
                cardCycling, cardClimber, cardClimber2, cardPlank, cardLegRaise, cardCrunchesTwist,
                cardDeclineCrunch, cardAbdominal, cardSeatedCrunch, cardBenchPress, cardInclineDumbell,
                cardFlyChest, cardPushUp, cardLatPulldown, cardLatPulldown3, cardPullUpBack, cardWideCableRow,
                cardRopePullover, cardNarrowGrip, cardBarbellCurl, cardHammerCurl, cardDumbellCurl,
                cardWristCurl, cardSquats, cardLegPress, cardBulgarian, cardLegCurl, cardDumbellSquats,
                cardCalfRaise, cardDumbellLunges, cardLegExtension, cardLateralRaise, cardRearDelt,
                cardRearDelt2, cardArnoldPress, cardTriceps, cardCableCurl, cardDumbellTricepsExt,
                cardPushUpTriceps, cardKneePushUp, cardReverseDips, cardOverheadTricepsExt, cardDumbellWristCurl,
                cardLegBarbellLunges, cardBandedCrabWalk, cardBandedLateralRaise, cardGluteBridge, cardDeadlift,
                cardDonkeyKick, cardGlutesExtension, cardPileDumbellSquats, cardDumbellPullover, cardCableCross,
                cardCloseGripLatPulldown, cardTBarRowWide, cardTRXrow, cardRopeFacePullover, cardAbcoasterCrunch,
                cardLegRaiseAbs, cardFloorCrunch, cardJumpLunges, cardBarbellSquats, cardAdductor,
                cardBarbellUprightRow, cardDumbellRaise, cardReverseFly, cardOverHeadPress
        );

        boolean isCustom = getIntent().getBooleanExtra("IS_CUSTOM", false);

        if (isCustom) {
            String customDay = getIntent().getStringExtra("CUSTOM_DAY");
            if (tvDayTitle != null) tvDayTitle.setText("Custom Workout: " + customDay);

            SharedPreferences prefs = getSharedPreferences("WorkoutPrefs", Context.MODE_PRIVATE);
            String exercises = prefs.getString("plan_" + customDay, "");
            String[] exList = exercises.split(",");

            for (String ex : exList) {
                String name = ex.trim();
                if (name.isEmpty()) continue;

                String sets = "3";
                String reps = "12";
                String time = "-";
                if (name.equals("Treadmill") || name.equals("Cycling") || name.equals("CLimber") || name.equals("Plank")) {
                    sets = "-"; reps = "-"; time = "15 min";
                }

                switch (name) {
                    case "Pull up": showCards(cardPullUpBack); setupExerciseClick(cardPullUpBack, name, R.drawable.back_pull_up, sets, reps, time); break;
                    case "Close grip lat pulldown": showCards(cardCloseGripLatPulldown); setupExerciseClick(cardCloseGripLatPulldown, name, R.drawable.clode_grip_lat_pulldown, sets, reps, time); break;
                    case "Wide cable row": showCards(cardWideCableRow); setupExerciseClick(cardWideCableRow, name, R.drawable.wide_cable_row, sets, reps, time); break;
                    case "T bar row wide": showCards(cardTBarRowWide); setupExerciseClick(cardTBarRowWide, name, R.drawable.t_bar_row_wade, sets, reps, time); break;
                    case "Lat pulldown": showCards(cardLatPulldown); setupExerciseClick(cardLatPulldown, name, R.drawable.lat_pulldown, sets, reps, time); break;
                    case "TRX row": showCards(cardTRXrow); setupExerciseClick(cardTRXrow, name, R.drawable.trx_row, sets, reps, time); break;
                    case "Rope pullover": showCards(cardRopePullover); setupExerciseClick(cardRopePullover, name, R.drawable.rope_pullover, sets, reps, time); break;
                    case "Rope face pullover": showCards(cardRopeFacePullover); setupExerciseClick(cardRopeFacePullover, name, R.drawable.rope_face_pullover, sets, reps, time); break;
                    case "Narrow grip row": showCards(cardNarrowGrip); setupExerciseClick(cardNarrowGrip, name, R.drawable.narrow_grip_row, sets, reps, time); break;
                    case "Abcoaster crunch": showCards(cardAbcoasterCrunch); setupExerciseClick(cardAbcoasterCrunch, name, R.drawable.abcoaster_crunch, sets, reps, time); break;
                    case "Addominal crunch": showCards(cardAbdominal); setupExerciseClick(cardAbdominal, name, R.drawable.addominal_crunch, sets, reps, time); break;
                    case "Leg raise chair": showCards(cardLegRaiseAbs); setupExerciseClick(cardLegRaiseAbs, name, R.drawable.leg_press_abs, sets, reps, time); break;
                    case "Crunches twist": showCards(cardCrunchesTwist); setupExerciseClick(cardCrunchesTwist, name, R.drawable.crunches_twist, sets, reps, time); break;
                    case "Decline crunch": showCards(cardDeclineCrunch); setupExerciseClick(cardDeclineCrunch, name, R.drawable.decline_crunch, sets, reps, time); break;
                    case "Floor crunch": showCards(cardFloorCrunch); setupExerciseClick(cardFloorCrunch, name, R.drawable.floor_crunch, sets, reps, time); break;
                    case "Leg raise": showCards(cardLegRaise); setupExerciseClick(cardLegRaise, name, R.drawable.leg_raise, sets, reps, time); break;
                    case "Plank": showCards(cardPlank); setupExerciseClick(cardPlank, name, R.drawable.plank, sets, reps, time); break;
                    case "Seated crunch": showCards(cardSeatedCrunch); setupExerciseClick(cardSeatedCrunch, name, R.drawable.seated_crunch, sets, reps, time); break;
                    case "Dumbell curl": showCards(cardDumbellCurl); setupExerciseClick(cardDumbellCurl, name, R.drawable.dumbell_curl, sets, reps, time); break;
                    case "Barbell curl": showCards(cardBarbellCurl); setupExerciseClick(cardBarbellCurl, name, R.drawable.barbell_curl, sets, reps, time); break;
                    case "Hammer curl": showCards(cardHammerCurl); setupExerciseClick(cardHammerCurl, name, R.drawable.hammer_curl, sets, reps, time); break;
                    case "Cable curl": showCards(cardCableCurl); setupExerciseClick(cardCableCurl, name, R.drawable.cable_curl, sets, reps, time); break;
                    case "Treadmill": showCards(cardTreadmill); setupExerciseClick(cardTreadmill, name, R.drawable.tredmill, sets, reps, time); break;
                    case "CLimber": showCards(cardClimber); setupExerciseClick(cardClimber, name, R.drawable.climber, sets, reps, time); break;
                    case "Cycling": showCards(cardCycling); setupExerciseClick(cardCycling, name, R.drawable.cycling, sets, reps, time); break;
                    case "Bench press": showCards(cardBenchPress); setupExerciseClick(cardBenchPress, name, R.drawable.bench_press, sets, reps, time); break;
                    case "Incline dumbbell press": showCards(cardInclineDumbell); setupExerciseClick(cardInclineDumbell, name, R.drawable.include_dumbell, sets, reps, time); break;
                    case "Incline dumbbell fly": showCards(cardFlyChest); setupExerciseClick(cardFlyChest, name, R.drawable.fly_chest, sets, reps, time); break;
                    case "Cable cross": showCards(cardCableCross); setupExerciseClick(cardCableCross, name, R.drawable.cable_cross, sets, reps, time); break;
                    case "Push up": showCards(cardPushUp); setupExerciseClick(cardPushUp, name, R.drawable.push_up, sets, reps, time); break;
                    case "Dumbbell pullover": showCards(cardDumbellPullover); setupExerciseClick(cardDumbellPullover, name, R.drawable.dumbell_pullover, sets, reps, time); break;
                    case "Barbell wrist curl": showCards(cardWristCurl); setupExerciseClick(cardWristCurl, name, R.drawable.barbell_wrist_curl, sets, reps, time); break;
                    case "Dumbell wrist curl": showCards(cardDumbellWristCurl); setupExerciseClick(cardDumbellWristCurl, name, R.drawable.dumbell_wrist_curl, sets, reps, time); break;
                    case "Leg barbell lunges": showCards(cardLegBarbellLunges); setupExerciseClick(cardLegBarbellLunges, name, R.drawable.leg_barbell_lunges, sets, reps, time); break;
                    case "Banded crab walk": showCards(cardBandedCrabWalk); setupExerciseClick(cardBandedCrabWalk, name, R.drawable.banded_crab_walk, sets, reps, time); break;
                    case "Banded lateral raise": showCards(cardBandedLateralRaise); setupExerciseClick(cardBandedLateralRaise, name, R.drawable.banded_lateral_raise, sets, reps, time); break;
                    case "Glute bridge": showCards(cardGluteBridge); setupExerciseClick(cardGluteBridge, name, R.drawable.glute_bridge, sets, reps, time); break;
                    case "Bulgarian split squat": showCards(cardBulgarian); setupExerciseClick(cardBulgarian, name, R.drawable.bulgarian_split_squat, sets, reps, time); break;
                    case "Deadlift": showCards(cardDeadlift); setupExerciseClick(cardDeadlift, name, R.drawable.deadlift, sets, reps, time); break;
                    case "Donkey kick": showCards(cardDonkeyKick); setupExerciseClick(cardDonkeyKick, name, R.drawable.donkey_kick, sets, reps, time); break;
                    case "Glutes extension": showCards(cardGlutesExtension); setupExerciseClick(cardGlutesExtension, name, R.drawable.glutes_extension, sets, reps, time); break;
                    case "Plie dumbbell squats": showCards(cardPileDumbellSquats); setupExerciseClick(cardPileDumbellSquats, name, R.drawable.pile_dumbell_squats, sets, reps, time); break;
                    case "Squats": showCards(cardSquats); setupExerciseClick(cardSquats, name, R.drawable.squats, sets, reps, time); break;
                    case "Jump lunges": showCards(cardJumpLunges); setupExerciseClick(cardJumpLunges, name, R.drawable.jump_lunges, sets, reps, time); break;
                    case "Barbell squats": showCards(cardBarbellSquats); setupExerciseClick(cardBarbellSquats, name, R.drawable.barbell_squats, sets, reps, time); break;
                    case "Calf Raise": showCards(cardCalfRaise); setupExerciseClick(cardCalfRaise, name, R.drawable.calf_raise, sets, reps, time); break;
                    case "Dumbell squats": showCards(cardDumbellSquats); setupExerciseClick(cardDumbellSquats, name, R.drawable.dumbell_squats, sets, reps, time); break;
                    case "Dumbell lunges": showCards(cardDumbellLunges); setupExerciseClick(cardDumbellLunges, name, R.drawable.dumbell_lunges, sets, reps, time); break;
                    case "Adductor": showCards(cardAdductor); setupExerciseClick(cardAdductor, name, R.drawable.abbductor, sets, reps, time); break;
                    case "Leg press": showCards(cardLegPress); setupExerciseClick(cardLegPress, name, R.drawable.leg_press, sets, reps, time); break;
                    case "Leg curl": showCards(cardLegCurl); setupExerciseClick(cardLegCurl, name, R.drawable.leg_curl, sets, reps, time); break;
                    case "Leg extension": showCards(cardLegExtension); setupExerciseClick(cardLegExtension, name, R.drawable.leg_extension, sets, reps, time); break;
                    case "Arnold press": showCards(cardArnoldPress); setupExerciseClick(cardArnoldPress, name, R.drawable.arnold_press, sets, reps, time); break;
                    case "Barbell upright row": showCards(cardBarbellUprightRow); setupExerciseClick(cardBarbellUprightRow, name, R.drawable.barbell_upright_row, sets, reps, time); break;
                    case "Dumbell raise": showCards(cardDumbellRaise); setupExerciseClick(cardDumbellRaise, name, R.drawable.dumbell_raise, sets, reps, time); break;
                    case "Rear delt": showCards(cardRearDelt); setupExerciseClick(cardRearDelt, name, R.drawable.rear_delt, sets, reps, time); break;
                    case "Reverse fly": showCards(cardReverseFly); setupExerciseClick(cardReverseFly, name, R.drawable.reverse_fly, sets, reps, time); break;
                    case "Lateral raise": showCards(cardLateralRaise); setupExerciseClick(cardLateralRaise, name, R.drawable.lateral_raise, sets, reps, time); break;
                    case "Over head press": showCards(cardOverHeadPress); setupExerciseClick(cardOverHeadPress, name, R.drawable.overhead_press, sets, reps, time); break;
                    case "Triceps pushdown": showCards(cardTriceps); setupExerciseClick(cardTriceps, name, R.drawable.triceps_pushdown, sets, reps, time); break;
                    case "Dumbell triceps extension": showCards(cardDumbellTricepsExt); setupExerciseClick(cardDumbellTricepsExt, name, R.drawable.dumbell_triceps_extension, sets, reps, time); break;
                    case "Push up for triceps": showCards(cardPushUpTriceps); setupExerciseClick(cardPushUpTriceps, name, R.drawable.push_up_triceps, sets, reps, time); break;
                    case "Knee up push up": showCards(cardKneePushUp); setupExerciseClick(cardKneePushUp, name, R.drawable.knee_push_up, sets, reps, time); break;
                    case "Reverse dips": showCards(cardReverseDips); setupExerciseClick(cardReverseDips, name, R.drawable.reverse_dips, sets, reps, time); break;
                    case "Overhead triceps extension": showCards(cardOverheadTricepsExt); setupExerciseClick(cardOverheadTricepsExt, name, R.drawable.overhead_triceps_extension, sets, reps, time); break;
                }
            }
        } else {
            int planDayCode = getIntent().getIntExtra("PLAN_DAY_CODE", 10);
            if (tvDayTitle != null) {
                switch (planDayCode) {
                    case 10:
                        tvDayTitle.setText("Day 1: Hypertrophy and Endurance (Monday)");
                        showCards(cardTreadmill, cardSquats, cardGluteBridge, cardBulgarian, cardPlank, cardSeatedCrunch);
                        setupExerciseClick(cardTreadmill, "Treadmill", R.drawable.tredmill, "-", "-", "15 min");
                        setupExerciseClick(cardSquats, "Squats", R.drawable.squats, "4", "12-15", "-");
                        setupExerciseClick(cardGluteBridge, "Glute Bridge", R.drawable.glute_bridge, "4", "15", "-");
                        setupExerciseClick(cardBulgarian, "Bulgarian Split Squat", R.drawable.bulgarian_split_squat, "3", "12-15", "-");
                        setupExerciseClick(cardPlank, "Plank", R.drawable.plank, "3", "-", "45 sec");
                        setupExerciseClick(cardSeatedCrunch, "Seated Crunch", R.drawable.seated_crunch, "3", "15", "-");
                        break;
                    case 11:
                        tvDayTitle.setText("Day 2: Power and Performance (Wednesday)");
                        showCards(cardTreadmill2, cardOverHeadPress, cardInclineDumbell, cardTriceps, cardAbdominal);
                        setupExerciseClick(cardTreadmill2, "Treadmill", R.drawable.tredmill, "-", "-", "15 min");
                        setupExerciseClick(cardOverHeadPress, "Overhead Press", R.drawable.overhead_press, "4", "10-12", "-");
                        setupExerciseClick(cardInclineDumbell, "Incline Dumbbell Press", R.drawable.include_dumbell, "4", "10-12", "-");
                        setupExerciseClick(cardTriceps, "Triceps Pushdown", R.drawable.triceps_pushdown, "3", "15", "-");
                        setupExerciseClick(cardAbdominal, "Abdominal Crunch", R.drawable.addominal_crunch, "3", "15-20", "-");
                        break;
                    case 12:
                        tvDayTitle.setText("Day 3: Growth and Abs (Friday)");
                        showCards(cardTreadmill3, cardLatPulldown, cardNarrowGrip, cardDumbellCurl, cardCrunchesTwist, cardLegRaise);
                        setupExerciseClick(cardTreadmill3, "Treadmill", R.drawable.tredmill, "-", "-", "15 min");
                        setupExerciseClick(cardLatPulldown, "Lat Pulldown", R.drawable.lat_pulldown, "4", "10-12", "-");
                        setupExerciseClick(cardNarrowGrip, "Narrow Grip Row", R.drawable.narrow_grip_row, "3", "12", "-");
                        setupExerciseClick(cardDumbellCurl, "Dumbbell Curl", R.drawable.dumbell_curl, "3", "12", "-");
                        setupExerciseClick(cardCrunchesTwist, "Crunches Twist", R.drawable.crunches_twist, "3", "15", "-");
                        setupExerciseClick(cardLegRaise, "Leg Raise", R.drawable.leg_raise, "3", "15", "-");
                        break;
                    case 20:
                        tvDayTitle.setText("Day 1: Strength and Explosiveness (Monday)");
                        showCards(cardTreadmill, cardSquats, cardGluteBridge, cardPlank, cardSeatedCrunch);
                        setupExerciseClick(cardTreadmill, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardSquats, "Squats", R.drawable.squats, "3", "12", "-");
                        setupExerciseClick(cardGluteBridge, "Glute Bridge", R.drawable.glute_bridge, "3", "15", "-");
                        setupExerciseClick(cardPlank, "Plank", R.drawable.plank, "3", "-", "30 sec");
                        setupExerciseClick(cardSeatedCrunch, "Seated Crunch", R.drawable.seated_crunch, "3", "12", "-");
                        break;
                    case 21:
                        tvDayTitle.setText("Day 2: Muscle Growth (Wednesday)");
                        showCards(cardTreadmill2, cardOverHeadPress, cardTriceps, cardAbdominal, cardLegRaise);
                        setupExerciseClick(cardTreadmill2, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardOverHeadPress, "Overhead Press", R.drawable.overhead_press, "3", "10", "-");
                        setupExerciseClick(cardTriceps, "Triceps Pushdown", R.drawable.triceps_pushdown, "3", "12", "-");
                        setupExerciseClick(cardAbdominal, "Abdominal Crunch", R.drawable.addominal_crunch, "3", "15", "-");
                        setupExerciseClick(cardLegRaise, "Leg Raise", R.drawable.leg_raise, "3", "12", "-");
                        break;
                    case 22:
                        tvDayTitle.setText("Day 3: Growth and Abs (Friday)");
                        showCards(cardTreadmill3, cardLatPulldown, cardNarrowGrip, cardDumbellCurl, cardCrunchesTwist);
                        setupExerciseClick(cardTreadmill3, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardLatPulldown, "Lat Pulldown", R.drawable.lat_pulldown, "3", "12", "-");
                        setupExerciseClick(cardNarrowGrip, "Narrow Grip Row", R.drawable.narrow_grip_row, "3", "12", "-");
                        setupExerciseClick(cardDumbellCurl, "Dumbbell Curl", R.drawable.dumbell_curl, "3", "12", "-");
                        setupExerciseClick(cardCrunchesTwist, "Crunches Twist", R.drawable.crunches_twist, "3", "15", "-");
                        break;
                    case 30:
                        tvDayTitle.setText("Day 1: Strength and Tone (Monday)");
                        showCards(cardSquats, cardPushUp, cardBulgarian, cardDumbellRaise, cardPlank);
                        setupExerciseClick(cardSquats, "Squats", R.drawable.squats, "4", "15", "-");
                        setupExerciseClick(cardPushUp, "Push up", R.drawable.push_up, "3", "10", "-");
                        setupExerciseClick(cardBulgarian, "Bulgarian split squat", R.drawable.bulgarian_split_squat, "3", "12", "-");
                        setupExerciseClick(cardDumbellRaise, "Dumbbell raise", R.drawable.dumbell_raise, "3", "15", "-");
                        setupExerciseClick(cardPlank, "Plank", R.drawable.plank, "3", "-", "45 sec");
                        break;
                    case 31:
                        tvDayTitle.setText("Day 2: Cardio and Endurance (Wednesday)");
                        showCards(cardTreadmill2, cardDumbellLunges, cardLateralRaise, cardCycling, cardClimber);
                        setupExerciseClick(cardTreadmill2, "Treadmill", R.drawable.tredmill, "-", "-", "20 min");
                        setupExerciseClick(cardDumbellLunges, "Dumbbell Lunges", R.drawable.dumbell_lunges, "3", "12", "-");
                        setupExerciseClick(cardLateralRaise, "Lateral Raise", R.drawable.lateral_raise, "3", "15", "-");
                        setupExerciseClick(cardCycling, "Cycling", R.drawable.cycling, "-", "-", "15 min");
                        setupExerciseClick(cardClimber, "Climber", R.drawable.climber, "-", "-", "10 min");
                        break;
                    case 32:
                        tvDayTitle.setText("Day 3: Fat Burn and Power (Friday)");
                        showCards(cardGluteBridge, cardLatPulldown, cardLegExtension, cardLegRaise, cardClimber2, cardTreadmill5);
                        setupExerciseClick(cardGluteBridge, "Glute Bridge", R.drawable.glute_bridge, "3", "20", "-");
                        setupExerciseClick(cardLatPulldown, "Lat Pulldown", R.drawable.lat_pulldown, "3", "15", "-");
                        setupExerciseClick(cardLegExtension, "Leg Extension", R.drawable.leg_extension, "3", "15", "-");
                        setupExerciseClick(cardLegRaise, "Leg Raise", R.drawable.leg_raise, "3", "15", "-");
                        setupExerciseClick(cardClimber2, "Climber", R.drawable.climber, "-", "-", "10 min");
                        setupExerciseClick(cardTreadmill5, "Treadmill Sprint", R.drawable.tredmill, "-", "-", "10 min");
                        break;
                    case 40:
                        tvDayTitle.setText("Day 1: Strength and Explosiveness (Monday)");
                        showCards(cardTreadmill, cardBenchPress, cardInclineDumbell, cardOverHeadPress, cardLateralRaise, cardRearDelt2, cardTriceps);
                        setupExerciseClick(cardTreadmill, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardBenchPress, "Bench Press", R.drawable.bench_press, "4", "8-10", "-");
                        setupExerciseClick(cardInclineDumbell, "Incline Dumbbell", R.drawable.include_dumbell, "3", "10", "-");
                        setupExerciseClick(cardOverHeadPress, "Overhead Press", R.drawable.overhead_press, "4", "10", "-");
                        setupExerciseClick(cardLateralRaise, "Lateral Raise", R.drawable.lateral_raise, "3", "12", "-");
                        setupExerciseClick(cardRearDelt2, "Rear Delt", R.drawable.rear_delt, "3", "12", "-");
                        setupExerciseClick(cardTriceps, "Triceps Pushdown", R.drawable.triceps_pushdown, "3", "12", "-");
                        break;
                    case 41:
                        tvDayTitle.setText("Day 2: Back growth and Biceps (Wednesday)");
                        showCards(cardLatPulldown3, cardWideCableRow, cardRopePullover, cardBarbellCurl, cardHammerCurl);
                        setupExerciseClick(cardLatPulldown3, "Lat Pulldown", R.drawable.lat_pulldown, "4", "10", "-");
                        setupExerciseClick(cardWideCableRow, "Wide Cable Row", R.drawable.wide_cable_row, "4", "10", "-");
                        setupExerciseClick(cardRopePullover, "Rope Pullover", R.drawable.rope_pullover, "3", "12", "-");
                        setupExerciseClick(cardBarbellCurl, "Barbell Curl", R.drawable.barbell_curl, "4", "10", "-");
                        setupExerciseClick(cardHammerCurl, "Hammer Curl", R.drawable.hammer_curl, "3", "12", "-");
                        break;
                    case 42:
                        tvDayTitle.setText("Day 3: Leg growth (Friday)");
                        showCards(cardTreadmill3, cardDumbellSquats, cardLegPress, cardCalfRaise, cardDumbellLunges, cardLegCurl);
                        setupExerciseClick(cardTreadmill3, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardDumbellSquats, "Dumbbell Squats", R.drawable.dumbell_squats, "4", "10", "-");
                        setupExerciseClick(cardLegPress, "Leg Press", R.drawable.leg_press, "4", "10-12", "-");
                        setupExerciseClick(cardCalfRaise, "Calf Raise", R.drawable.calf_raise, "4", "15", "-");
                        setupExerciseClick(cardDumbellLunges, "Dumbbell Lunges", R.drawable.dumbell_lunges, "3", "12", "-");
                        setupExerciseClick(cardLegCurl, "Leg Curl", R.drawable.leg_curl, "4", "12-15", "-");
                        break;
                    case 50:
                        tvDayTitle.setText("Day 1: Strength and Explosiveness (Monday)");
                        showCards(cardTreadmill, cardPushUp, cardInclineDumbell, cardOverHeadPress, cardTriceps);
                        setupExerciseClick(cardTreadmill, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardPushUp, "Push up", R.drawable.push_up, "3", "10-12", "-");
                        setupExerciseClick(cardInclineDumbell, "Incline Dumbbell", R.drawable.include_dumbell, "3", "10-12", "-");
                        setupExerciseClick(cardOverHeadPress, "Overhead Press", R.drawable.overhead_press, "3", "10", "-");
                        setupExerciseClick(cardTriceps, "Triceps Pushdown", R.drawable.triceps_pushdown, "3", "12", "-");
                        break;
                    case 51:
                        tvDayTitle.setText("Day 2: Back growth (Wednesday)");
                        showCards(cardTreadmill2, cardLatPulldown, cardPullUpBack, cardWideCableRow, cardRearDelt);
                        setupExerciseClick(cardTreadmill2, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardLatPulldown, "Lat Pulldown", R.drawable.lat_pulldown, "3", "12", "-");
                        setupExerciseClick(cardPullUpBack, "Pull Up", R.drawable.back_pull_up, "3", "8-10", "-");
                        setupExerciseClick(cardWideCableRow, "Wide Cable Row", R.drawable.wide_cable_row, "3", "12", "-");
                        setupExerciseClick(cardRearDelt, "Rear Delt", R.drawable.rear_delt, "3", "15", "-");
                        break;
                    case 52:
                        tvDayTitle.setText("Day 3: Leg growth (Friday)");
                        showCards(cardTreadmill3, cardDumbellSquats, cardCalfRaise, cardDeclineCrunch);
                        setupExerciseClick(cardTreadmill3, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardDumbellSquats, "Dumbbell Squats", R.drawable.dumbell_squats, "3", "12", "-");
                        setupExerciseClick(cardCalfRaise, "Calf Raise", R.drawable.calf_raise, "3", "15", "-");
                        setupExerciseClick(cardDeclineCrunch, "Decline Crunch", R.drawable.decline_crunch, "3", "15", "-");
                        break;
                    case 60:
                        tvDayTitle.setText("Day 1: Strength and Explosiveness (Monday)");
                        showCards(cardTreadmill, cardPushUp, cardInclineDumbell, cardLatPulldown, cardFlyChest, cardTreadmill2);
                        setupExerciseClick(cardTreadmill, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardPushUp, "Push up", R.drawable.push_up, "3", "15", "-");
                        setupExerciseClick(cardInclineDumbell, "Incline Dumbbell", R.drawable.include_dumbell, "3", "12", "-");
                        setupExerciseClick(cardLatPulldown, "Lat Pulldown", R.drawable.lat_pulldown, "3", "15", "-");
                        setupExerciseClick(cardFlyChest, "Chest Fly", R.drawable.fly_chest, "3", "15", "-");
                        setupExerciseClick(cardTreadmill2, "Treadmill Sprint", R.drawable.tredmill, "-", "-", "10 min");
                        break;
                    case 61:
                        tvDayTitle.setText("Day 2: Conditioning and Stability (Wednesday)");
                        showCards(cardTreadmill3, cardLegPress, cardLegCurl, cardLegExtension, cardRearDelt, cardCycling);
                        setupExerciseClick(cardTreadmill3, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardLegPress, "Leg Press", R.drawable.leg_press, "3", "15", "-");
                        setupExerciseClick(cardLegCurl, "Leg Curl", R.drawable.leg_curl, "3", "15", "-");
                        setupExerciseClick(cardLegExtension, "Leg Extension", R.drawable.leg_extension, "3", "15", "-");
                        setupExerciseClick(cardRearDelt, "Rear Delt", R.drawable.rear_delt, "3", "15", "-");
                        setupExerciseClick(cardCycling, "Cycling", R.drawable.cycling, "-", "-", "20 min");
                        break;
                    case 62:
                        tvDayTitle.setText("Day 3: Heavy Strength and Power (Friday)");
                        showCards(cardTreadmill4, cardArnoldPress, cardLateralRaise, cardWristCurl, cardClimber, cardTreadmill5);
                        setupExerciseClick(cardTreadmill4, "Treadmill", R.drawable.tredmill, "-", "-", "10 min");
                        setupExerciseClick(cardArnoldPress, "Arnold Press", R.drawable.arnold_press, "3", "12", "-");
                        setupExerciseClick(cardLateralRaise, "Lateral Raise", R.drawable.lateral_raise, "3", "15", "-");
                        setupExerciseClick(cardWristCurl, "Wrist Curl", R.drawable.crunches_twist, "3", "15", "-");
                        setupExerciseClick(cardClimber, "Climber", R.drawable.climber, "-", "-", "15 min");
                        setupExerciseClick(cardTreadmill5, "Treadmill Cool Down", R.drawable.tredmill, "-", "-", "10 min");
                        break;
                }
            }
        }

        if (btnFinishWorkout != null) {
            btnFinishWorkout.setOnClickListener(v -> {
                SharedPreferences userPrefs = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE);
                String currentEmail = userPrefs.getString("current_logged_email", "default_user");

                SharedPreferences statsPrefs = getSharedPreferences("WorkoutStats", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = statsPrefs.edit();

                String finishedKey = currentEmail + "_Finished_Workouts";

                int currentFinished = statsPrefs.getInt(finishedKey, 0);

                editor.putInt(finishedKey, currentFinished + 1);
                editor.apply();

                finish();
            });
        }
    }

    private void hideAllCards(CardView... cards) {
        for (CardView card : cards) {
            if (card != null) card.setVisibility(View.GONE);
        }
    }

    private void showCards(CardView... cards) {
        for (CardView card : cards) {
            if (card != null) card.setVisibility(View.VISIBLE);
        }
    }

    private void setupExerciseClick(CardView card, String name, int imageRes, String sets, String reps, String time) {
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(Workout_Session.this, Workout_Start.class);
                intent.putExtra("EXERCISE_NAME", name);
                intent.putExtra("EXERCISE_VIDEO_RES", imageRes);
                intent.putExtra("EXERCISE_SETS", sets);
                intent.putExtra("EXERCISE_REPS", reps);
                intent.putExtra("EXERCISE_TIME", time);
                startActivity(intent);
            });
        }
    }
}