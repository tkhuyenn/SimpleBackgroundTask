package com.example.simplebackgroundtask;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserDetailActivity extends AppCompatActivity {
    private TextView tvUserName;
    private TextView tvEmail;
    private TextView tvGender;
    private TextView tvStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        User user = (User) bundle.get("user_data");
        tvUserName = findViewById(R.id.txtUserName);
        tvEmail = findViewById(R.id.txtEmail);
        tvGender = findViewById(R.id.txtGender);
        tvStatus = findViewById(R.id.txtStatus);

        tvUserName.setText(user.name);
        tvEmail.setText(user.email);
        tvGender.setText(user.gender);
        tvStatus.setText(user.status);
    }
}
