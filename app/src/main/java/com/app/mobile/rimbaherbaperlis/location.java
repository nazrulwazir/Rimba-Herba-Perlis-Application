package com.app.mobile.rimbaherbaperlis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.MenuItem;

public class location extends AppCompatActivity
{

    public location()
    {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onMaps(View v)
    {

        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://goo.gl/maps/t3GM4nq52S22"));
        startActivity(i);

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