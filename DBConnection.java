import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	/*public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Neetuk123");
		 System.out.println("✅ Database connected successfully!");


	}*/
	   public static Connection getConnection() throws Exception{
	        Connection conn = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle driver
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Neetuk123");
	           // System.out.println("✅ Database connected successfully!");
	            conn.setAutoCommit(true); // auto-commit ON for Oracle
	        } catch (SQLException e) {
	            System.out.println("❌ Database connection failed!");
	            e.printStackTrace();
	        }
	        return conn;
	    }

}
