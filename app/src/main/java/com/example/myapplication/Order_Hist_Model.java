package com.example.myapplication;

public class Order_Hist_Model {
    String order_Date,order_Time,order_Name,order_Price,order_Qnt;

    public Order_Hist_Model(String order_Date, String order_Time, String order_Name, String order_Qnt, String order_Price) {
        this.order_Date = order_Date;
        this.order_Time = order_Time;
        this.order_Name = order_Name;
        this.order_Qnt = order_Qnt;
        this.order_Price = order_Price;
    }
}
