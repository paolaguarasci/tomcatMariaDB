import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

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
        PrintWriter out = response.getWriter();

        try {
            con = ConnDB.initializeDatabase();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from utente");
            out.println("<h1>RESPONSE</h1>");
            while (rs.next())
                out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " "
                        + rs.getString(4) + "  " + rs.getString(5));
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> envVars = ConnDB.getEnv();
        for (Map.Entry<String, String> envVar : envVars.entrySet()) {
            out.println(envVar.getKey() + " = " + envVar.getValue());
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