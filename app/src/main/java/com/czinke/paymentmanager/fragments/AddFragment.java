package com.czinke.paymentmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.czinke.paymentmanager.MainActivity;
import com.czinke.paymentmanager.R;
import com.czinke.paymentmanager.models.Item;

public class AddFragment extends Fragment implements View.OnClickListener {

    private EditText textItemName;
    private EditText textItemAmount;
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
        textItemAmount = view.findViewById(R.id.textItemAmount);
        buttonAdd = view.findViewById(R.id.buttonCreateItem);
        buttonAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String name = textItemName.getText().toString();
        int amount = Integer.parseInt(textItemAmount.getText().toString());

        Item item = new Item();
        item.setId(1);
        item.setName(name);
        item.setMoney(amount);

        MainActivity.appDatabase.mydao().AddItem(item);
        Toast.makeText(getActivity(),"Item added to the database",Toast.LENGTH_SHORT).show();
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                new HomeFragment()).addToBackStack(null).commit();
        textItemName.setText("");
        textItemAmount.setText("");
    }
}