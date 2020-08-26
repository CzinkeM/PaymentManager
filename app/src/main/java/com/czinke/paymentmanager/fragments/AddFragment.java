package com.czinke.paymentmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.czinke.paymentmanager.MainActivity;
import com.czinke.paymentmanager.R;
import com.czinke.paymentmanager.models.Item;

import java.util.Random;

public class AddFragment extends Fragment implements View.OnClickListener {

    private EditText textItemName;
    private Button buttonAdd;
    private static final String TAG = "AddFragment";
    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        textItemName = view.findViewById(R.id.textItemName);
        buttonAdd = view.findViewById(R.id.buttonCreateItem);
        buttonAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String name = textItemName.getText().toString();
        Item item = new Item();
        item.setName(name);

        MainActivity.appDatabase.mydao().AddItem(item);
        Toast.makeText(getActivity(),"Item added to the database",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onClick: " + MainActivity.appDatabase.mydao().GetItems());
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                new ListFragment()).addToBackStack(null).commit();
        MainActivity.floatingActionButton.setVisibility(View.VISIBLE);
        textItemName.setText("");
    }
}