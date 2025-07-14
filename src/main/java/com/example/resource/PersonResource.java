/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

/**
 *
 * @author sehandunimsath
 */

import com.example.dao.PersonDAO;
import com.example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    private static final Logger logger = LoggerFactory.getLogger(PersonResource.class);

    private PersonDAO personDAO;

    public PersonResource(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    // GET method to retrieve all persons
    @GET
    public Response getAllPersons() {
        try {
            logger.info("Fetching All Persons");
            List<Person> persons = personDAO.getAllPersons();
            return Response.ok(persons).build();
        } catch (Exception e) {
            logger.error("Failed to Retrieve All Persons", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Persons").build();
        }
    }

    // GET method to retrieve a person by ID
    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") int id) {
        try {
            logger.info("Retrieving Person with ID {}", id);
            Person person = personDAO.getPersonById(id);
            if (person != null) {
                return Response.ok(person).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Person Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Retrieve Person with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Retrieve Person").build();
        }
    }

    // POST method to add a new person
    @POST
    public Response addPerson(Person person) {
        try {
            logger.info("Adding New Person: {}", person);
            personDAO.addPerson(person);
            return Response.status(Response.Status.CREATED).entity("Person Created Successfully").build();
        } catch (Exception e) {
            logger.error("Failed to Add Person", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Add Person").build();
        }
    }

    // PUT method to update an existing person
    @PUT
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") int id, Person updatedPerson) {
        try {
            logger.info("Updating Person with ID {}: {}", id, updatedPerson);
            Person existingPerson = personDAO.getPersonById(id);
            if (existingPerson != null) {
                personDAO.updatePerson(id, updatedPerson);
                return Response.ok("Person Updated Successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Person Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Update Person with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Update Person").build();
        }
    }

    // DELETE method to delete a person by ID
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
        try {
            logger.info("Deleting Person with ID {}", id);
            Person existingPerson = personDAO.getPersonById(id);
            if (existingPerson != null) {
                personDAO.deletePerson(id);
                return Response.ok("Person Deleted Successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Person Not Found").build();
            }
        } catch (Exception e) {
            logger.error("Failed to Delete Person with ID {}", id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Delete Person").build();
        }
    }
}
