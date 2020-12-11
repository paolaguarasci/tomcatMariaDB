package it.artemat.test;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.artemat.test.db.ConnDB;

public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = -4751096228274971485L;
    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response) 
            throws ServletException, IOException {

                Map <String, String> envVars = ConnDB.getEnv(); 
                for (Map.Entry<String,String> envVar : envVars.entrySet()) {
                    response.getWriter().println(envVar.getKey() + " = " + envVar.getValue());
                }  

    }
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}