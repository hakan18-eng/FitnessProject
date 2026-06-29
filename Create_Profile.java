package com.example.fitness;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.card.MaterialCardView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Create_Profile extends AppCompatActivity {

    private ActivityResultLauncher<String> pickImageLauncher;
    private ImageView ivSetupProfilePicture;
    private String selectedImagePath = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etProfileName = findViewById(R.id.etProfileName);
        EditText etProfileAge = findViewById(R.id.etProfileAge);
        MaterialCardView cvProfileSetupImage = findViewById(R.id.cvProfileSetupImage);
        ivSetupProfilePicture = findViewById(R.id.ivSetupProfilePicture);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnBack = findViewById(R.id.btnBack);

        SharedPreferences prefs = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE);
        String currentEmail = prefs.getString("current_logged_email", "");

        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        selectedImagePath = saveImageToInternalStorage(uri, currentEmail);
                        if (selectedImagePath != null) {
                            ivSetupProfilePicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            ivSetupProfilePicture.setImageURI(Uri.parse(selectedImagePath));
                        }
                    }
                }
        );

        if (cvProfileSetupImage != null) {
            cvProfileSetupImage.setOnClickListener(v -> pickImageLauncher.launch("image/*"));
        }

        btnBack.setOnClickListener(v -> finish());

        btnNext.setOnClickListener(v -> {
            String name = etProfileName.getText().toString().trim();
            String age = etProfileAge.getText().toString().trim();

            if (name.isEmpty() || age.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("name_" + currentEmail, name);
            editor.putString("age_" + currentEmail, age);

            if (selectedImagePath != null) {
                editor.putString("profile_pic_" + currentEmail, selectedImagePath);
            }

            editor.apply();

            Toast.makeText(this, "Profile created!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Create_Profile.this, MainActivity.class));
            finish();
        });
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
}