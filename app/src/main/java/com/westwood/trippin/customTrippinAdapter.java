package com.westwood.trippin;

/**
 * Created by Jenny on 3/4/17.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


class customTrippinAdapter extends ArrayAdapter<String>{
    customTrippinAdapter(Context context, String[] trips) {
        super(context, R.layout.custom_trippin_list, trips);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater tripInflator = LayoutInflater.from(getContext());
        View customView = tripInflator.inflate(R.layout.custom_trippin_list, parent, false);

        String trip = getItem(position);
        TextView textItem = (TextView) customView.findViewById(R.id.tripView);
        ImageView imageItem = (ImageView) customView.findViewById(R.id.tripImage);

        Picasso.with(getContext()).load(R.drawable.img4).fit()
                .transform(new RoundedCornersTransformation(10, 10)).into(imageItem);

        textItem.setText(trip);
        return customView;
    }


}
