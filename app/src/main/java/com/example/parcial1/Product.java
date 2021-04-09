package com.example.parcial1;

public class Product implements Cloneable{
    private String name;
    private String code;
    private Double cost;
    private Boolean iva;
    private String description;


    public Product() {
    }

    public Product(String name, String code, Double cost, Boolean iva, String description) {
        this.name = name;
        this.code = code;
        this.cost = cost;
        this.iva = iva;
        this.description = description;
    }

    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public Boolean getIva() {
        return iva;
    }

    public void setIva(Boolean iva) {
        this.iva = iva;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    @Override
    public int compareTo(Product o) {
        if (cost < o.cost) {
            return -1;
        }
        if (cost > o.cost) {
            return 1;
        }
        return 0;
    }*/
}
