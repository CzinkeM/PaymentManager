package com.czinke.paymentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.czinke.paymentmanager.models.Item;

import java.util.Date;

public class CreateItem extends AppCompatActivity {

    Spinner spinnerPriorities;
    Spinner spinnerCurrencies;
    Spinner spinnerIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        spinnerPriorities = findViewById(R.id.spinnerPriority);
        spinnerCurrencies = findViewById(R.id.spinnerCurreny);
        spinnerIcons = findViewById(R.id.spinnerIcon);
        InitializeSpinner();
    }

    private void InitializeViews() {
    }

    private void GetValues()
    {
    }
    private void CreateItem(String name, String description, int price, Date date, int priority,String currency, int icon)
    {

    }
    private void InitializeSpinner()
    {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.priorityLevels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriorities.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterIcon = ArrayAdapter.createFromResource(this,
                R.array.icons, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIcons.setAdapter(adapterIcon);

        ArrayAdapter<CharSequence> adapterCurrency = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrencies.setAdapter(adapterCurrency);
    }
}