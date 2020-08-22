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
    @ColumnInfo(name = "item_price")
    private int money;
}
