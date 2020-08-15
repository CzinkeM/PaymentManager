package com.czinke.paymentmanager.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item implements Serializable {
    private String name;
    private String description;
    private String date;
    private int priority;
    private int icon;
    private int money;
    private String currency;
}
