package com.prototype.profilsekolah;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
public class StartActivity extends AppCompatActivity {
private static final int timer=3000;

    View ivMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ivMenu = findViewById(R.id.iv_menu);
        new Handler().postDelayed(() -> {
            Intent i = new Intent(StartActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }, timer);

    }}
