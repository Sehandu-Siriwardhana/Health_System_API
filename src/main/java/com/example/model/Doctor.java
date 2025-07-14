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
 * Represents a Doctor, a specialized type of Person.
 */
public class Doctor extends Person {
    private String specialization;
    private int id;

    // Default constructor
    public Doctor() {
      
    }

    // Parameterized constructor
    public Doctor(String name, String address, String contact, String specialization, int id) {
        super(name, address, contact);  // Calls the parameterized constructor of the Person class
        this.specialization = specialization;
        this.id = id;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }
    // Getter for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    
}
