package com.example.fitness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Workout_Info extends AppCompatActivity {

    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_VIDEO = "EXTRA_VIDEO";
    public static final String EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_info);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        VideoView videoView = findViewById(R.id.videoView);
        TextView tvDescription = findViewById(R.id.tvExerciseDescription);

        toolbar.setNavigationOnClickListener(v -> finish());

        String title = getIntent().getStringExtra(EXTRA_TITLE);
        int videoRes = getIntent().getIntExtra(EXTRA_VIDEO, -1);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);

        if (title != null) toolbar.setTitle(title);
        if (description != null) tvDescription.setText(description);

        if (videoRes != -1) {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + videoRes);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);

            videoView.setOnPreparedListener(mp -> {
                mp.setLooping(true);
                videoView.start();
            });
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_handbook);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(Workout_Info.this, MainActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_handbook) {
                    startActivity(new Intent(Workout_Info.this, Handbook.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(Workout_Info.this, Profile.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
                }
                return false;
            });
        }
    }
}