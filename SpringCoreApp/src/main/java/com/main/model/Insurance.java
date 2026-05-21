package com.main.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;

@Component
public class Insurance {

    private CarInsurance carInsurance;
    private BikeInsurance bikeInsurance;

    public Insurance(CarInsurance carInsurance, BikeInsurance bikeInsurance) {
        this.carInsurance = carInsurance;
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