import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n Student Management System ");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Report");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter studnet 1name: ");
                    sc.nextLine(); 
                    String sname = sc.nextLine();
                    System.out.print("Enter percentage: ");
                    int sper = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter class: ");
                    String sclass = sc.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = sc.nextLine();
                    dao.addStudent(new Student(sname, sper, sclass,gender));
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s.getId() + " - " + s.getsname() + " - " + s.getsper() + " - " + s.getsclass()+ " - " + s.getgender());
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    sname = sc.nextLine();
                    System.out.print("Enter new percentage: ");
                    sper = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new class: ");
                    sclass = sc.nextLine();
                    System.out.println("Enter new gender");
                    gender=sc.nextLine();
                    dao.updateStudent(new Student(id, sname, sper, sclass,gender));
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;
               
                case 5:
                	 sc.nextLine();
                	 System.out.println("Enter a name to search:");
                	 String keyword= sc.nextLine();
                	 List<Student> results=dao.searchStudent(keyword);
                	 if(results.isEmpty())
                	 {
                		 System.out.println("No Students found");
                	 } else {
                         results.forEach(System.out::println);
                     }
                	 break;
                	 
                case 6:
                	 dao.genrateReport();
                	 break;
                	 
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }

	}

}
