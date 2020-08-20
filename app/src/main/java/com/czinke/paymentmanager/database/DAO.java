package com.czinke.paymentmanager.database;

import androidx.room.Dao;
import androidx.room.Insert;

import com.czinke.paymentmanager.models.Item;

@Dao
public interface DAO {

    @Insert
     public void AddItem(Item item);
}
