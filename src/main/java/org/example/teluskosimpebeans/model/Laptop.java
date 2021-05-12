package org.example.teluskosimpebeans.model;

import org.springframework.stereotype.Component;

@Component("lap1")  //object name specified to lap1, not needed if searched by type
public class Laptop {
    //---------- variables
    private int id;
    private String brand;
    //---------- constructor(s)
    public Laptop() {     System.out.println("Laptop object created");   }
    //---------- methods
    public void compile()  {      System.out.println("Laptop method compile called");    }
}
