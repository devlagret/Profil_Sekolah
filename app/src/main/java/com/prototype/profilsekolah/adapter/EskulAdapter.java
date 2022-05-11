package com.prototype.profilsekolah.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.prototype.profilsekolah.DetailActivityEskul;
import com.prototype.profilsekolah.R;

public class EskulAdapter extends RecyclerView.Adapter<EskulAdapter.MyViewHolder>{

    String[] data1, data2;
    int[] image, jdw;
    Context con;
    public EskulAdapter(Context ct, String[] judul, String[] des, int[] img, int[] jadwal){
        con = ct;
        data1 = judul;
        data2 = des;
        image = img;
        jdw = jadwal;}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(R.layout.crd_view_eskul, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(data1[position]);
//        holder.text2.setText(data2[position]);
        holder.img.setImageResource(image[position]);

        holder.detailLayout.setOnClickListener(view -> {
            Intent intent = new Intent(con, DetailActivityEskul.class);
            intent.putExtra("data1", data1[holder.getAdapterPosition()]);
            intent.putExtra("data2", data2[holder.getAdapterPosition()]);
            intent.putExtra("image", image[holder.getAdapterPosition()]);
            intent.putExtra("jadwal", jdw[holder.getAdapterPosition()]);
            con.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2;
        ImageView img;
        ConstraintLayout detailLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.namaeskul);
            text2 = itemView.findViewById(R.id.deskripsieskul);
            img = itemView.findViewById(R.id.iVeskul);
            detailLayout = itemView.findViewById(R.id.mainrow);
    }
}}
