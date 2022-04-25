package com.prototype.profilsekolah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

public class DetailActivityEskul extends AppCompatActivity {
    ImageView iv, ivj;
    TextView judul, deskripsi ;
    String data1, data2;
    int image, jadwal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_eskul);
        iv = findViewById(R.id.iVdetaileskul);
        judul = findViewById(R.id.namaesk);
        deskripsi = findViewById(R.id.deskripsiesk);
        ivj= findViewById(R.id.jadwal);
        getdata();
        setdata();

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DetailActivityEskul.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                PhotoView photoView = mView.findViewById(R.id.imageValr);
                photoView.setImageResource(image);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
//                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//                lp.copyFrom(mDialog.getWindow().getAttributes());
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                mDialog.show();
//                mDialog.getWindow().setAttributes(lp);
            }
        });
        ivj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DetailActivityEskul.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout2, null);
                PhotoView photoView = mView.findViewById(R.id.imageValr);
                photoView.setImageResource(jadwal);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
//                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//                lp.copyFrom(mDialog.getWindow().getAttributes());
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                mDialog.show();
//                mDialog.getWindow().setAttributes(lp);
            }
        });
    }

    private void getdata(){
        if (  getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2") && getIntent().hasExtra("image") && getIntent().hasExtra("jadwal")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            image = getIntent().getIntExtra("image", 1);
            jadwal = getIntent().getIntExtra("jadwal", 1);

        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } }
    private void setdata(){
        judul.setText(data1);
        deskripsi.setText(data2);
        iv.setImageResource(image);
        ivj.setImageResource(jadwal);
    }

}