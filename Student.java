
public class Student {

	
	private int id;
	private	String sname;
	private	int sper;
	private	String sclass;
	private	String gender;
		
	
    // Constructor with ID
	
	 public Student(int id,String sname,int sper,String sclass,String gender) {
			this.id=id;
			this.sname=sname;
			this.sper=sper;
			this.sclass=sclass;
			this.gender=gender;
			
		}
		
	    // Constructor without ID for insert
		public Student(String sname,int sper,String sclass,String gender) {
			this.sname=sname;
			this.sper=sper;
			this.sclass=sclass;
			this.gender=gender;
		}
		
		//getters & Setters
		
		public int getId() { return id; }
		public String getsname() {return sname;}
		public int getsper() {return sper; }
		public String getsclass() { return sclass; }
		public String getgender() { return gender; }
		
		  @Override
		    public String toString() {
		        return "ID: " + id +
		               ", Name: " + sname +
		               ", Percentage: " + sper +
		               ", Class: " + sclass +
		               ", Gender: " + gender;
		    }
		

	

}
