package ques1;


//It is not possible in the earlier version of Java e.g. until JDK 7 but
//from JDK 8 onwards you can specify non-abstract methods in form of default 
//and static methods on the interface.


public interface Ques1 {

	public void fun1();
	
	public static void fun2() {
		
	}
	
	default void fun3() {
		
	}
}
