/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

/**
 *
 * @author sehandunimsath
 */


import com.example.model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    // Simulated database or data storage
    private static List<Doctor> doctorList = new ArrayList<>();

   
    // Create operation
    public void addDoctor(Doctor doctor) {
        // Here, you would typically add the doctor to your data storage
        // For now, let's just add it to the list
        doctorList.add(doctor);
    }
    
     public List<Doctor> getAllDoctors() {
        return  doctorList;
    }

    // Read operation - Get doctor by ID
    public Doctor getDoctorById(int id) {
        // Search for a doctor by ID
        for (Doctor doctor : doctorList) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        // If not found, return null
        return null;
    }

    // Update operation
    public void updateDoctor(int id, Doctor updatedDoctor) {
        // Search for the doctor by ID
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getId() == id) {
                // Update the doctor
                doctorList.set(i, updatedDoctor);
                return;
            }
        }
        // If not found, you may throw an exception or handle it as needed
    }

    // Delete operation
    public void deleteDoctor(int id) {
        // Search for the doctor by ID
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getId() == id) {
                // Remove the doctor from the list
                doctorList.remove(i);
                return;
            }
        }
        // If not found, you may throw an exception or handle it as needed
    }

    
}
