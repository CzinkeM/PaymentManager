package com.czinke.paymentmanager.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity(tableName = "items")
public class Item implements Serializable {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "item_name")
    private String name;
    @ColumnInfo(name = "item_des")
    private String description;
    @ColumnInfo(name = "item_date")
    private String date;
    @ColumnInfo(name = "item_priority")
    private int priority;
    @ColumnInfo(name = "item_icon")
    private int icon;
    @ColumnInfo(name = "item_price")
    private int money;
    @ColumnInfo(name = "item_currency")
    private String currency;
}
