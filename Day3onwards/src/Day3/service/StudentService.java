package Day3.service;

import java.util.List;

import Day3.Student;

public interface StudentService {

	public Student addStudent(Student stu);
	public String deleteStudent(Integer id);
	public Student findStudent(Integer id);
	public List<Student> findStudentWithPincode(String pin);
	public List<Student> sortWithName();
	public List<Integer> setOfMarks();
	public List<Student> addAllStudents(List<Student> students);
}
