/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

/**
 *
 * @author sehandunimsath
 */

import com.example.model.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {
    // Simulated database or data storage
    private static List<MedicalRecord> medicalRecordList =  new ArrayList<>();    
   

    // Create operation
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        // Here, you would typically add the medical record to your data storage
        // For now, let's just add it to the list
        medicalRecordList.add(medicalRecord);
    }
    
     public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordList;
    }

    // Read operation
    public MedicalRecord getMedicalRecord(int index) {
         // Search for a doctor by ID
        for (MedicalRecord medicalRecord : medicalRecordList ) {
            if ( medicalRecord .getId() == index) {
                return  medicalRecord ;
            }
        }
        // If not found, return null
        return null;
    }

    // Update operation
    public void updateMedicalRecord(int index, MedicalRecord updatedMedicalRecord) {
        // Update the medical record at the specified index
         for (int i = 0; i < medicalRecordList .size(); i++) {
            if (medicalRecordList .get(i).getId() == index) {
                // Update the patient
               medicalRecordList .set(i,updatedMedicalRecord );
                return;
            }
        }
    }

    // Delete operation
    public void deleteMedicalRecord(int id) {
        // Remove the medical record at the specified index
       for (int i = 0; i <medicalRecordList .size(); i++) {
            if (medicalRecordList .get(i).getId() == id) {
                // Remove the patient from the list
              medicalRecordList.remove(i);
                return;
            }
        }
    }

    
}
