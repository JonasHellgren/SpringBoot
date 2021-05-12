package org.example.teluskosimpebeans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component  //make the class available as bean in spring container
//@Scope(value="prototype")   //this will apply prototype patter, object created when requested,
                            // not present <=> singleton pattern, one created at start anyway, now new created
public class Alien {
    //---------- variables
    private int id;
    private String name;
    @Autowired  //will make object search for laptop in spring container, search by type is default
    @Qualifier("lap1")  //search by name instead of
    private Laptop laptop;
    //---------- constructor(s)
    public Alien() {     System.out.println("Alien object created");   }
    //---------- methods
    public void show()  { System.out.println("Alien method show called");     laptop.compile();   }
}
