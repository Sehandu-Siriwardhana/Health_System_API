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

public class Billing {
    
    public Billing(){}
    // Attributes for the Billing class
    private Patient patient;  // Reference to the patient for whom the billing is done
    private List<Invoice> invoices;  // List of invoices
    private int id;

    // Constructor
    public Billing(Patient patient, int id) {
        this.patient = patient;
        this.invoices = new ArrayList<>();
        this.id = id;
    }

    // Getters and setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
       public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    // Method to add an invoice to the list
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    // Method to calculate total outstanding balance
    public double getTotalOutstandingBalance() {
        return invoices.stream()
                .mapToDouble(Invoice::getOutstandingAmount)
                .sum();
    }

    // Override toString to display billing details
    @Override
    public String toString() {
        return "Billing{" +
                "patient=" + patient.getName() +
                ", totalOutstanding=" + getTotalOutstandingBalance() +
                '}';
    }

    // Nested class to handle Invoice details
    public static class Invoice {
        private double amount;
        private double paidAmount;

        // Constructor for Invoice
        public Invoice(double amount, double paidAmount) {
            this.amount = amount;
            this.paidAmount = paidAmount;
        }

        // Getters and setters
        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getPaidAmount() {
            return paidAmount;
        }

        public void setPaidAmount(double paidAmount) {
            this.paidAmount = paidAmount;
        }

        // Calculate outstanding amount
        public double getOutstandingAmount() {
            return amount - paidAmount;
        }
        
   

      
    }

  
}

