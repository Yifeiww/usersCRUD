package com.yifei.services;

import com.yifei.db.DBConnection;
import com.yifei.db.FirestoreConnection;
import com.yifei.model.User;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class usersCRUDService {
    private DBConnection dbConnection = new FirestoreConnection();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response userById(@QueryParam("id") String userId) {
        try {
            JSONObject response;
            Response.Status responseCode = Response.Status.OK;
            if (userId == null || userId.length() == 0) {
                response = dbConnection.getCollection("users");
            } else {
                response = dbConnection.getDocument("users", userId);
                if (response.has("error")) {
                    responseCode = Response.Status.BAD_REQUEST;
                }
            }
            return Response.status(responseCode).entity(response.toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(getErrorResponse().toString()).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User newUser) {
        try {
            JSONObject response = new JSONObject();
            Response.Status responseCode = Response.Status.CREATED;
            if (newUser.getFirstName() != null && newUser.getLastName() != null) {
                JSONObject userJSON = new JSONObject();
                userJSON.put("firstName", newUser.getFirstName());
                userJSON.put("lastName", newUser.getLastName());
                response = dbConnection.addDocument("users", userJSON);
            } else {
                response.put("error", "Invalid new user.");
                responseCode = Response.Status.BAD_REQUEST;
            }
            return Response.status(responseCode).entity(response.toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(getErrorResponse().toString()).build();
        }
    }

    private JSONObject getErrorResponse() {
        JSONObject error = new JSONObject();
        error.put("error", "Internal error");
        return error;
    }


}
