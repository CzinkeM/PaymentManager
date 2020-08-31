package com.czinke.paymentmanager.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;

import com.czinke.paymentmanager.MainActivity;
import com.czinke.paymentmanager.R;
import com.czinke.paymentmanager.models.Item;

public class AddFragment extends Fragment implements View.OnClickListener {

    private EditText editTextItemName;
    private EditText editTextItemDes;
    private EditText editTextItemAmount;

    private Button buttonAdd;
    private static final String TAG = "AddFragment";
    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        editTextItemName = view.findViewById(R.id.textItemName);
        editTextItemDes = view.findViewById(R.id.textItemDes);
        editTextItemAmount = view.findViewById(R.id.textItemNumber);
        buttonAdd = view.findViewById(R.id.buttonCreateItem);
        buttonAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(editTextItemName.getText().toString().matches(""))
        {
            WriteOutError(getResources().getString(R.string.errorNameMissing));
        }else if(editTextItemDes.getText().toString().matches(""))
        {
            WriteOutError(getResources().getString(R.string.errorDesMissing));
        }else if(editTextItemAmount.getText().toString().matches(""))
        {
            WriteOutError(getResources().getString(R.string.errorAmountMissing));
        }
        else{
            String name = editTextItemName.getText().toString();
            String des = editTextItemDes.getText().toString();
            int amount = Integer.parseInt(editTextItemAmount.getText().toString());
            Item item = new Item();
            item.setName(name);
            item.setDes(des);
            item.setAmount(amount);
            MainActivity.appDatabase.mydao().AddItem(item);
            Toast.makeText(getActivity(),"Item added to the database",Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onClick: " + item.getName());
            Log.d(TAG, "onClick: " + MainActivity.appDatabase.mydao().GetItems());
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                    new ListFragment()).addToBackStack(null).commit();
            editTextItemName.setText("");
            editTextItemDes.setText("");
            editTextItemAmount.setText("");
        }
    }
    public void WriteOutError(String string)
    {
        Toast.makeText(getContext(),string,Toast.LENGTH_SHORT).show();
    }
}