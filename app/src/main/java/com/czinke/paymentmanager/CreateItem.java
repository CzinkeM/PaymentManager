package com.czinke.paymentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import com.czinke.paymentmanager.models.Item;

import java.util.Calendar;

public class CreateItem extends AppCompatActivity {
    public Item item;
    public TextView textName;
    public TextView textDescription;
    public CalendarView calendarDate;
    public int intPrice;
    public int priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        InitializeViews();

    }
    private void InitializeViews()
    {

    }
}