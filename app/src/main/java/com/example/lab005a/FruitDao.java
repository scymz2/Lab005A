package com.example.lab005a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FruitDao {
    private final String TAG = this.getClass().getName();
    private DBHelper sqlite;
    private List<Fruit> fruitList = new ArrayList<>();

    public FruitDao(Context context){
        sqlite = new DBHelper(context);
    }

    public void insert(String fName, String fColor){
        SQLiteDatabase db =sqlite.getWritableDatabase();
        db.execSQL("INSERT INTO FruitList (name, colour)"  + "VALUES" + "('" + fName + "','" + fColor + "');");
        db.close();
    }

    public String find(String name){
        String result = "";
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor curse = db.query("FruitList",new String[] {"_id" , "name", "colour"},
                "name = ?", new String[]{name},null,null,null);
        while(curse.moveToNext()){
            result += curse.getString(curse.getColumnIndex("_id"));
            result += curse.getString(curse.getColumnIndex("name"));
            result += curse.getString(curse.getColumnIndex("colour"));
        }
        curse.close();
        db.close();
        return result;
    }

    public void update(String name, String color){
        SQLiteDatabase db = sqlite.getWritableDatabase();
        db.execSQL("UPDATE FruitList SET colour = ? WHERE name = ?", new String[]{name, color});
        db.close();
    }

    public void delete(String name){
        SQLiteDatabase db = sqlite.getWritableDatabase();
        db.execSQL("DELETE FROM FruitList WHERE name = ?", new String[]{name});
        db.close();
    }

    public List<Fruit> obtainData(){
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor curse = db.query("FruitList",new String[] {"_id" , "name", "colour"},
               null , null,null,null,null);
        while(curse.moveToNext()){
            String id = curse.getString(curse.getColumnIndex("_id"));
            String name = curse.getString(curse.getColumnIndex("name"));
            String color = curse.getString(curse.getColumnIndex("colour"));
            Log.d(TAG, "obtainData: " + "id" + id + "name" + name);
            fruitList.add(new Fruit(id, name, color));
        }
        db.close();
        return fruitList;
    }

}
