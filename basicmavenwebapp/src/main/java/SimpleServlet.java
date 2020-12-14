import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = -4751096228274971485L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;

        try {
            con = ConnDB.initializeDatabase();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from utente");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " "
                        + rs.getString(4) + "  " + rs.getString(5));
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Map<String, String> envVars = ConnDB.getEnv();
        // for (Map.Entry<String, String> envVar : envVars.entrySet()) {
        // response.getWriter().println(envVar.getKey() + " = " + envVar.getValue());
        // }

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