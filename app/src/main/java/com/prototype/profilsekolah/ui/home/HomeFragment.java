package com.prototype.profilsekolah.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.chrisbanes.photoview.PhotoView;
import com.prototype.profilsekolah.R;
import com.prototype.profilsekolah.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

//    ImageView banner;
    private FragmentHomeBinding binding;
    ImageView ivbanner;
    LinearLayout email, ig, telp;
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        email = root.findViewById(R.id.emaill);
        ig = root.findViewById(R.id.ig);
        telp = root.findViewById(R.id.kontak);
        PDFView pdfView = root.findViewById(R.id.pdfview);
        pdfView.fromAsset("visimisi.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();
        ivbanner = root.findViewById(R.id.banner);
        ivbanner.setOnClickListener(view -> {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(requireContext());
            View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout2, null);
            PhotoView photoView = mView.findViewById(R.id.imageValr);
            photoView.setImageResource(R.drawable.banner);
            mBuilder.setView(mView);
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
//                mDialog.getWindow().setAttributes(lp);
        });
        email.setOnClickListener(v -> {
            Intent intem =new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:sdkanisiuskedawung@gmail.com"));
            startActivity(intem);
        });
        ig.setOnClickListener(v -> {
            Intent intig =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/tk_sd_kanisius_kedawung/"));
            startActivity(intig);
        });
        telp.setOnClickListener(v -> {
            Intent inttelp =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:087880461224"));
            startActivity(inttelp);
        });
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}