package com.westwood.trippin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PackingFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private ArrayList<String> items;
    private PackingAdapter itemsAdapter;
    //private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private Button btnAddItems;
    private EditText etNewItem;

    public static PackingFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PackingFragment fragment = new PackingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // mPage = getArguments().getInt(ARG_PAGE);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_packing, container, false);

        lvItems = (ListView) view.findViewById(R.id.lvItems);
        btnAddItems = (Button) view.findViewById(R.id.btnAddItem);
        etNewItem = (EditText) view.findViewById(R.id.etNewItem);
        items = new ArrayList<>();
        itemsAdapter = new PackingAdapter(getContext(), items);
        items.add("Umbrella.....jk");
        items.add("Hot Cheetos ftw");
        items.add("Polaroid Cam");
        items.add("Water Bottle");
        items.add("Jacket");

        setupListViewListener();

        btnAddItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemText = etNewItem.getText().toString();
                items.add(itemText);
                //etNewItem.setText("");
                itemsAdapter.notifyDataSetChanged();
                etNewItem.setText("");
            }
        });

        lvItems.setAdapter(itemsAdapter);

        return view;
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }

}
