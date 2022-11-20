package Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Day3.service.StudentServiceImpl;

public class Demo {

	
	public static void main(String[] args) {
		
		StudentServiceImpl sSer=new StudentServiceImpl();
		
		List<Student> listt= sSer.generateStuList();
		System.out.println(listt);
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("press 1 to add student");
		System.out.println("press 2 to delete student by id");
		System.out.println("press 3 to find student by id");
		System.out.println("press 4 to find students by pin code");
		System.out.println("press 5 to sort students by name");
		System.out.println("press 6 to get unique-student-marks-list");
		System.out.println("press 7 to add new student list");
		
		Integer option=sc.nextInt();
		
		if(option ==1) {
			System.out.println("enter student id:");
			Integer id=sc.nextInt();
			System.out.println("enter student name:");
			String name=sc.next();
			System.out.println("enter student marks:");
			Integer marks=sc.nextInt();
			System.out.println("enter student section:");
			String section=sc.next();
			
			System.out.println("enter student city:");
			String city=sc.next();
			System.out.println("enter student state:");
			String state=sc.next();
			System.out.println("enter student pincode:");
			String pin=sc.next();
			
			Address addr=new Address(city, state, pin);
			
			Student student=new Student(id, name, marks, section, addr);
			
			Student addedStu= sSer.addStudent(student);
			System.out.println(addedStu);
		}else if(option == 2) {
			System.out.println("enter student id to delete student:");
			Integer id=sc.nextInt();
			String rs= sSer.deleteStudent(id);
			System.out.println(rs);
		}else if(option == 3) {
			System.out.println("enter student id to find student:");
			Integer id=sc.nextInt();
			Student s= sSer.findStudent(id);
			System.out.println(s);
		}else if(option == 4) {
			System.out.println("enter student pin to find student:");
			String pin=sc.next();
			List<Student> list= sSer.findStudentWithPincode(pin);
			System.out.println(list);
		}else if(option == 5) {
			System.out.println("sorting students by name:");
			List<Student> list= sSer.sortWithName();
			System.out.println(list);
		}else if(option == 6) {
			List<Integer> list= sSer.setOfMarks();
			System.out.println(list);
		}else if(option == 7) {
			List<Student> newStudents=new ArrayList<>();
			Address a1=new Address("newCity1","newState1","1112");
			Student s1=new Student(50, "owais", 600, "A", a1);
			Address a2=new Address("newCity2","newState2","2233");
			Student s2=new Student(60, "bhat", 550, "C", a2);
			
			newStudents.add(s1);
			newStudents.add(s2);
			
			List<Student> addedStudents=sSer.addAllStudents(newStudents);
			System.out.println(addedStudents);
		}
		
		
		
		
		
		
	}
}
