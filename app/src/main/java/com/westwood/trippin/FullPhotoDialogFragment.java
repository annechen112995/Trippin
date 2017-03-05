package com.westwood.trippin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by Westwood on 3/5/17.
 */

public class FullPhotoDialogFragment extends DialogFragment {

    private ImageView ivPhotoFrag;

    public Integer [] images = {
            R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8,
            R.drawable.img9, R.drawable.img10,
            R.drawable.img11,R.drawable.img12,
            R.drawable.img13,R.drawable.img14,
            R.drawable.img15,R.drawable.img16,
            R.drawable.img17,R.drawable.img18,
            R.drawable.img19,R.drawable.img20
    };

    public FullPhotoDialogFragment() {
    }

    public static FullPhotoDialogFragment newInstance(int i, Integer[] image) {
        FullPhotoDialogFragment frag = new FullPhotoDialogFragment();
        Bundle args = new Bundle();
        args.putInt("position", i);
        args.putSerializable("image", image);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_full_photo, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivPhotoFrag = (ImageView) view.findViewById(R.id.ivPhotoFrag);

        int position = getArguments().getInt("position");
        Integer image = getArguments().getInt("image");

        Picasso.with(getContext()).load(images[position]).fit()
                .transform(new RoundedCornersTransformation(10, 10)).into(ivPhotoFrag);

    }
}
