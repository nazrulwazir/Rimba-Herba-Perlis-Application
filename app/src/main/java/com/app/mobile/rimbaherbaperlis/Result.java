package com.app.mobile.rimbaherbaperlis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by crystiane on 11/20/16.
 */

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Bundle extras = getIntent().getExtras();
        final int points = extras.getInt("points");

        TextView score = (TextView) findViewById(R.id.final_score);
        score.setText(String.valueOf(points));

        // Simple message to share the user's result
        TextView share = (TextView) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Result from Supernatural Quiz!");
                intent.putExtra(Intent.EXTRA_TEXT, "I got " + points + " out of 10 points in the Supernatural Quiz!");
                startActivity(intent);
            }
        });
    }
}
