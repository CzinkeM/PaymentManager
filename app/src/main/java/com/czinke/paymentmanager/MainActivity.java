package com.czinke.paymentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.czinke.paymentmanager.database.AppDatabase;
import com.czinke.paymentmanager.fragments.AddFragment;
import com.czinke.paymentmanager.fragments.HomeFragment;
import com.czinke.paymentmanager.fragments.ListFragment;
import com.czinke.paymentmanager.models.Item;
import com.czinke.paymentmanager.recycler_view_manager.OnItemClick;
import com.czinke.paymentmanager.recycler_view_manager.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
                "itemDB").allowMainThreadQueries().build();
        if(findViewById(R.id.fragmentContainer) != null)
        {
            if(savedInstanceState != null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragmentContainer,new ListFragment()).commit();
        }
        floatingActionButton = this.findViewById(R.id.fabAddItem);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click click");
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                        new AddFragment()).addToBackStack(null).commit();
                floatingActionButton.setVisibility(View.GONE);
            }
        });
    }
}