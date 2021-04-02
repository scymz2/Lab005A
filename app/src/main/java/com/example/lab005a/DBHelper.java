package com.example.lab005a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS FruitList (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(128), colour VARCHAR(128));";

    public DBHelper(@Nullable Context context) {
        super(context, context.getString(R.string.app_db_name), null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
