package com.prototype.profilsekolah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

public class DetailActivity extends AppCompatActivity {
    ImageView iv;
    TextView judul, deskripsi ;
    String data1, data2;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iv = findViewById(R.id.iVdetail);
        judul = findViewById(R.id.judul);
        deskripsi = findViewById(R.id.deskripsi);
        getdata();
        setdata();
         }
    private void getdata(){
    if (  getIntent().hasExtra("data1") &&
    getIntent().hasExtra("data2") && getIntent().hasExtra("image")){
        data1 = getIntent().getStringExtra("data1");
        data2 = getIntent().getStringExtra("data2");
        image = getIntent().getIntExtra("image", 1);
    }else{
        Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
    } }
    private void setdata(){
    judul.setText(data1);
    deskripsi.setText(data2);
    iv.setImageResource(image);
    }
}