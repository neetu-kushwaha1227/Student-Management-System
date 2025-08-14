import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO<conn> {

	 // (1)Add a new student (ID auto-generated)
	public void addStudent(Student student) throws Exception {
		String sql="Insert into Student (SNAME,SPER,SCLASS,GENDER) values(?,?,?,?)";
		try(Connection conn=DBConnection.getConnection(); 
			PreparedStatement stmt= conn.prepareStatement(sql)){
			
			stmt.setString(1, student.getsname());
			stmt.setInt(2,student.getsper());
			stmt.setString(3,student.getsclass());
			stmt.setString(4, student.getgender());
			  int rows = stmt.executeUpdate();
			 if(rows>0) { 
			System.out.println("Successfully added");
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	  // (2) Display all students
	   public List<Student> getAllStudents() throws Exception{
		  List<Student> students=new ArrayList<>();
		  String sql="Select * from Student";
		  try (Connection conn=DBConnection.getConnection(); 
			 PreparedStatement stmt=conn.prepareStatement(sql);
			 ResultSet rs=stmt.executeQuery()){
			while(rs.next()) {
				students.add(new Student (
				rs.getInt("id"),
				rs.getString("sname"),
				rs.getInt("sper"),
				rs.getString("sclass"),
				rs.getString("gender")
				
			    ));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return students;
		
	  }
	
	 // (3) Update a student
	 public void updateStudent(Student student) throws Exception {
	        String sql = "UPDATE Student SET sname=?, sper=?, sclass=?,gender=? WHERE id=?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, student.getsname());
	            stmt.setInt(2, student.getsper());
	            stmt.setString(3, student.getsclass());
	            stmt.setString(4, student.getgender());
	            stmt.setInt(5, student.getId());

	            int rows=stmt.executeUpdate();
	            
	            if(rows>0) {
	            System.out.println("Student updated successfully.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	    // (4) Delete a student
	    public void deleteStudent(int id) throws Exception {
	        String sql = "DELETE FROM Student WHERE id=?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            
	            int rows=stmt.executeUpdate();
	            
	            if(rows>0) {
	                System.out.println("Student deleted successfully.");
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
    
	    // (5) Search by name
	    public List<Student> searchStudent(String keyword) throws Exception{
	    	List<Student> students=new ArrayList<>();
	    	
	    	String sql="Select * from Student where LOWER(sname) LIKE ?";
	    	try(Connection conn=DBConnection.getConnection();  
	    		PreparedStatement stmt=conn.prepareStatement(sql)){
	    		
	    		stmt.setString(1,"%"+keyword.toLowerCase()+"%");
	    		
	    		ResultSet rs=stmt.executeQuery();
	    		while(rs.next()) {
	    			students.add(new Student(rs.getInt("id"),rs.getString("sname"),rs.getInt("sper"),rs.getString("sclass"),rs.getString("gender")));
	    			
	    		}
	    	}
	    	return students;
	    }
	    
	    
	    // (6) Report show
	    public void genrateReport() throws Exception{
	    	
	    	try(Connection conn=DBConnection.getConnection()){
	    		
		    		String total="Select Count(*) as total from Student";
			    	try(PreparedStatement ps = conn.prepareStatement(total);
			                ResultSet rs = ps.executeQuery() ){
			    		
			    		if(rs.next()) {
			    			System.out.println("Total Students:"+rs.getInt("total"));
			    		}
			    	}
	  	
			    	 //Student per class
				    	 System.out.println("\nStudents per Class:");
			    	    String classquery="Select sclass, Count(*) as count from Student Group by sclass";
					       try(PreparedStatement ps = conn.prepareStatement(classquery);
			                   ResultSet rs = ps.executeQuery()){
			    		 
			    		         while(rs.next()) {
			    		         	System.out.println(rs.getString("sclass")+"-"+rs.getInt("count"));
			    	      	}
			    		
			    	    }
			       
			    	  //Student per gender
					    System.out.println("\nStudents per Gender:");
			    	    String genderQuery="Select gender, Count(*) as count from Student Group by gender";
			    	       try(PreparedStatement ps = conn.prepareStatement(genderQuery);
			                    ResultSet rs = ps.executeQuery()){		        
			    		   while(rs.next()) {
			    		       	System.out.println(rs.getString("gender")+"-"+rs.getInt("count"));
			    		   }
			    		
			    	     }
	    	     } 
	    	
	    		
	    }
	    
		
}
