package com.prototype.profilsekolah.ui.staff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prototype.profilsekolah.R;
import com.prototype.profilsekolah.adapter.StaffAdapter;
import com.prototype.profilsekolah.databinding.FragmentStaffBinding;

public class StaffFragment extends Fragment {
    RecyclerView recyclerView;
    String[] judul, deskripsi;
    int[] images ={R.drawable.bpdrsfxsubarno, R.drawable.bpyohanesnovaavianto, R.drawable.bralbinus,
            R.drawable.paktrubus,R.drawable.ibubernadetatrihardiyanti,
            R.drawable.ibudwinopianti, R.drawable.ibuflorentinasatitikurniadewi, R.drawable.ibukatarinasuharti,
            R.drawable.buwahyu, R.drawable.bernadethadwia,
            R.drawable.bprayitno, R.drawable.pakpur};

    private FragmentStaffBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStaffBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.staffyrycview);
        judul = getResources().getStringArray(R.array.nama_guru);
        deskripsi = getResources().getStringArray(R.array.deskripsi_guru);

        StaffAdapter     mAdapter = new StaffAdapter((getContext()), judul, deskripsi, images);
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
