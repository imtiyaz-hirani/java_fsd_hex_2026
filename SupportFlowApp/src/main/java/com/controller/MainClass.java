package com.controller;

import com.config.HibernateConfig;

public class MainClass {
    public static void main(String[] args) {
        HibernateConfig.getSessionFactory();
        System.out.println("Works");

    }
}
