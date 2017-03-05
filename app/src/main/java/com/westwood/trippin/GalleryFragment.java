package com.westwood.trippin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.GridView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;



public class GalleryFragment extends Fragment {
    ImageAdapter myImageAdapter;
    Object image;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle SavedInstanceState ) {
        View rootview = inflater.inflate(R.layout.fragment_gallery, container, false);
        final GridView gridView = (GridView) rootview.findViewById(R.id.gridView);
        myImageAdapter = new ImageAdapter(getContext());
        gridView.setAdapter(myImageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //image = myImageAdapter.getItem(i);
                FullPhotoDialogFragment fullPhotoDialogFragment = FullPhotoDialogFragment.newInstance(i, myImageAdapter.getImages());
                fullPhotoDialogFragment.show(getActivity().getSupportFragmentManager(), "fragment_full_photo");
            }
        });

        return rootview;
    }


}
