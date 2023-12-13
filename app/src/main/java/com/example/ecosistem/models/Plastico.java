package com.example.ecosistem.models;

public class Plastico {
    private final String SERIAL;
    private int quantity,price;
    private String month,idUser;

    public Plastico(String SERIAL, int quantity,int price,String month,String idUser) {
        this.SERIAL = SERIAL;
        this.idUser = idUser;
        this.quantity = quantity;
        this.price = price;
        this.month = month;
    }

    public String getSERIAL() {
        return SERIAL;
    }

    public String getIdUser() {
        return idUser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
