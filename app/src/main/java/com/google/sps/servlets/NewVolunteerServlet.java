package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.gson.Gson;
import com.google.sps.Volunteer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list-volunteers")
public class NewVolunteerServlet extends HttpServlet {


    @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
   
    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(readMessagesFromDatastore()));
  }

  public List readMessagesFromDatastore() {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Volunteer"). build();
    QueryResults<Entity> results = datastore.run(query);

    List<Volunteer> volunteers = new ArrayList<>();
    if (results == null){
        Volunteer volunteer = new Volunteer();
        volunteers.add(volunteer);
    }
    while (results.hasNext()) {
      Entity entity = results.next();

      String firstName = entity.getString("firstName");
      String lastName = entity.getString("lastName");
      String email = entity.getString("email");
      String experience = entity.getString("experience");
      String reference = entity.getString("reference");

      Volunteer volunteer = new Volunteer(firstName, lastName, email, experience, reference);
      volunteers.add(volunteer);
    }
    return volunteers;
  }
}