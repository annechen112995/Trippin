package com.westwood.trippin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class ExpenseFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static ExpenseFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ExpenseFragment fragment = new ExpenseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_expense, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        //tvTitle.setText("Fragment #" + mPage);

        ArrayList<ExpensesCost> ExpensesCost = GetExpensesCost();

        CustomExpensesAdapter adapter = new CustomExpensesAdapter(getActivity(), ExpensesCost);
        final ListView lv = (ListView) view.findViewById(R.id.lvExp);
        lv.setAdapter(adapter);

        return view;
    }


    private ArrayList<ExpensesCost> GetExpensesCost(){
        ArrayList<ExpensesCost> results = new ArrayList<ExpensesCost>();

        ExpensesCost sr = new ExpensesCost();
        sr.setName("Gas - LA");
        sr.setCost("24.50");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("McDonalds - Santa Barbara");
        sr.setCost("16.95");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("777 Motel");
        sr.setCost("90.00");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("Vons");
        sr.setCost("19.89");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("Corner Bakery");
        sr.setCost("12.52");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("Gas - Bakersfield");
        sr.setCost("20.00");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("7-11");
        sr.setCost("10.02");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("Cruise");
        sr.setCost("70.92");
        results.add(sr);

        return results;
    }
}