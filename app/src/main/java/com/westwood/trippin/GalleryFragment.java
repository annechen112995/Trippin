package com.westwood.trippin;
//compile "com.android.support:recyclerview-v7:24.2."
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.GridView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

public class GalleryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle SavedInstanceState ) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(getContext()));
        return view;
    }


}
