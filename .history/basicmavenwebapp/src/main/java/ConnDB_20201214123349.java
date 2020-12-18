import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ConnDB {
  public static Map<String, String> getEnv() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("url", System.getenv("MYSQL_URL"));
    map.put("user", System.getenv("MYSQL_USER"));
    map.put("pass", System.getenv("MYSQL_PASSWORD"));
    map.put("root_pass", System.getenv("MYSQL_ROOT_PASSWORD"));
    map.put("db", System.getenv("MYSQL_DATABASE"));
    return map;
  }


    public static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        Map<String, String> envVars = getEnv();
        String dbDriver = "org.mariadb.jdbc.Driver";
        String dbURL = "jdbc:mariadb://localhost:3306/"; 
        // Database name to access 
        String dbName = envVars.get("db"); 
        String dbUsername = envVars.get("user"); 
        String dbPassword = envVars.get("pass"); 
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL + dbName, 
                                                     dbUsername,  
                                                     dbPassword);
        return con; 
    } 

}
