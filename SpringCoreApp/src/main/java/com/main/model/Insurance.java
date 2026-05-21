package com.main.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;

@Component
public class Insurance {
    // @Autowired
    private CarInsurance carInsurance;
    private BikeInsurance bikeInsurance;

    @Autowired
    public void setCarInsurance(CarInsurance carInsurance) {
        this.carInsurance = carInsurance;
    }

    @Autowired
    public void setBikeInsurance(BikeInsurance bikeInsurance) {
        this.bikeInsurance = bikeInsurance;
    }

    public void details(){
        System.out.println("Insurance details ");
        carInsurance.details();
        bikeInsurance.details();
    }
}

/*
Car Insurance
Bike Insurance
 */