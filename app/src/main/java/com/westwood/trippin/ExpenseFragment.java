package com.westwood.trippin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


public class ExpenseFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private CustomExpensesAdapter adapter;
    ListView lvExp;
    private ArrayList<ExpensesCost> results;

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
        lvExp = (ListView) view.findViewById(R.id.lvExp);

        ArrayList<ExpensesCost> expenseslist = GetExpensesCost();

        adapter = new CustomExpensesAdapter(getActivity(), expenseslist);
        final ListView lv = (ListView) view.findViewById(R.id.lvExp);
        lv.setAdapter(adapter);

        lvExp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //results.remove();
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        lvExp.setLongClickable(true);

        lvExp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                results.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        Button b = (Button) view.findViewById(R.id.addButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(),Pop.class),999);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 999 && resultCode == RESULT_OK) {
            ExpensesCost sr = new ExpensesCost();
            sr.setName(data.getStringExtra("name"));
            sr.setCost(data.getStringExtra("cost"));
            adapter.addNew(sr);
            adapter.notifyDataSetChanged();
        }
    }

    private ArrayList<ExpensesCost> GetExpensesCost(){
        results = new ArrayList<>();

        ExpensesCost sr = new ExpensesCost();
        sr.setName("Gas (Los Angeles)");
        sr.setCost("24.50");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("Vons Groceries");
        sr.setCost("16.95");
        results.add(sr);

        sr = new ExpensesCost();
        sr.setName("MOMA Tickets");
        sr.setCost("90.00");
        results.add(sr);

        return results;
    }
}