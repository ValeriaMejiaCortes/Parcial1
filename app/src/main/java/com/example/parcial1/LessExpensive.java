package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LessExpensive extends AppCompatActivity {

    private ArrayList<String> namesList = new ArrayList<String>();
    private ArrayList<String> tempList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_less_expensive);
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<Product> copy = new ArrayList<Product>();
        copy = (ArrayList<Product>)FakeDatabase.getProductList().clone();
        Boolean flag = true;
        while(flag){
            flag = false;
            for(int j=0;j<copy.size() - 1;j++){
               if(copy.get(j+1).getCost()<copy.get(j).getCost()){
                   flag = true;
                   Product aux = (Product)copy.get(j + 1).clone();
                   copy.set(j + 1, (Product)copy.get(j).clone());
                   copy.set(j, aux);
                }
            }
        }


        for(int k=0;k < 10;k++){
            tempList.add(copy.get(k).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tempList);
        listView.setAdapter(adapter);
    }
}