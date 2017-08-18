package com.app.mobile.rimbaherbaperlis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.support.v4.view.ViewPager;


public class MainActivity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonIntroduction(View v)
    {
        if (v.getId() == R.id.btnIntroduction)
        {
            Intent i = new Intent(MainActivity.this, introduction.class);
            startActivity(i);
            Toast.makeText(this, "INTRODUCTION", Toast.LENGTH_SHORT).show();
        }
    }

    public void onButtonLocation(View v)
    {
        if (v.getId() == R.id.btnLocation)
        {
            Intent i = new Intent(MainActivity.this, location.class);
            startActivity(i);
            Toast.makeText(this, "LOCATION", Toast.LENGTH_SHORT).show();
        }
    }

    public void onButtonTypes(View v)
    {
        if (v.getId() == R.id.btnTypes)
        {
            Intent i = new Intent(MainActivity.this, types.class);
            startActivity(i);
            Toast.makeText(this, "TYPES OF HERBS", Toast.LENGTH_SHORT).show();
        }
    }

    public void onButtonGames(View v)
    {
        if (v.getId() == R.id.btnGames)
        {

            Intent i = new Intent(MainActivity.this, travia.class);
            startActivity(i);
            Toast.makeText(this, "TRAVIA", Toast.LENGTH_SHORT).show();

        }
    }

    public void onButtonGallery(View v)
    {
        if (v.getId() == R.id.btnGallery)
        {
            Intent i = new Intent(MainActivity.this, gallery.class);
            startActivity(i);
            Toast.makeText(this, "Galeri", Toast.LENGTH_SHORT).show();


        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }

}