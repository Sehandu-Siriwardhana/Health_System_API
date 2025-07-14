/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

/**
 *
 * @author sehandunimsath
 */

import com.example.dao.DoctorDAO;
import com.example.model.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {
    private static final Logger logger = LoggerFactory.getLogger(DoctorResource.class);

    private DoctorDAO doctorDAO;

    public DoctorResource() {
        this.doctorDAO = new DoctorDAO(); // Initialize the DAO
    }

    public DoctorResource(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    // GET method to retrieve all doctors
    @GET
    public Response getAllDoctors() {
        try {
            logger.info("Fetching All Doctors");
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            return Response.ok(doctors).build();
        } catch (Exception e) {
            logger.error("Failed to Retrieve All Doctors", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Doctors").build();
        }
    }

    // GET method to retrieve a doctor by ID
    @GET
    @Path("/{id}")
    public Response getDoctorById(@PathParam("id") int id) {
        try {
            logger.info("Retrieving Doctor with ID {}", id);
            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor != null) {
                return Response.ok(doctor).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Retrieve Doctor with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Doctor").build();
        }
    }

    // POST method to add a new doctor
    @POST
    public Response addDoctor(Doctor doctor) {
        try {
            logger.info("Adding New Doctor: {}", doctor);
            doctorDAO.addDoctor(doctor);
            return Response.status(Response.Status.CREATED).entity("Doctor Created Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Add Doctor", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Add Doctor").build();
        }
    }

    // PUT method to update an existing doctor
    @PUT
    @Path("/{id}")
    public Response updateDoctor(@PathParam("id") int id, Doctor updatedDoctor) {
        try {
            logger.info("Updating Doctor with ID {}: {}", id, updatedDoctor);
            Doctor existingDoctor = doctorDAO.getDoctorById(id);
            if (existingDoctor != null) {
                doctorDAO.updateDoctor(id, updatedDoctor);
                return Response.ok("Doctor Updated Successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Update Doctor with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Update Doctor").build();
        }
    }

    // DELETE method to delete a doctor by ID
    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") int id) {
        try {
            logger.info("Deleting Doctor with ID {}", id);
            Doctor existingDoctor = doctorDAO.getDoctorById(id);
            if (existingDoctor != null) {
                doctorDAO.deleteDoctor(id);
                return Response.ok("Doctor Deleted Successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Delete Doctor with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Delete Doctor").build();
        }
    }
}
