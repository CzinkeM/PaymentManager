package com.czinke.paymentmanager.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.czinke.paymentmanager.models.Item;

@Database(entities = {Item.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static Migration migration_1_2 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE 'items' ADD COLUMN 'item_amount' INT DEFAULT '0'");
        }
    };


    public abstract DAO mydao();

}
