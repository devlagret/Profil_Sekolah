package com.prototype.profilsekolah;

import android.annotation.SuppressLint;
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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[], data2[];
    int images[];
    Context context;
    public MyAdapter(Context ct, String namaesk[], String deskripsi[], int img[]){
        context = ct;
        data1 = namaesk;
        data2 = deskripsi;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.crd_view_eskul, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.text1.setText(data1[position]);
    holder.text2.setText(data2[position]);
    holder.myimg.setImageResource(images[position]);

    holder.detailLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("data1", data1[holder.getAdapterPosition()]);
            intent.putExtra("data2", data2[holder.getAdapterPosition()]);
            intent.putExtra("image", images[holder.getAdapterPosition()]);
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text1, text2;
        ImageView myimg;
        ConstraintLayout detailLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.namaeskul);
            text2 = itemView.findViewById(R.id.deskripsieskul);
            myimg = itemView.findViewById(R.id.iVeskul);
            detailLayout = itemView.findViewById(R.id.mainrow);
        }
    }
}
