package com.czinke.paymentmanager.models;

import java.util.Calendar;

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
    private Calendar calendar;
    private int priority;
    private int icon;
    private int money;
    private String currency;
}
