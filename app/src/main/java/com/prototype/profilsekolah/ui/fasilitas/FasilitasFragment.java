package com.prototype.profilsekolah.ui.fasilitas;

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

import com.prototype.profilsekolah.R;
import com.prototype.profilsekolah.adapter.MyAdapter;
import com.prototype.profilsekolah.databinding.FragmentFasilitasBinding;

public class FasilitasFragment extends Fragment {
    RecyclerView recyclerView;
    String namafas[], deskripsi[];
    int images[]={R.drawable.lapbasket, R.drawable.lap_voli,R.drawable.lapbola, R.drawable.ruangkarawitan, R.drawable.ruangkomputer, R.drawable.kolamrenang};
    private FragmentFasilitasBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFasilitasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.fasilitasrycview);
        namafas= getResources().getStringArray(R.array.nama_fasilitas);
        deskripsi = getResources().getStringArray(R.array.deskripsi_fasilitas);

        MyAdapter mAdapter = new MyAdapter((getContext()), namafas, deskripsi, images);
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