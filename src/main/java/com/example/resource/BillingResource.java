/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

/**
 *
 * @author sehandunimsath
 */

import com.example.dao.BillingDAO;
import com.example.model.Billing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/billing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {
    private static final Logger logger = LoggerFactory.getLogger(BillingResource.class);

    private BillingDAO billingDAO = new BillingDAO();

    public BillingResource() {
    }

    // GET method to retrieve all billings
    @GET
    public Response getAllBillings() {
        try {
            logger.info("Fetching All Billings");
            List<Billing> billings = billingDAO.getAllBillings();
            return Response.ok(billings).build();
        } catch (Exception e) {
            logger.error("Failed to Retrieve All Billings", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to retrieve Billings").build();
        }
    }

    // GET method to retrieve a billing by index
    @GET
    @Path("/{index}")
    public Response getBillingByIndex(@PathParam("index") int index) {
        try {
            logger.info("Retrieving Billing at ID {}", index);
            Billing billing = billingDAO.getBilling(index);
            if (billing != null) {
                return Response.ok(billing).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Billing Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Retrieve Billing at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Billing").build();
        }
    }

    // POST method to add a new billing
    @POST
    public Response addBilling(Billing billing) {
        try {
            logger.info("Adding New Billing: {}", billing);
            billingDAO.addBilling(billing);
            return Response.status(Response.Status.CREATED).entity("Billing Created Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Add Billing", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Add Billing").build();
        }
    }

    // PUT method to update an existing billing
    @PUT
    @Path("/{index}")
    public Response updateBilling(@PathParam("index") int index, Billing updatedBilling) {
        try {
            logger.info("Updating Billing at ID {}: {}", index, updatedBilling);
            billingDAO.updateBilling(index, updatedBilling);
            return Response.ok("Billing Updated Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Update Billing at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Update Billing").build();
        }
    }

    // DELETE method to delete a billing by index
    @DELETE
    @Path("/{index}")
    public Response deleteBilling(@PathParam("index") int index) {
        try {
            logger.info("Deleting Billing at ID {}", index);
            billingDAO.deleteBilling(index);
            return Response.ok("Billing Deleted Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Delete Billing at ID {}", index, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Delete Billing").build();
        }
    }
}
