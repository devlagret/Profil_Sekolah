package com.prototype.profilsekolah;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
public class StartActivity extends AppCompatActivity {
private static int timer=5000;

    View ivMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ivMenu = findViewById(R.id.iv_menu);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(StartActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },timer);
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Intent intent = new Intent(StartActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }}
