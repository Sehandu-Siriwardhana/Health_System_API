/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

/**
 *
 * @author sehandunimsath
 */

import com.example.dao.PatientDAO;
import com.example.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {
    private static final Logger logger = LoggerFactory.getLogger(PatientResource.class);

    private PatientDAO patientDAO = new PatientDAO();

    // Default constructor
    public PatientResource() {
    }

    // GET method to retrieve all patients
    @GET
    public Response getAllPatients() {
        try {
            logger.info("Fetching All Patients");
            List<Patient> patients = patientDAO.getAllPatients();
            return Response.ok(patients).build();
        } catch (Exception e) {
            logger.error("Failed to Retrieve All Patients", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Patients").build();
        }
    }

    // GET method to retrieve a patient by ID
    @GET
    @Path("/{id}")
    public Response getPatientById(@PathParam("id") int id) {
        try {
            logger.info("Retrieving Patient with ID {}", id);
            Patient patient = patientDAO.getPatientById(id);
            if (patient != null) {
                return Response.ok(patient).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Patient Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Retrieve Patient with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Patient").build();
        }
    }

    // POST method to add a new patient
    @POST
    public Response addPatient(Patient patient) {
        try {
            logger.info("Adding New Patient: {}", patient);
            patientDAO.addPatient(patient);
            return Response.status(Response.Status.CREATED).entity("Patient Created Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Add Patient", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Add Patient").build();
        }
    }

    // PUT method to update an existing patient
    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") int id, Patient updatedPatient) {
        try {
            logger.info("Updating Patient with ID {}: {}", id, updatedPatient);
            Patient existingPatient = patientDAO.getPatientById(id);
            if (existingPatient != null) {
                patientDAO.updatePatient(id, updatedPatient);
                return Response.ok("Patient Updated Successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Patient Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Update Patient with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Update Patient").build();
        }
    }

    // DELETE method to delete a patient by ID
    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") int id) {
        try {
            logger.info("Deleting Patient with ID {}", id);
            Patient existingPatient = patientDAO.getPatientById(id);
            if (existingPatient != null) {
                patientDAO.deletePatient(id);
                return Response.ok("Patient Deleted Successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Patient Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Delete Patient with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Delete Patient").build();
        }
    }
}
