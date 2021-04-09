package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAddProduct;
    private Button btnIvaException;
    private Button btnMoreExpensive;
    private Button btnLessExpesive;
    private Button btnAverage;
    private TextView txtAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnIvaException = findViewById(R.id.btnIvaException);
        btnMoreExpensive = findViewById(R.id.btnMoreExpensive);
        btnLessExpesive = findViewById(R.id.btnLessExpesive);
        btnAverage = findViewById(R.id.btnAverage);
        txtAverage = findViewById(R.id.txtAverage);

        btnAddProduct.setOnClickListener(this);
        btnIvaException.setOnClickListener(this);
        btnMoreExpensive.setOnClickListener(this);
        btnLessExpesive.setOnClickListener(this);
        btnAverage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddProduct){
            Intent myIntent = new Intent( this, AddProduct.class);
            startActivity(myIntent);
        }
        if (v.getId() == R.id.btnIvaException){
            Intent myIntent1 = new Intent( this, WithoutIva.class);
            startActivity(myIntent1);
        }if (v.getId() == R.id.btnMoreExpensive){
            Intent myIntent = new Intent( this, MoreExpensive.class);
            startActivity(myIntent);
        }
        if (v.getId() == R.id.btnLessExpesive){
            Intent myIntent = new Intent( this, LessExpensive.class);
            startActivity(myIntent);
        }if (v.getId() == R.id.btnAverage){
            Double sumSalary = 0.0;
            for (int i = 0; i < FakeDatabase.getProductList().size(); i++) {
                sumSalary += FakeDatabase.getProductList().get(i).getCost();
            }

            txtAverage.setText("El promedio de los salarios es: " + (sumSalary/(FakeDatabase.getProductList().size())));
        }

    }
}