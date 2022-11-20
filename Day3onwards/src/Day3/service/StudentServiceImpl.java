package Day3.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import Day3.Address;
import Day3.Student;
import Day3.sorting.SortByMarks;
import Day3.sorting.SortByName;

public class StudentServiceImpl implements StudentService{

	public List<Student> students=new ArrayList<>();
	
	public List<Student> generateStuList() {
		Address a1=new Address("bangalore","abc","1112");
		Student s1=new Student(10, "owais", 200, "A", a1);
		Address a2=new Address("sgr","xyz","2233");
		Student s2=new Student(20, "bhat", 300, "B", a2);
		Address a3=new Address("kmr","hdh","2233");
		Student s3=new Student(30, "newStu", 300, "B", a3);
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		return students;
	}
	

	
	@Override
	public Student addStudent(Student stu) {
		// TODO Auto-generated method stub
		students.add(stu);
		return stu;
	}

	String s="Student not found!";
	@Override
	public String deleteStudent(Integer id) {
		
		students.forEach(stu -> {
			if(stu.getId()==id) {
				students.remove(stu);
				s= "Student deleted successfully!";
			}
		});
		return s;
	}

	@Override
	public Student findStudent(Integer id) {
		Student s=new Student();
		students.forEach(stu -> {
			if(stu.getId()==id) {
				s.setId(id);
				s.setName(stu.getName());
				s.setMarks(stu.getMarks());
				s.setSection(stu.getSection());
				s.setAddress(stu.getAddress());
			}
		});
	   return s;
	}

	@Override
	public List<Student> findStudentWithPincode(String pin) {
		List<Student> list=new ArrayList<>();
		students.forEach(stu -> {
			if(stu.getAddress().getPinCode().equals(pin)) {
				list.add(stu);
			}
		});
	   return list;
	}

	@Override
	public List<Student> sortWithName() {
		Collections.sort(students,new SortByName());
		return students;
	}

	@Override
	public List<Integer> setOfMarks() {
		List<Integer> uniqueMarks=new ArrayList<>();
		HashSet<Student> set=new HashSet<>(students);
		set.forEach(s ->{
			uniqueMarks.add(s.getMarks());
		});
		return uniqueMarks;
	}

	@Override
	public List<Student> addAllStudents(List<Student> list) {
		list.forEach(student ->{
			students.add(student);
		});
		Collections.sort(students, new SortByMarks());
		System.out.println(students.size());
		return students;
	}

}
