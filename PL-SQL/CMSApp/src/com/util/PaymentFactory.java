package com.util;

import com.enums.PaymentType;
import com.model.DebitCard;
import com.model.Neft;
import com.model.Payment;
import com.model.Upi;

public class PaymentFactory {

    public static Payment getInstance(PaymentType paymentType) {
        if(paymentType == null)
            throw new RuntimeException("No payment selected");

        if(paymentType.equals(PaymentType.NEFT))
            return new Neft();
        if(paymentType.equals(PaymentType.DEBIT))
            return new DebitCard();
        if(paymentType.equals(PaymentType.UPI))
            return new Upi();

        return new Neft();
    }
}
