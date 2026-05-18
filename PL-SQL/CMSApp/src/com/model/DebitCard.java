package com.model;

public class DebitCard implements Payment{

    @Override
    public String processPayment() {
        return "DEBIT CARD payment processed";
    }
}
