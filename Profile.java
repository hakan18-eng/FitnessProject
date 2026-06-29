package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Profile extends AppCompatActivity {

    private ActivityResultLauncher<String> pickImageLauncher;
    private ImageView ivProfilePicture;
    private SharedPreferences prefs;
    private String currentEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvProfileName = findViewById(R.id.tvProfileName);
        TextView tvProfileEmail = findViewById(R.id.tvProfileEmail);
        TextView tvProfileAge = findViewById(R.id.tvProfileAge);
        ivProfilePicture = findViewById(R.id.ivProfilePicture);
        View cvProfileImage = findViewById(R.id.cvProfileImage);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavProfile);
        Button btnLogout = findViewById(R.id.btnLogout);

        prefs = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE);
        currentEmail = prefs.getString("current_logged_email", "No Email");
        String currentName = prefs.getString("name_" + currentEmail, "Unknown User");
        String currentAge = prefs.getString("age_" + currentEmail, "?");

        tvProfileName.setText(currentName);
        tvProfileEmail.setText(currentEmail);
        tvProfileAge.setText(currentAge + " years old");

        String savedImagePath = prefs.getString("profile_pic_" + currentEmail, null);
        if (savedImagePath != null) {
            ivProfilePicture.setImageURI(Uri.parse(savedImagePath));
        }

        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        String imagePath = saveImageToInternalStorage(uri, currentEmail);
                        if (imagePath != null) {
                            ivProfilePicture.setImageURI(Uri.parse(imagePath));
                            prefs.edit().putString("profile_pic_" + currentEmail, imagePath).apply();
                        }
                    }
                }
        );

        if (cvProfileImage != null) {
            cvProfileImage.setOnClickListener(v -> pickImageLauncher.launch("image/*"));
        }

        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.remove("current_logged_email");
            editor.apply();

            Intent intent = new Intent(Profile.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        bottomNav.setSelectedItemId(R.id.nav_profile);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(Profile.this, MainActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_handbook) {
                startActivity(new Intent(Profile.this, Handbook.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.nav_profile) {
                return true;
            }
            return false;
        });

        updateStatsGraph();
    }

    private String saveImageToInternalStorage(Uri uri, String email) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            String safeEmail = email.replace("@", "_").replace(".", "_");
            File file = new File(getFilesDir(), "profile_" + safeEmail + ".jpg");
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateStatsGraph();
    }

    private void updateStatsGraph() {
        SharedPreferences userPrefs = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE);
        String currentEmail = userPrefs.getString("current_logged_email", "default_user");

        SharedPreferences statsPrefs = getSharedPreferences("WorkoutStats", Context.MODE_PRIVATE);

        int upperBodySets = statsPrefs.getInt(currentEmail + "_Upper Body", 0);
        int cardioSets = statsPrefs.getInt(currentEmail + "_Cardio", 0);
        int legsSets = statsPrefs.getInt(currentEmail + "_Legs", 0);
        int gluteusSets = statsPrefs.getInt(currentEmail + "_Gluteus", 0);

        TextView tvWorkoutCount = findViewById(R.id.tvWorkoutCount);
        TextView tvUpperBodyReps = findViewById(R.id.tvUpperBodyReps);
        TextView tvCardioReps = findViewById(R.id.tvCardioReps);
        TextView tvLegsReps = findViewById(R.id.tvLegsReps);
        TextView tvGluteusReps = findViewById(R.id.tvGluteusReps);

        View vUpperBodyBar = findViewById(R.id.vUpperBodyBar);
        View vCardioBar = findViewById(R.id.vCardioBar);
        View vLegsBar = findViewById(R.id.vLegsBar);
        View vGluteusBar = findViewById(R.id.vGluteusBar);

        int totalWorkouts = upperBodySets + cardioSets + legsSets + gluteusSets;
        if (tvWorkoutCount != null) tvWorkoutCount.setText(String.valueOf(totalWorkouts));

        if (tvUpperBodyReps != null) tvUpperBodyReps.setText(upperBodySets + " sets");
        if (tvCardioReps != null) tvCardioReps.setText(cardioSets + " sets");
        if (tvLegsReps != null) tvLegsReps.setText(legsSets + " sets");
        if (tvGluteusReps != null) tvGluteusReps.setText(gluteusSets + " sets");

        setBarHeight(vUpperBodyBar, upperBodySets);
        setBarHeight(vCardioBar, cardioSets);
        setBarHeight(vLegsBar, legsSets);
        setBarHeight(vGluteusBar, gluteusSets);
    }

    private void setBarHeight(View bar, int sets) {
        if (bar != null) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) bar.getLayoutParams();
            float weight = Math.min(100f, sets * 4f);
            if (sets == 0) weight = 0f;
            params.weight = weight;
            bar.setLayoutParams(params);
        }
    }
}