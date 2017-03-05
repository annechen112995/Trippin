package com.westwood.trippin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrippinActivity extends AppCompatActivity {

    ListView lvItem;
    ListAdapter lvItemAdapter;
    String[] trips = {"Las Vegas", "San Francisco", "San Diego", "Mammoth", "Big Bear", "Davis",
            "Seattle", "Chicago", "New York", "Mexico City", "Santa Barbara"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trippin);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://trippintsp.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final RequestService service = retrofit.create(RequestService.class);

        Call<List<Request>> createCall = service.all();
        createCall.enqueue(new Callback<List<Request>>() {
            @Override
            public void onResponse(Call<List<Request>> call, Response<List<Request>> response) {
                //for (Request req : response.body()) {
                //    trips = append(trips, req.location.toString() + "\n");
                //}
            }

            @Override
            public void onFailure(Call<List<Request>> call, Throwable t) {
                //Toast.makeText(TrippinActivity.this, trips, Toast.LENGTH_LONG).show();
            }
        });

        lvItemAdapter = new customTrippinAdapter(this, trips);
        lvItem = (ListView) findViewById(R.id.lvTrips);

        lvItem.setAdapter(lvItemAdapter);

        lvItem.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String trip = String.valueOf(parent.getItemIdAtPosition(position));
                        //Toast.makeText(TrippinActivity.this, trip, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(TrippinActivity.this, TripsActivity.class);
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

    static <T> T[] append(T[] arr, T element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
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
