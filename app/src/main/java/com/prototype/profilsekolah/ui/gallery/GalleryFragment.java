package com.prototype.profilsekolah.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.chrisbanes.photoview.PhotoView;
import com.prototype.profilsekolah.DetailActivity;
import com.prototype.profilsekolah.R;
import com.prototype.profilsekolah.adapter.MyAdapter;
import com.prototype.profilsekolah.databinding.FragmentFasilitasBinding;
import com.prototype.profilsekolah.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    RecyclerView recyclerView;
    String judul[], deskripsi[];
    int images[]={R.drawable.kelas, R.drawable.flsn, R.drawable.pestasiaga, R.drawable.lcc2, R.drawable.macapat};

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.galleryrycview);
        judul = getResources().getStringArray(R.array.jdl_galery);
        deskripsi = getResources().getStringArray(R.array.deskripsi_galery);

        MyAdapter mAdapter = new MyAdapter((getContext()), judul, deskripsi, images);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}