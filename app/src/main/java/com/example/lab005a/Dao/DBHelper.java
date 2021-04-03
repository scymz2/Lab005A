package com.example.lab005a.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.lab005a.R;

public class DBHelper extends SQLiteOpenHelper {

    private final String TAG = this.getClass().getName();
    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS FruitList (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(128), colour VARCHAR(128));";

    public DBHelper(@Nullable Context context) {
        super(context, context.getString(R.string.app_db_name), null,1);
        Log.d(TAG, "DBHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: sqliteDB");
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: sqliteDB");
    }
}
