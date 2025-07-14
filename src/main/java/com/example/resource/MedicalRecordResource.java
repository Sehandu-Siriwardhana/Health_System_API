/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

/**
 *
 * @author sehandunimsath
 */

import com.example.dao.MedicalRecordDAO;
import com.example.model.MedicalRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/medical-records")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalRecordResource {
    private static final Logger logger = LoggerFactory.getLogger(MedicalRecordResource.class);

    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    public MedicalRecordResource() {
    }

    // GET method to retrieve all medical records
    @GET
    public Response getAllMedicalRecords() {
        try {
            logger.info("Fetching All Medical Records");
            List<MedicalRecord> medicalRecords = medicalRecordDAO.getAllMedicalRecords();
            return Response.ok(medicalRecords).build();
        } catch (Exception e) {
            logger.error("Failed to Retrieve All Medical Records", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Medical Records").build();
        }
    }

    // GET method to retrieve a medical record by index
    @GET
    @Path("/{index}")
    public Response getMedicalRecordByIndex(@PathParam("index") int index) {
        try {
            logger.info("Retrieving Medical Record at ID {}", index);
            MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecord(index);
            if (medicalRecord != null) {
                return Response.ok(medicalRecord).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Medical Record Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Retrieve Medical Record at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Medical Record").build();
        }
    }

    // POST method to add a new medical record
    @POST
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            logger.info("Adding New Medical Record: {}", medicalRecord);
            medicalRecordDAO.addMedicalRecord(medicalRecord);
            return Response.status(Response.Status.CREATED).entity("Medical Record Created Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Add Medical Record", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Add Medical Record").build();
        }
    }

    // PUT method to update an existing medical record
    @PUT
    @Path("/{index}")
    public Response updateMedicalRecord(@PathParam("index") int index, MedicalRecord updatedMedicalRecord) {
        try {
            logger.info("Updating Medical Record at ID {}: {}", index, updatedMedicalRecord);
            medicalRecordDAO.updateMedicalRecord(index, updatedMedicalRecord);
            return Response.ok("Medical Record Updated Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Update Medical Record at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Update Medical Record").build();
        }
    }

    // DELETE method to delete a medical record by index
    @DELETE
    @Path("/{index}")
    public Response deleteMedicalRecord(@PathParam("index") int index) {
        try {
            logger.info("Deleting Medical Record at ID {}", index);
            medicalRecordDAO.deleteMedicalRecord(index);
            return Response.ok("Medical Record Deleted Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Delete Medical Record at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Delete Medical Record").build();
        }
    }
}
