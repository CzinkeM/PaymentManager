package com.czinke.paymentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.czinke.paymentmanager.database.AppDatabase;
import com.czinke.paymentmanager.fragments.HomeFragment;
import com.czinke.paymentmanager.models.Item;
import com.czinke.paymentmanager.recycler_view_manager.OnItemClick;
import com.czinke.paymentmanager.recycler_view_manager.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    public static FragmentManager fragmentManager;
    public static AppDatabase appDatabase;
    private static final String TAG = "MainActivity";

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
            fragmentManager.beginTransaction().add(R.id.fragmentContainer,new HomeFragment()).commit();
        }
    }
}