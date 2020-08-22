package com.czinke.paymentmanager.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.czinke.paymentmanager.models.Item;

import java.util.List;

@Dao
public interface DAO {

    @Insert
     public void AddItem(Item item);
    @Query("select * from items")
    public List<Item> GetUsers();
    @Delete
    public void DeleteUser(Item item);
}
