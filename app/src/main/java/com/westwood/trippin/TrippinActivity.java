package com.westwood.trippin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TrippinActivity extends AppCompatActivity {

    ListView lvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trippin);


        String[] trips = {"Las Vegas", "San Francisco", "San Diego", "Mammoth"};
        ListAdapter lvItemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, trips);
        ListView lvItem = (ListView) findViewById(R.id.lvTrips);
        lvItem.setAdapter(lvItemAdapter);

        lvItem.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String trip = String.valueOf(parent.getItemIdAtPosition(position));
                        //Toast.makeText(TrippinActivity.this, trip, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(TrippinActivity.this, TripsActivity.class);
                        i.putExtra("origin", "Las Vegas");
                        i.putExtra("destination", "San Francisco");
                        i.putExtra("code", 400);
                        startActivity(i);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trippin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
