package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class WithoutIva extends AppCompatActivity {

    private ArrayList<String> namesList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_iva);
        ListView listView = (ListView) findViewById(R.id.listView);

        for (int i = 0; i < FakeDatabase.getProductList().size(); i++){
            if (FakeDatabase.getProductList().get(i).getIva() == true){
                namesList.add((FakeDatabase.getProductList().get(i).getName()));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, namesList);
        listView.setAdapter(adapter);
    }
}