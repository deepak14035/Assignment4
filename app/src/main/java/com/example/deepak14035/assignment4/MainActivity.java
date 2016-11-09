package com.example.deepak14035.assignment4;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FragmentManager fm = getFragmentManager();
        FragmentTransaction fragment = fm.beginTransaction();
        if (fragment == null) {
            fragment = new CrimeListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)

                    .commit();
        }*/

    }


    public void onAddCrime(View v){
        Log.d("asd", "finally!!");
        addCrimeDialog crimeAdd = new addCrimeDialog();
        crimeAdd.show(getFragmentManager(), "ADD CRIME");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.addButton:
                addCrimeDialog crimeAdd = new addCrimeDialog();
                crimeAdd.show(getFragmentManager(), "ADD CRIME");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return false;

        }
    }
}
