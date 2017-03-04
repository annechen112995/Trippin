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

import org.w3c.dom.Text;


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

        textItem.setText(trip);
        return customView;
    }


}
