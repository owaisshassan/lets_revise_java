package Day3.sorting;

import java.util.Comparator;

import Day3.Student;

public class SortByName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
