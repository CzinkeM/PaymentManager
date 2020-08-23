package com.czinke.paymentmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.czinke.paymentmanager.MainActivity;
import com.czinke.paymentmanager.R;
import com.czinke.paymentmanager.models.Item;
import com.czinke.paymentmanager.recycler_view_manager.OnItemClick;
import com.czinke.paymentmanager.recycler_view_manager.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnItemClick, View.OnClickListener {

    RecyclerView recyclerView;
    RecyclerAdapter menuAdapter;
    FloatingActionButton floatingActionButton;
    ArrayList<Item> items = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        floatingActionButton = view.findViewById(R.id.buttonAddItem);
        recyclerView = view.findViewById(R.id.recyclerViewMain);
        floatingActionButton.setOnClickListener(this);
        Item item = Item.builder()
                .name("To pay")
                .build();
        items.add(item);
        item = Item.builder()
                .name("Some internet fee")
                .build();
        items.add(item);
        item = Item.builder()
                .name("Payment")
                .build();
        items.add(item);
        GenerateRecyclerView();

        return view;
    }
    public void GenerateRecyclerView()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        menuAdapter = new RecyclerAdapter(getActivity(),items,this);
        recyclerView.setAdapter(menuAdapter);
    }
    // A recycler view elemeire vonatkozik
    @Override
    public void ItemClickListener(int position) {
        Toast.makeText(getContext(),"click",Toast.LENGTH_SHORT).show();
    }
    //a gombra vonatkozik
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonAddItem:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                        new ListFragment()).addToBackStack(null).commit();
        }
    }
}