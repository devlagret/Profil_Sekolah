package com.prototype.profilsekolah.ui.home;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.github.chrisbanes.photoview.PhotoView;

import com.prototype.profilsekolah.R;
import com.prototype.profilsekolah.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

//    ImageView banner;
    private FragmentHomeBinding binding;
    ImageView ivbanner;
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        ivbanner = root.findViewById(R.id.banner);

        ivbanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                PhotoView photoView = mView.findViewById(R.id.imageValr);
                photoView.setImageResource(R.drawable.banner);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
//                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//                lp.copyFrom(mDialog.getWindow().getAttributes());
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//

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