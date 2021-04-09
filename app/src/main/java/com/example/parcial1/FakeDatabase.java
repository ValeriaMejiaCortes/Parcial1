package com.example.parcial1;

import java.util.ArrayList;
import java.util.Arrays;

public class FakeDatabase {
    private static ArrayList<Product> productList = new ArrayList<>(
            Arrays.asList(
                    new Product("Lenteja1","1234",1000.0, true,"Lenteja importada marca venuz"),
                    new Product("Banano2","5445",2000.0, false,"Banana del barrio"),
                    new Product("Uva3","3452",3000.0, true,"Uva sin semilla"),
                    new Product("Lenteja4","1234",4000.0, true,"Lenteja importada marca venuz"),
                    new Product("Banano5","5445",5000.0, false,"Banana del barrio"),
                    new Product("Uva7","3452",8000.0, true,"Uva sin semilla"),
                    new Product("Lenteja8","1234",13000.0, true,"Lenteja importada marca venuz"),
                    new Product("Banano11","5445",56000.0, false,"Banana del barrio"),
                    new Product("Salmon13","3452",98000.0, true,"Kilo de Salmón fresco"),
                    new Product("Lenteja10","1234",34000.0, true,"Lenteja importada marca venuz"),
                    new Product("Banano6","5445",7000.0, false,"Banana del barrio"),
                    new Product("Uva9","3452",32000.0, true,"Uva sin semilla"),
                    new Product("Pulpo12","1234",57000.0, true,"De rio")

            )
    );

    public static void AddProduct(String name, String code, Double cost, Boolean iva, String description){
        productList.add(new Product(name, code, cost, iva, description));
    }

    public static ArrayList<Product> getProductList() {
        return productList;
    }

    public static void setProductList(ArrayList<Product> productList) {
        FakeDatabase.productList = productList;
    }
}
