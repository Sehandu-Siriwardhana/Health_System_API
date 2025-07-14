/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

/**
 *
 * @author sehandunimsath
 */

import com.example.model.Billing;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {
    // Simulated database or data storage
    private static List<Billing> billingList =  new ArrayList<>();
    
 
    // Create operation
    public void addBilling(Billing billing) {
        // Here, you would typically add the billing to your data storage
        // For now, let's just add it to the list
        billingList.add(billing);
    }
    
      public List<Billing> getAllBillings() {
        return billingList;
    }

    // Read operation
    public Billing getBilling(int index) {
        for ( Billing billing :  billingList) {
            if (billing.getId() == index) {
                return billing;
            }
        }
        // If not found, return null
        return null;
    }

    // Update operation
    public void updateBilling(int index, Billing updatedBilling) {
        // Update the billing at the specified index
       for (int i = 0; i < billingList .size(); i++) {
            if ( billingList .get(i).getId() == index) {
                // Update the patient
               billingList .set(i,updatedBilling );
                return;
            }
        }
    }

    // Delete operation
    public void deleteBilling(int index) {
        // Remove the billing at the specified index
      billingList.removeIf(d -> d.getId()==index);
    }

    
}
