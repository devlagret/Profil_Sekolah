package com.prototype.profilsekolah.ui.eskul;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prototype.profilsekolah.MyAdapter;
import com.prototype.profilsekolah.R;
import com.prototype.profilsekolah.databinding.FragmentEskulBinding;
import com.prototype.profilsekolah.databinding.FragmentFasilitasBinding;

public class    EskulFragment extends Fragment {
    RecyclerView recyclerView;
String namaesk[], deskripsi[];
int images[]={R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo};
    private FragmentEskulBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEskulBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
            recyclerView = root.findViewById(R.id.eskulrycview);
        namaesk = getResources().getStringArray(R.array.nama_eskul);
        deskripsi = getResources().getStringArray(R.array.deskripsi_eskul);

        MyAdapter myAdapter = new MyAdapter((getContext()), namaesk, deskripsi, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            return root;
        }
        @Override
        public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}