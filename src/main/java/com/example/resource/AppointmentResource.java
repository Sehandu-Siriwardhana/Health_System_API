package com.example.resource;

import com.example.dao.AppointmentDAO;
import com.example.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentResource.class);

    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    public AppointmentResource() {
    }

    // GET method to retrieve all appointments
    @GET
    public Response getAllAppointments() {
        try {
            logger.info("Fetching All Appointments");
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            return Response.ok(appointments).build();
        } catch (Exception e) {
            logger.error("Failed to Retrieve All Appointments", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Retrieve Appointments").build();
        }
    }

    // GET method to retrieve an appointment by index
    @GET
    @Path("/{index}")
    public Response getAppointmentByIndex(@PathParam("index") int index) {
        try {
            logger.info("Retrieving Appointment at ID {}", index);
            Appointment appointment = appointmentDAO.getAppointment(index);
            if (appointment != null) {
                return Response.ok(appointment).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Retrieve Appointment at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Retrieve Appointment").build();
        }
    }

    // POST method to add a new appointment
    @POST
    public Response addAppointment(Appointment appointment) {
        try {
            logger.info("Adding New Appointment: {}", appointment);
            appointmentDAO.addAppointment(appointment);
            return Response.status(Response.Status.CREATED).entity("Appointment Created Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Add Appointment", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Add Appointment").build();
        }
    }

    // PUT method to update an existing appointment
    @PUT
    @Path("/{index}")
    public Response updateAppointment(@PathParam("index") int index, Appointment updatedAppointment) {
        try {
            logger.info("Updating Appointment at ID {}: {}", index, updatedAppointment);
            appointmentDAO.updateAppointment(index, updatedAppointment);
            return Response.ok("Appointment Updated Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Update Appointment at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Update Appointment").build();
        }
    }

    // DELETE method to delete an appointment by index
    @DELETE
    @Path("/{index}")
    public Response deleteAppointment(@PathParam("index") int index) {
        try {
            logger.info("Deleting Appointment at ID {}", index);
            appointmentDAO.deleteAppointment(index);
            return Response.ok("Appointment Deleted Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Delete Appointment at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Delete Appointment").build();
        }
    }
}
