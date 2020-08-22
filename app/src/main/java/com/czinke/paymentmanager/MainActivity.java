package com.czinke.paymentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.czinke.paymentmanager.database.AppDatabase;
import com.czinke.paymentmanager.models.Item;
import com.czinke.paymentmanager.recycler_view_manager.OnItemClick;
import com.czinke.paymentmanager.recycler_view_manager.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    RecyclerView recyclerView;
    RecyclerAdapter menuAdapter;
    FloatingActionButton btnAdd;
    public ArrayList<Item> AllItem = new ArrayList<>();
    AppDatabase myAppDatabase;


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myAppDatabase =  Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"itemdb").build();
        setContentView(R.layout.activity_main);
        GenerateRecyclerView();
        //InitializeFloatingButton();
    }
    public void GenerateRecyclerView()
    {
        recyclerView = findViewById(R.id.recyclerViewMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuAdapter = new RecyclerAdapter(this,AllItem,this);
        recyclerView.setAdapter(menuAdapter);
    }

    @Override
    public void ItemClickListener(int position) {
        Toast.makeText(this,"click-click",Toast.LENGTH_SHORT).show();
    }
    /*
    public void InitializeFloatingButton()
    {
        btnAdd = findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),CreateItem.class);
                startActivity(intent);
            }
        });
    }

     */
}