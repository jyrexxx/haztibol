package ass;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class studentTable {
		Scanner sc = new Scanner(System.in);
		static HashMap<String, Student> students;
		
		public studentTable(){
			students = new HashMap<>();
			sc = new Scanner(System.in);
		}
		
		public void addStudent() {
			String response;
			 do {
				 System.out.print("Enter ID: ");
					String id = sc.nextLine();

					System.out.print("Enter Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Major: ");
					String major = sc.nextLine();

					Student newStudent = new Student(id, name, major);
					students.put(id, newStudent);

             System.out.println("Student ID, Name, and Major added: \n" + id + " | " + name + " | " + major);
             
             System.out.print("\nDo you want to add another student? (Y/N): ");
             response = sc.nextLine();
         } 
         while (response.equalsIgnoreCase("y"));
		}
		
		public  void searchStudent() {
			String response;
			 do {
			System.out.print("Enter the student ID to search: ");
			String searchKey = sc.nextLine();
            if (students.containsKey(searchKey)) {
            	Student found = students.get(searchKey);
                System.out.println("Student ID found: " + found.getId() + " | " + found.getName() + " | " + found.getMajor());
            }
            else {
                System.out.println("Student ID not found");
            }
            System.out.print("\nDo you want to search another student? (Y/N): ");
            response = sc.nextLine();
        } 
        while (response.equalsIgnoreCase("y"));
		}
		
		public void deleteStudent() {
			String response;
			 do {
			 System.out.print("Enter the student ID to delete: ");
             String deleteKey = sc.nextLine();

             if (students.containsKey(deleteKey)) {
            	 students.remove(deleteKey);
                 System.out.println("Student ID deleted: " + deleteKey);
             } else {
                 System.out.println("Student ID not found");
             }
             System.out.print("\nDo you want to delete another student? (Y/N): ");
             response = sc.nextLine();
         } 
         while (response.equalsIgnoreCase("y"));
		}
		
		public void displayStudent() {
			displayStudentRecords();
		}
	 
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			studentTable SDL = new studentTable();
			
			boolean repeat;
			try {
			while (repeat = true) {
				System.out.println("\n~~~~~Choose an Option~~~~");
	            System.out.println("1. Add Student.");
	            System.out.println("2. Search Student.");
	            System.out.println("3. Delete Student.");
	            System.out.println("4. Display Student.");
	            System.out.println("5. Exit.");
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println("Choose from the option:");
	            
				int select = sc.nextInt();
				
				switch(select) {
				case 1:
					SDL.addStudent();
					break;
				case 2:
					SDL.searchStudent();
					break;
				case 3:
					SDL.deleteStudent();
					break;
				case 4:
					SDL.displayStudent();
					break;
				case 5:
					System.out.println("Thank you for using the system!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Input. Choose from the options only!");
					
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input. Select from the choices only!");
			main(args);
		}
	  }
		
		private static void displayStudentRecords() {		
			if (students.isEmpty()) {
		        System.out.println("No student records found!");
		    } else {
		        for (Map.Entry<String, Student> entry : students.entrySet()) {
		            Student student = entry.getValue();
		            System.out.println("Student ID: " + student.getId() + " | Name: " + student.getName() + " | Major: " + student.getMajor());
		        }
			} 
		}
	        
	       class Student {
	    	   	private String id; 
	    	   	private String name;
	            private String major;

	            public Student(String id, String name, String major) {
	            	this.id = id;
	            	this.name = name;	        
	                this.major = major;
	            }

	            public String getName() {
	                return name;
	            }

	            public String getId() {
	                return id;
	            }

	            public String getMajor() {
	                return major;
	            }
	        }
	        }