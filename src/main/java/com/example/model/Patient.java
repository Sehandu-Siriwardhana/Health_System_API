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
 * Represents a Patient, a specific type of Person with health-related attributes.
 */
public class Patient extends Person {
    // Attributes specific to Patient
    private String medicalHistory;
    private String currentHealthStatus;
    private int id;

    // Default constructor
    public Patient() {
       
    }

    // Parameterized constructor
    public Patient(String name, String address, String contact, String medicalHistory, String currentHealthStatus, int id) {
        super(name, address, contact);  // Calls the parameterized constructor of the Person class
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
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
    // Getter for medicalHistory
    public String getMedicalHistory() {
        return medicalHistory;
    }

    // Setter for medicalHistory
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // Getter for currentHealthStatus
    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    // Setter for currentHealthStatus
    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }

  

   
}
