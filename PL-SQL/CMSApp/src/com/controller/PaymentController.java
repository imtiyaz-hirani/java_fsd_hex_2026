package com.controller;

import com.enums.PaymentType;
import com.model.Payment;
import com.util.PaymentFactory;

public class PaymentController {
    public static void main(String[] args) {
        try {
            Payment payment = PaymentFactory.getInstance(PaymentType.DEBIT);
            System.out.println(payment.processPayment());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
