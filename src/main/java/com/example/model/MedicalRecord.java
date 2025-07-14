/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author sehandunimsath
 */
import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    
    
    // Attributes for Medical Record
    private Patient patient;  // Reference to the patient
    private List<String> diagnoses;  // List of diagnoses
    private List<String> treatments;  // List of treatments
    private List<String> notes;  // Additional medical notes
    private int id;

    public MedicalRecord (){}
    // Constructor
    public MedicalRecord(Patient patient, int id) {
        this.patient = patient;
        this.diagnoses = new ArrayList<>();
        this.treatments = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.id = id;
    }

    // Getters and setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }
    
    public void addDiagnosis(String diagnosis) {
        diagnoses.add(diagnosis);
    }

    public List<String> getTreatments() {
        return treatments;
    }

    public void addTreatment(String treatment) {
        treatments.add(treatment);
    }

    public List<String> getNotes() {
        return notes;
    }

    public void addNote(String note) {
        notes.add(note);
    }

   

   
}
