package com.google.sps;

import com.google.gson.Gson;
import com.google.sps.Patient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patients")
public final class PatientListServlet extends HttpServlet {

    private static final ArrayList<Patient> PATIENTS = new ArrayList<Patient>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Patient p1 = new Patient("Anna Banana", 19, "Depression");
        Patient p2 = new Patient("Jack Beack", 24, "Anxiety");
        Patient p3 = new Patient("Dawn Derry", 18, "Bipolar disorder");
        Patient p4 = new Patient("Gina Jackson", 15, "Anorexia");
        Patient p5 = new Patient("Sarah Fier", 24, "Anxiety");
        Patient p6 = new Patient("John Rivers", 24, "Anxiety");

        this.PATIENTS.add(p1);
        this.PATIENTS.add(p2);
        this.PATIENTS.add(p3);
        this.PATIENTS.add(p4);
        this.PATIENTS.add(p5);
        this.PATIENTS.add(p6);

        final Gson gson = new Gson();
        response.setContentType("application/json");
        response.getWriter().println(gson.toJson(PATIENTS));
    }
}