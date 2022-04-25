package com.prototype.profilsekolah.ui.eskul;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prototype.profilsekolah.R;
import com.prototype.profilsekolah.adapter.EskulAdapter;
import com.prototype.profilsekolah.databinding.FragmentEskulBinding;

public class    EskulFragment extends Fragment {
    RecyclerView recyclerView;
    String namaesk[], deskripsi[];
    int images[]={R.drawable.osn, R.drawable.tenismeja, R.drawable.keyboard,R.drawable.menyanyi, R.drawable.menari, R.drawable.logo, R.drawable.menggambar},
        jadwal[]={R.drawable.jadwalosn, R.drawable.jadwaltenismeja, R.drawable.jadwalkeyboard, R.drawable.jadwalvokal, R.drawable.jadwaltari, R.drawable.pendampingankls6, R.drawable.jadwalmenggambar};
    private FragmentEskulBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEskulBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.eskulrycview);
        namaesk = getResources().getStringArray(R.array.nama_eskul);
        deskripsi = getResources().getStringArray(R.array.deskripsi_eskul);

        EskulAdapter eskulAdapter = new EskulAdapter((getContext()), namaesk, deskripsi, images, jadwal);
        recyclerView.setAdapter(eskulAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
        }
        @Override
        public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}