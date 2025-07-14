/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

/**
 *
 * @author sehandunimsath
 */

import com.example.model.Prescription;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    // Simulated database or data storage
    private static List<Prescription> prescriptionList =  new ArrayList<>();
    
  
    // Create operation
    public void addPrescription(Prescription prescription) {
        // Here, you would typically add the prescription to your data storage
        // For now, let's just add it to the list
        prescriptionList.add(prescription);
    }
    
     public List<Prescription> getAllPrescriptions() {
        return prescriptionList;
    }

    // Read operation
    public Prescription getPrescription(int index) {
        // Retrieve the prescription by index
        for (Prescription prescription :  prescriptionList) {
            if (prescription.getId() == index) {
                return prescription;
            }
        }
        // If not found, return null
        return null;
    }

    // Update operation
    public void updatePrescription(int index, Prescription updatedPrescription) {
       for (int i = 0; i < prescriptionList.size(); i++) {
            if (prescriptionList.get(i).getId() == index) {
                // Update the patient
                prescriptionList.set(i, updatedPrescription);
                return;
            }
        }
    }

    // Delete operation
    public void deletePrescription(int id) {
        // Remove the prescription at the specified index
       for (int i = 0; i <  prescriptionList.size(); i++) {
            if ( prescriptionList.get(i).getId() == id) {
                // Remove the patient from the list
                prescriptionList.remove(i);
                return;
            }
        }
    }

    
}
