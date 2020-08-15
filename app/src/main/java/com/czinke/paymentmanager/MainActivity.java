package com.czinke.paymentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.czinke.paymentmanager.models.Item;
import com.czinke.paymentmanager.recycler_view_manager.OnItemClick;
import com.czinke.paymentmanager.recycler_view_manager.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    RecyclerView recyclerView;
    RecyclerAdapter menuAdapter;
    FloatingActionButton btnAdd;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GenerateRecyclerView();
        InitializeFloatingButton();
    }
    public void GenerateRecyclerView()
    {
        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuAdapter = new RecyclerAdapter(this,getMyList(),this);
        recyclerView.setAdapter(menuAdapter);
    }
    public ArrayList<Item> getMyList()
    {
        ArrayList<Item> items = new ArrayList<>();

        Item i = new Item();
        i.setPriority(R.drawable.test1x1);
        i.setIcon(R.drawable.test1x1);
        i.setName("Item");
        i.setMoney(75000);
        items.add(i);

        i = new Item();
        i.setPriority(R.drawable.test1x1);
        i.setIcon(R.drawable.test1x1);
        i.setName("Item 2");
        i.setMoney(2100);
        items.add(i);

        return items;
    }

    @Override
    public void ItemClickListener(int position) {
        Toast.makeText(this,"click-click",Toast.LENGTH_SHORT).show();
    }
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
}