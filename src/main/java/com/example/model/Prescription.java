/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author sehandunimsath
 */
public class Prescription {
    // Attributes for the Prescription
    private String medicationName;
    private String dosage;
    private String instructions;
    private int durationDays;
    private int id;

    public  Prescription (){}
    // Constructor

  
    public Prescription(String medicationName, String dosage, String instructions, int durationDays, int id) {
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.instructions = instructions;
        this.durationDays = durationDays;
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
    // Getters and setters
    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }


  
}
