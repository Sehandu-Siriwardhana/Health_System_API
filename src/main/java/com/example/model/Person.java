/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author sehandunimsath
 */

/**
 * Represents a basic Person with common attributes.
 */
public class Person {
    // Attributes
    private String name;
    private String address;
    private String contact;
    private int id;  // New attribute for ID

    // Default constructor
    public Person() {
       
    }

    // Parameterized constructor
    public Person(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
