package com.app.mobile.rimbaherbaperlis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


import static com.app.mobile.rimbaherbaperlis.R.layout.question;

/**
 * Created by crystiane on 11/17/16.
 */

public class Question1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(question);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        final int points = extras.getInt("points");

        // Set the question
        TextView question = (TextView) findViewById(R.id.tv_question);
        question.setText(R.string.question1);


        // Set the options
        ArrayList<Integer> textViews = new ArrayList<>();
        textViews.add(R.id.option1);
        textViews.add(R.id.option2);
        textViews.add(R.id.option3);
        textViews.add(R.id.option4);
        textViews.add(R.id.option5);

        ArrayList<Integer> RadioButton = new ArrayList<>();
        RadioButton.add(R.string.harvard);
        RadioButton.add(R.string.stanford);
        RadioButton.add(R.string.yale);
        RadioButton.add(R.string.berkeley);
        RadioButton.add(R.string.princeton);

        for (int i = 0; i < textViews.size(); i++) {
            TextView op = (TextView) findViewById(textViews.get(i));
            op.setText(RadioButton.get(i));
            final int index = i;
            op.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (index == 1) {
                        callNext(points + 1);
                    } else {
                        callNext(points);
                    }
                }
            });


        }
    }

    public void onButtonExit(View v)
    {
        if (v.getId() == R.id.btnExit)
        {
            Intent i = new Intent(Question1.this, MainActivity.class);
            startActivity(i);
        }
    }

    /**
     * Method that calls the next question
     *
     * @param points how many points the user has until this point
     */
    private void callNext(int points) {
        Intent intent = new Intent(Question1.this, Question2.class);
        intent.putExtra("points", points);
        startActivity(intent);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
