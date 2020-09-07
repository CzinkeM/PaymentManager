package com.czinke.paymentmanager.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(tableName = "items")
public class Item implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "item_name")
    private String name;
    @ColumnInfo(name="item_des")
    private String des;
    @ColumnInfo(name ="item_amount")
    private String amount;
    @ColumnInfo(name = "item_img")
    private int icon;
    @ColumnInfo(name = "item_priority")
    private int priority;
}
