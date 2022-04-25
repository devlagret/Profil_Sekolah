package com.prototype.profilsekolah.ui.bangunan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.github.chrisbanes.photoview.PhotoView;
import com.prototype.profilsekolah.R;
import com.prototype.profilsekolah.databinding.FragmentBangunanBinding;


public class BangunanFragment extends Fragment {
    private FragmentBangunanBinding binding;
    ImageView denah, anggaran;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBangunanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        denah = root.findViewById(R.id.denah);
        anggaran = root.findViewById(R.id.anggaran);
        denah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout2, null);
                PhotoView photoView = mView.findViewById(R.id.imageValr);
                photoView.setImageResource(R.drawable.denah);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
//                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//                lp.copyFrom(mDialog.getWindow().getAttributes());
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                mDialog.show();
//                mDialog.getWindow().setAttributes(lp);
            }
        });
        anggaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout2, null);
                PhotoView photoView = mView.findViewById(R.id.imageValr);
                photoView.setImageResource(R.drawable.anggaran);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
//                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//                lp.copyFrom(mDialog.getWindow().getAttributes());
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                mDialog.show();
//                mDialog.getWindow().setAttributes(lp);
            }
        });
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

