/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

/**
 *
 * @author sehandunimsath
 */


import com.example.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentDAO.class);

    private static List<Appointment> appointmentList =  new ArrayList<>();
//CREATE
    public void addAppointment(Appointment appointment) {
        try {
            appointmentList.add(appointment);
            logger.info("Appointment added successfully: {}", appointment);
        } catch (Exception e) {
            logger.error("Failed to add appointment: {}", e.getMessage());
            // Handle exception, possibly throw a custom exception or return an appropriate HTTP response
        }
    }

    public List<Appointment> getAllAppointments() {
        logger.info("Fetching all appointments");
        return appointmentList;
    }
//READ
    public Appointment getAppointment(int index) {
       for (Appointment apppointment : appointmentList) {
            if (apppointment.getId() == index) {
                return apppointment;
            }
        }
        // If not found, return null
        return null;
    }
//UPDATE
    public void updateAppointment(int index, Appointment updatedAppointment) {
        for (int i = 0; i < appointmentList .size(); i++) {
            if (appointmentList .get(i).getId() == index) {
                // Update the patient
                appointmentList .set(i, updatedAppointment);
                return;
            }
        }
    }
//DELETE
    public void deleteAppointment(int id) {
        for (int i = 0; i <appointmentList .size(); i++) {
            if (appointmentList .get(i).getId() == id) {
                // Remove the patient from the list
               appointmentList .remove(i);
                return;
            }
        }
       
    }
}
