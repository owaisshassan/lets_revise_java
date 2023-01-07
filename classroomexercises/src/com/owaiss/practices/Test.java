package com.owaiss.practices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1, o2);
	}
	
}


@FunctionalInterface
interface MyFunctionalInterface {
	
	public void methodToBeImplemented();
	
	public default void myDefaultMethod() {
		System.out.println("default method of Functional Interface1");
	}
	
}

@FunctionalInterface
interface MyFunctionalInterface2 {
	
	public void methodToBeImplemented2();
	
	public default void myDefaultMethod() {
		System.out.println("default method of Functional Interface2");
	}
}


class EvenNumberPredicate implements Predicate<Integer>{

	@Override
	public boolean test(Integer num) {
		// TODO Auto-generated method stub
		return num % 2 == 0;
	}
	
}


public class Test {
	
	
//	@Override
//	public void methodToBeImplemented() {
//		// TODO Auto-generated method stub
//		System.out.println("Dummy implementation..");
//	}
//	
//
//	@Override
//	public void methodToBeImplemented2() {
//		// TODO Auto-generated method stub
//		System.out.println("methodToBeImplemented2");
//	}
//	
//	@Override
//	public void myDefaultMethod() {
//		// TODO Auto-generated method stub
//		MyFunctionalInterface2.super.myDefaultMethod();
//	}


	public static void main(String[] args) {
		
		
		//Functional Interface ? Interface having only one method.
		//@FunctionalInterface  --- annotation
		/*
		 * Functional Interface can have default methods.
		 * 
		 * if two interfaces have same methods (same signature) and a class implements both 
		 * of them, it causes problems of duplication.
		 * 
		 * in such case, we have to override method from only one of the interfaces.
		 */
		
		
		
		/*
		 * LAMBDA EXPRESSIONS:
		 * 
		 * it shortens the method implementation.
		 * it is widely used in case of Functional Interfaces.
		 * 
		 */
		
		
		
		
		
		//boxed() mehthod is used to convert particular IntStream into Stream:
		List<Integer> intList= IntStream.range(1, 11).map(e -> e*e).boxed().collect(Collectors.toList());
		
		
		
		//List<Integer> numbers =  List.of(12, 34, 45, 56, 65, 54, 45, 34, 12);
		List<Integer> numbers=new ArrayList<>();
		numbers.add(12);
		numbers.add(34);
		//PREDICATE:
		numbers.stream().filter(new EvenNumberPredicate()).forEach(e -> System.out.println(e));
		
		//find the greatest number:
		
		Optional<Integer> opt= numbers.stream().max((n1, n2) -> Integer.compare(n1, n2));
		System.out.println(opt.get());
		
		
		//using MyComparator class (user-defined):
		Optional<Integer> opt2= numbers.stream().max(new MyComparator());
		System.out.println(opt2.get());
		
		//orElse:
		int max=numbers.stream().max((n1, n2) -> Integer.compare(n1, n2)).orElse(0);
		System.out.println(max);
		
//		//orElseThrow:
//		int max2=numbers.stream().max((n1, n2) -> Integer.compare(n1, n2)).orElseThrow();
//		System.out.println(max2);
		
		
		//print list of odd numbers from above list (using stream) : 
		numbers.stream().filter(e -> e % 2 == 1).forEach(System.out::print);
		//print list of DISTINCT odd numbers from above list (using stream) : 
		numbers.stream().filter(e -> e%2 == 1).distinct().forEach(System.out::print);
		//SORTED:
		numbers.stream().filter(e -> e%2 == 1).distinct().sorted().forEach(System.out::print);
		
		//print square for each element of the above list : 
		System.out.println("squares way 1:");
		numbers.stream().forEach(e -> System.out.println(e*e));
		System.out.println("squares way 2:");
		numbers.stream().map(e -> e * e).forEach(e -> System.out.println(e));
		System.out.println("squares of odds :");
		numbers.stream().filter(e -> e%2 == 1).map(e -> e * e).forEach(e -> System.out.println(e));
		
		//using collect and collectors:
		System.out.println("using collect and collectors :");
		List<Integer> lst= numbers.stream().filter(e -> e%2==1).map(e -> e*e).collect(Collectors.toList());
		lst.stream().forEach(e -> System.out.println(e));
		
		
		
		//List<String> animals=List.of("PIGEON","Lion","COW","Hen","Cat");
		
		List<String> animals = new ArrayList<>();
		animals.add("pigeON");
		animals.add("Lion");
		animals.add("cAt");
		animals.add("TIGER");
		//covert all elements of animals to lowercase:
		animals.stream().map(e -> e.toLowerCase()).forEach(e -> System.out.println(e));
		
		//sum of the above numbers (without using stream) :
		/*
		 * we declare a local variable
		 * mutate the variable
		 * use loop
		 * 
		 */
		int sum=0;
		for(int num : numbers) {
			sum+=num;
		}
		System.out.println(sum);
		
		
		//sum of the above numbers (using stream) :
		int sum2=numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println(sum2);
		
		
		
	}



	

}
