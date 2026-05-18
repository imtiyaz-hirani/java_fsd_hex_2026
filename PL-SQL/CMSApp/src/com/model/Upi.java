package com.model;

public class Upi implements Payment{
    @Override
    public String processPayment() {
        return "UPI payment processed";
    }
}
