package com.czinke.paymentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.czinke.paymentmanager.models.Item;

public class CreateItem extends AppCompatActivity {
    public Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);

    }
}