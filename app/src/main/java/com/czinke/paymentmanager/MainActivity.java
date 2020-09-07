package com.czinke.paymentmanager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import com.czinke.paymentmanager.database.AppDatabase;
import com.czinke.paymentmanager.fragments.AddFragment;
import com.czinke.paymentmanager.fragments.ListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity{

    public static FragmentManager fragmentManager;
    public static AppDatabase appDatabase;
    private static final String TAG = "MainActivity";
    public static FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,
                "itemDB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();


        if(findViewById(R.id.fragmentContainer) != null)
        {
            if(savedInstanceState != null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragmentContainer,new ListFragment(),"Home").commit();
        }
        floatingActionButton = this.findViewById(R.id.fabAddItem);
        ListFragment homeFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag("Home");
        if(homeFragment != null && homeFragment.isVisible())
            floatingActionButton.setVisibility(View.VISIBLE);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click click");
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                        new AddFragment()).addToBackStack(null).commit();

            }
        });
    }
}