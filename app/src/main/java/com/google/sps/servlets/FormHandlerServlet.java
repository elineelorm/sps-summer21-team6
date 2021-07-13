package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  private static final String REDIRECT_URL =
   "https://summer21-sps-6.uc.r.appspot.com/patients.html";

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    String firstName = request.getParameter("firstName"); 
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String experience = request.getParameter("experience");
    String reference = request.getParameter("reference"); 

    writeToDatastore(firstName, lastName, email, experience, reference);

    System.out.println(firstName + lastName + " wants to be a volunteer");
    response.getWriter().println(firstName + lastName + " wants to be a volunteer");
    response.sendRedirect(REDIRECT_URL);
  }

  public void writeToDatastore(String firstName, String lastName, String email, String experience, String reference){
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Volunteer");
    FullEntity textEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("id", firstName + lastName + Math.random()* firstName.length())
            .set("firstName", firstName)
            .set("lastName", lastName)
            .set("email", email)
            .set("experience", experience)
            .set("reference", reference)
            .build();
    datastore.put(textEntity);
  }
}