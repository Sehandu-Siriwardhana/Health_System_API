/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

/**
 *
 * @author sehandunimsath
 */

import com.example.dao.PrescriptionDAO;
import com.example.model.Prescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrescriptionResource {
    private static final Logger logger = LoggerFactory.getLogger(PrescriptionResource.class);

    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    public PrescriptionResource() {
      
    }

    // GET method to retrieve all prescriptions
    @GET
    public Response getAllPrescriptions() {
        try {
            logger.info("Fetching All Prescriptions");
            List<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
            return Response.ok(prescriptions).build();
        } catch (Exception e) {
            logger.error("Failed to Retrieve All Prescriptions", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Prescriptions").build();
        }
    }

    // GET method to retrieve a prescription by index
    @GET
    @Path("/{index}")
    public Response getPrescriptionByIndex(@PathParam("index") int index) {
        try {
            logger.info("Retrieving Prescription at ID {}", index);
            Prescription prescription = prescriptionDAO.getPrescription(index);
            if (prescription != null) {
                return Response.ok(prescription).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Retrieve Prescription at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Prescription").build();
        }
    }

    // POST method to add a new prescription
    @POST
    public Response addPrescription(Prescription prescription) {
        try {
            logger.info("Adding New Prescription: {}", prescription);
            prescriptionDAO.addPrescription(prescription);
            return Response.status(Response.Status.CREATED).entity("Prescription Created Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Add Prescription", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Add Prescription").build();
        }
    }

    // PUT method to update an existing prescription
    @PUT
    @Path("/{index}")
    public Response updatePrescription(@PathParam("index") int index, Prescription updatedPrescription) {
        try {
            logger.info("Updating Prescription at ID {}: {}", index, updatedPrescription);
            prescriptionDAO.updatePrescription(index, updatedPrescription);
            return Response.ok("Prescription Updated Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Update Prescription at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Update Prescription").build();
        }
    }

    // DELETE method to delete a prescription by index
    @DELETE
    @Path("/{index}")
    public Response deletePrescription(@PathParam("index") int index) {
        try {
            logger.info("Deleting Prescription at ID {}", index);
            prescriptionDAO.deletePrescription(index);
            return Response.ok("Prescription Deleted Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Delete Prescription at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Delete Prescription").build();
        }
    }
}
