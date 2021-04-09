package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MoreExpensive extends AppCompatActivity {
    private ArrayList<String> nameList = new ArrayList<String>();

    private void imprimeArrayPersonas(ArrayList<Product> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println((i+1) + ". " + array.get(i).getName() + " - Costo: " + array.get(i).getCost());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_expensive);
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<Product> copy = new ArrayList<Product>();
        copy = (ArrayList<Product>) FakeDatabase.getProductList().clone();
        Boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < copy.size() - 1; j++) {
                if (copy.get(j).getCost() < copy.get(j + 1).getCost()) {
                    flag = true;
                    Product aux = (Product) copy.get(j).clone();
                    copy.set(j, (Product) copy.get(j + 1).clone());
                    copy.set(j + 1, aux);
                }
            }
        }
        for (int k = 0; k < 10; k++) {
            nameList.add(copy.get(k).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(adapter);

    }
}