package com.westwood.trippin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import android.widget.BaseAdapter;

    public class CustomExpensesAdapter extends BaseAdapter {

        private static ArrayList<ExpensesCost> expensesList;
        private LayoutInflater mInflater;

        public CustomExpensesAdapter(Context context, ArrayList<ExpensesCost> results) {
            expensesList = results;
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return expensesList.size();
        }
        public Object getItem(int position) {
            return expensesList.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.custom_expenses_list, null);
                holder = new ViewHolder();
                holder.txtName = (TextView) convertView.findViewById(R.id.expTitle);
                holder.txtCost = (TextView) convertView.findViewById(R.id.expCost);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.txtName.setText(expensesList.get(position).getName());
            holder.txtCost.setText(expensesList.get(position).getCost());

            return convertView;
        }

        static class ViewHolder {
            TextView txtName;
            TextView txtCost;
        }



        public void addNew(ExpensesCost newItem) {
            expensesList.add(newItem);
        }
    }