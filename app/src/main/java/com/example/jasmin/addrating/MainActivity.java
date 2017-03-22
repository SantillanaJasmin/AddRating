package com.example.jasmin.addrating;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddRating = (Button) findViewById(R.id.btnAddRating);

        View.OnClickListener openDialog = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open a dialog
                DialogFragment df = new AddRatingDialog();
                df.show(getFragmentManager(), "AddRatingFrag");
            }
        };
        btnAddRating.setOnClickListener(openDialog);
    }

    public void onYesSelected(float rate, String comment) {
        int booking_id = 3;

        JSONObject rating = new JSONObject();
        try {
            rating.put("booking_id", booking_id);
            rating.put("rate", rate);
            rating.put("comment", comment);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Toast.makeText(getBaseContext(), rating.toString(), Toast.LENGTH_LONG).show();
//        new AddRatingAsyncTask().execute(String.valueOf(booking_id), String.valueOf(rate), comment);
    }
}
