package com.westwood.trippin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jenny on 3/4/17.
 */

public class Pop extends Activity {

    private EditText cost;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (0.9 * width), (int) (0.9 * height));

        cost = (EditText) findViewById(R.id.expCost);
        name = (EditText) findViewById(R.id.expName);

        Button b = (Button) findViewById(R.id.submitB);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("cost", cost.getText().toString());
                i.putExtra("name", name.getText().toString());
                setResult(RESULT_OK,i);
                finish();
            }
        });

    }


}
