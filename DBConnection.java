import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	   private static final String URL = "jdbc:mysql://localhost:3306/student_db";
       private static final String USER = "root";
       private static final String PASSWORD = "your_mysql_password";
	
	   public static Connection getConnection() throws Exception{
	        Connection conn = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle driver
	            conn = DriverManager.getConnection("URL","USER","PASSWORD");
	            conn.setAutoCommit(true); // auto-commit ON for Oracle
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }

}

