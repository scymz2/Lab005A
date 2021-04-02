package com.example.lab005a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class SCAActivity extends AppCompatActivity {

    private ListView mListView;
    private List<Fruit> list = null;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_c_a);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SCAActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        mListView = findViewById(R.id.listView);
        list = new FruitDao(SCAActivity.this).obtainData();
        initData();
    }

    private void initData(){
        mListView.setAdapter(new ListAdapter(list));
        mListView.deferNotifyDataSetChanged();
    }
}