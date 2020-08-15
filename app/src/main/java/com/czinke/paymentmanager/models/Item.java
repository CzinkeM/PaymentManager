package com.czinke.paymentmanager.models;

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
public class Item {
    private String name;
    private String description;
    private Date date;
    private int priority;
    private int icon;
    private int money;
    private String currency;
}
