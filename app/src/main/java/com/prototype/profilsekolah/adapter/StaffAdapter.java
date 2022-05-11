package com.prototype.profilsekolah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.github.chrisbanes.photoview.PhotoView;
import com.prototype.profilsekolah.R;
import com.squareup.picasso.Picasso;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.MyViewHolder> {
    String[] datatxt1, datatxt2;
    int[] image;
    Context con;
    public StaffAdapter(Context ct, String[] nama, String[] des, int[] img){
        con = ct;
        datatxt1 = nama;
        datatxt2 = des;
        image = img;}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(R.layout.crd_view_staff, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(datatxt1[position]);
        holder.text2.setText(datatxt2[position]);
        holder.img.setImageResource(image[position]);

        holder.detailLayout.setOnClickListener(view -> {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(con);
            LayoutInflater li = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mView = li.inflate(R.layout.dialog_custom_layout, null);
            PhotoView photoView = mView.findViewById(R.id.imageValr);
            Picasso.with(con).load(image[holder.getAdapterPosition()]).into(photoView);
            mBuilder.setView(mView);
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
//                mDialog.getWindow().setAttributes
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
            text1 = itemView.findViewById(R.id.nama);
            text2 = itemView.findViewById(R.id.deskripsi);
            img = itemView.findViewById(R.id.iVstaff);
            detailLayout = itemView.findViewById(R.id.mainrowstaff);
        }
    }}

