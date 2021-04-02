package com.example.lab005a;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DBHelper mDbHelper;
    SQLiteDatabase mDb;
    Button button, button2;
    EditText fruitNameEdit;
    EditText fruitColourEdit;
    EditText resultsEdit;
    String fruitName, fruitColor, results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new DBHelper(this);
        mDb = mDbHelper.getWritableDatabase();
        initView();
    }

    private void initView(){
        fruitNameEdit = findViewById(R.id.textView);
        fruitColourEdit = findViewById(R.id.textView2);
        resultsEdit = findViewById(R.id.textView3);
        fruitName = fruitNameEdit.getText().toString();
        fruitName = fruitColourEdit.getText().toString();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDb.execSQL("INSERT INTO FruitList (name, colour)"  + "VALUES" + "('" + fruitName + "','" + fruitColor + "');");
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = mDb.query("FruitList", new String[] {"_id" , "name", "colour"},
                        null, null,null,null,null);
                if(c.moveToFirst()){
                    do{
                        int id = c.getInt(0);
                        String name = c.getString(1);
                        String colour = c.getString(2);
                    }while(c.moveToNext());
                }
            }
        });
    }
}