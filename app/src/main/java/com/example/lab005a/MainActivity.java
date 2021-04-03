package com.example.lab005a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab005a.Dao.DBHelper;
import com.example.lab005a.Dao.FruitDao;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    DBHelper mDbHelper;
    SQLiteDatabase mDb;
    Button button, button2, button3, button4;
    EditText fruitNameEdit;
    EditText fruitColourEdit;
    EditText resultsEdit;
    String fruitName, fruitColor, results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate ");
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

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: update");
                fruitName = fruitNameEdit.getText().toString();
                fruitColor = fruitColourEdit.getText().toString();
                if(fruitName.length() == 0 || fruitColor.length() == 0){
                    Toast.makeText(MainActivity.this, "Name or color can not be empty!", Toast.LENGTH_SHORT).show();
                }else{
                    new FruitDao(MainActivity.this).insert(fruitName, fruitColor);
                    Toast.makeText(MainActivity.this, "Update successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: read");
                Cursor c = mDb.query("FruitList", new String[] {"_id" , "name", "colour"},
                        null, null,null,null,null);
                if(c.moveToFirst()){
                    do{
                        int id = c.getInt(0);
                        String name = c.getString(1);
                        String colour = c.getString(2);
                        results = name + colour;
                    }while(c.moveToNext());
                }
                resultsEdit.setText(results);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SCAActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RecycleActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}