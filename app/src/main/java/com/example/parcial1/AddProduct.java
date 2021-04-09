package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.regex.Pattern;

public class AddProduct extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtCode;
    private EditText txtCost;
    private CheckBox checkBoxIva;
    private EditText txtDescription;
    private Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        btnDone = findViewById(R.id.btnDone);
        txtName = findViewById(R.id.txtName);
        txtCode = findViewById(R.id.txtCode);
        txtCost = findViewById(R.id.txtCost);
        checkBoxIva = findViewById(R.id.checkBoxIva);
        txtDescription = findViewById(R.id.txtDescription);

        btnDone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDone){
            String name = txtName.getText().toString();
            String code = txtCode.getText().toString();
            Double cost = Double.parseDouble(txtCost.getText().toString());
            Boolean iva = checkBoxIva.isChecked();
            String description = txtDescription.getText().toString();

            if (name.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error al validar el Nombre", R.layout.custom_toast).show();
                return;
            }
            if (code.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error al validar el Codigo", R.layout.custom_toast).show();
                return;
            }
            if (cost == 0) {
                CustomToastView.makeErrorToast(this, "Error al validar la Valor", R.layout.custom_toast).show();
                return;
            }
            if (description.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error, debe escribir una Descripción", R.layout.custom_toast).show();
                return;
            }

            FakeDatabase.AddProduct(name, code, cost, iva, description);
            saved(code);
            clean();
        }
    }

    private void saved(String code){
        for (int i = 0; i < FakeDatabase.getProductList().size(); i++) {
            if (FakeDatabase.getProductList().get(i).getCode().equals(code)) {
                CustomToastView.makeSuccessToast(this, "Guardado con exito", R.layout.custom_toast).show();
                return;
            }
        }
    }

    private void clean(){
        txtName.setText("");
        txtCode.setText("");
        txtCost.setText("");
        checkBoxIva.setChecked(false);
        txtDescription.setText("");
    }
}