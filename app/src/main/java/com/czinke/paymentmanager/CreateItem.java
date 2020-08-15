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
    public Item item;
    public TextView textName;
    public TextView textDescription;
    public CalendarView calendarDate;
    public EditText intPrice;
    public Spinner spinnerPriority;
    public Object priority;

    public Spinner spinnerIcons;
    public Object icons;
    public Spinner spinnerCurrency;
    public Object currency;

    public String itemName;
    public String itemDescription;
    public int itemPrice;
    public Date itemDate;
    public int itemPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        InitializeViews();
        InitializeSpinner();
        GetValues();
        CreateItem(itemName,itemDescription,itemPrice,itemDate,itemPriority,"",1);
    }

    private void InitializeViews() {
        this.textName = findViewById(R.id.editTextItemName);
        this.textDescription = findViewById(R.id.editTextTextMultiLine);
        this.calendarDate = this.findViewById(R.id.editTextDate);
        this.intPrice = findViewById(R.id.editTextPrice);
        this.spinnerPriority = findViewById(R.id.spinnerPriority);
        this.priority = spinnerPriority.getSelectedItem();
        this.spinnerIcons = findViewById(R.id.spinnerIcon);
        this.icons = spinnerIcons.getSelectedItem();
        this.spinnerCurrency = findViewById(R.id.spinnerCurreny);
        this.currency = spinnerCurrency.getSelectedItem();
    }

    private void GetValues()
    {
        itemName = textName.getText().toString();
        itemDescription = textDescription.getText().toString();
        itemPrice = Integer.parseInt(intPrice.getText().toString());
        itemDate = new Date(calendarDate.getDate());
        itemPriority = Integer.valueOf((String) priority);
    }
    private void CreateItem(String name, String description, int price, Date date, int priority,String currency, int icon)
    {
        item.setName(name);
        item.setDescription(description);
        item.setMoney(price);
        item.setDate(date);
        item.setPriority(priority);
        item.setCurrency(currency);
        item.setIcon(icon);
    }
    private void InitializeSpinner()
    {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.priorityLevels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterIcon = ArrayAdapter.createFromResource(this,
                R.array.icons, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIcons.setAdapter(adapterIcon);

        ArrayAdapter<CharSequence> adapterCurrency = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency.setAdapter(adapterCurrency);
    }
}