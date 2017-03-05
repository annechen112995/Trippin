package com.westwood.trippin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Westwood on 3/5/17.
 */

public class PackingAdapter extends BaseAdapter{
    private static ArrayList<String> packingList;
    private LayoutInflater mInflater;

    public PackingAdapter(Context context, ArrayList<String> results) {
        packingList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return packingList.size();
    }

    public Object getItem(int position) {
        return packingList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PackingAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_packing_list, null);
            holder = new PackingAdapter.ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.expTitle);
            convertView.setTag(holder);
        } else {
            holder = (PackingAdapter.ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(packingList.get(position));

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
    }
}
