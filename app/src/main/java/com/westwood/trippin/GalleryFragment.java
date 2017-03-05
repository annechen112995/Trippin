package com.westwood.trippin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.GridView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;



public class GalleryFragment extends Fragment {
    ImageAdapter myImageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle SavedInstanceState ) {
        View rootview = inflater.inflate(R.layout.fragment_gallery, container, false);
        GridView gridView = (GridView) rootview.findViewById(R.id.gridView);
        myImageAdapter = new ImageAdapter(getContext());
        gridView.setAdapter(myImageAdapter);


        return rootview;
    }


}
