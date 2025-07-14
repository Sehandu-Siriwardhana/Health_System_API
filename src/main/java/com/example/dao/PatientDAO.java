package com.example.dao;

import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    
    private static List<Patient> patientList = new ArrayList<>();
    

    // Create operation
    public void addPatient(Patient patient) {
        // Here, you would typically add the patient to your data storage
        // For now, let's just add it to the list
        patientList.add(patient);
    }
    
     public List<Patient> getAllPatients() {
        return patientList; 
    }

    // Read operation - Get patient by ID
    public Patient getPatientById(int id) {
        // Search for a patient by ID
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        // If not found, return null
        return null;
    }

    // Update operation
    public void updatePatient(int id, Patient updatedPatient) {
        // Search for the patient by ID
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getId() == id) {
                // Update the patient
                patientList.set(i, updatedPatient);
                return;
            }
        }
        // If not found, you may throw an exception or handle it as needed
    }

    // Delete operation
    public void deletePatient(int id) {
        // Search for the patient by ID
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getId() == id) {
                // Remove the patient from the list
                patientList.remove(i);
                return;
            }
        }
        // If not found, you may throw an exception or handle it as needed
    }

    
}
