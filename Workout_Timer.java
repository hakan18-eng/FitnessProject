package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Locale;

public class Workout_Timer extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private TextView tvWorkoutTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_timer);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvWorkoutTimer = findViewById(R.id.tvWorkoutTimer);
        Button btnContinue = findViewById(R.id.btnContinue);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        startTimer(180000);

        btnContinue.setOnClickListener(v -> {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            finish();
        });

        bottomNav.setSelectedItemId(R.id.nav_handbook);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (countDownTimer != null) countDownTimer.cancel();

            if (id == R.id.nav_home) {
                startActivity(new Intent(Workout_Timer.this, MainActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                startActivity(new Intent(Workout_Timer.this, Handbook.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(Workout_Timer.this, Profile.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });
    }

    private void startTimer(long durationInMillis) {
        countDownTimer = new CountDownTimer(durationInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;

                String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                tvWorkoutTimer.setText(timeLeftFormatted);
            }

            @Override
            public void onFinish() {
                tvWorkoutTimer.setText("00:00");
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}