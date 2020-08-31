package com.czinke.paymentmanager.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.czinke.paymentmanager.models.Item;

@Database(entities = {Item.class},version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DAO mydao();

}
