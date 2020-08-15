package com.czinke.paymentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.czinke.paymentmanager.models.Item;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateItem extends AppCompatActivity{

    EditText textName;
    EditText textDescription;
    EditText textAmount;
    EditText textDate;

    SwitchCompat itemRegularlyPayable;

    Spinner spinnerPriorities;
    Spinner spinnerCurrencies;
    Spinner spinnerIcons;

    ProgressBar progressBarFillComplete;

    Button btnCreateItem;

    String itemName;
    String itemDescription;
    String itemAmount;
    String itemDate;

    final Calendar myCalendar = Calendar.getInstance();
    int myYear = myCalendar.get(Calendar.YEAR);
    int myMonth = myCalendar.get(Calendar.MONTH);
    int myDay = myCalendar.get(Calendar.DAY_OF_MONTH);
    DatePickerDialog.OnDateSetListener datePickerDialog;

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        InitializeViews();
        InitializeSpinner();
        GetDate();
        GetValues();

    }


    private void InitializeViews() {
        textName = (EditText) findViewById(R.id.editTextItemName);
        textDescription = (EditText) findViewById(R.id.editTextItemDescription);
        textAmount = (EditText) findViewById(R.id.editTextAmountOfMoney);
        textDate = (EditText) findViewById(R.id.editTextDate);

        itemRegularlyPayable = findViewById(R.id.switchRegularly);
        progressBarFillComplete = findViewById(R.id.progressBar);
        btnCreateItem = findViewById(R.id.buttonCreateItem);
        spinnerPriorities = findViewById(R.id.spinnerPriority);
        spinnerCurrencies = findViewById(R.id.spinnerCurreny);
        spinnerIcons = findViewById(R.id.spinnerIcon);
    }


    private void GetValues()
    {
        itemName =(String) textName.getText().toString();
        itemDescription = (String) textDescription.getText().toString();
        itemAmount = (String) textAmount.getText().toString();

        itemDate =(String) textDate.getText().toString();
        btnCreateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item item = new Item();
                item.setName(itemName);
                item.setDescription(itemDescription);
                item.setDate(itemDate);
                item.setCurrency(spinnerCurrencies.getSelectedItem().toString());
                item.setPriority(Integer.parseInt(spinnerPriorities.getSelectedItem().toString()));
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                //Memóriában lévő adatbázishoz kell adni és azt kell mindig eltárolni
                Bundle b = new Bundle();
                b.putSerializable("item", item);
                intent.putExtra("addedItem",b);
                startActivity(intent);
            }
        });

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
    private void GetDate()
    {
        datePickerDialog = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                textDate.setText(sdf.format(myCalendar.getTime()));
            }
        };
        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(view.getContext(),datePickerDialog,myYear,myMonth,myDay).show();
            }
        });
    }
}