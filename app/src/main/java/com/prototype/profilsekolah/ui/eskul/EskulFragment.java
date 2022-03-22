package com.prototype.profilsekolah.ui.eskul;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.prototype.profilsekolah.databinding.FragmentFasilitasBinding;

public class EskulFragment extends Fragment {

    private FragmentFasilitasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFasilitasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textSlideshow;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}