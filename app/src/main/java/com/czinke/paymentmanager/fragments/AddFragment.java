package com.czinke.paymentmanager.fragments;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresPermission;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.czinke.paymentmanager.MainActivity;
import com.czinke.paymentmanager.R;
import com.czinke.paymentmanager.models.Item;

import java.lang.reflect.Array;

public class AddFragment extends Fragment implements View.OnClickListener {

    private EditText editTextItemName;
    private EditText editTextItemDes;
    private EditText editTextItemAmount;

    private Spinner spinnerCurrency;
    private Spinner spinnerPriority;

    private Button buttonAdd;

    private ConstraintLayout mainLayout;
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
        spinnerPriority = view.findViewById(R.id.spinnerPriority);
        spinnerCurrency = view.findViewById(R.id.spinnerCurrency);
        mainLayout = view.findViewById(R.id.fragment_addMain);
        buttonAdd.setOnClickListener(this);

        InitSpinners(getContext());
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
            String amount = editTextItemAmount.getText().toString();
            Item item = new Item();
            item.setName(name);
            item.setDes(des);
            item.setAmount(amount);
            MainActivity.appDatabase.mydao().AddItem(item);
            Toast.makeText(getActivity(),"Item added to the database",Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onClick: " + item.getName() + " " + item.getAmount());
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

    private void InitSpinners(Context context)
    {
        ArrayAdapter<CharSequence> adapterPriority = ArrayAdapter
                .createFromResource(context,R.array.priorityLevels, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterCurrency = ArrayAdapter
                .createFromResource(context,R.array.currencies,R.layout.spinner_currency);

        adapterPriority.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterCurrency.setDropDownViewResource(R.layout.spinner_dropdown);

        spinnerPriority.setAdapter(adapterPriority);
        spinnerCurrency.setAdapter(adapterCurrency);

    }
}