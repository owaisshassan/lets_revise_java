package Day5;

public class Test {

	
	public static void main(String[] args) {
		
		ThreadImpl1 impl1=new ThreadImpl1();

		Thread t1= new Thread(impl1);
		t1.start();
		
		
		
		
		
		ThreadImpl2 impl2=new ThreadImpl2();
		
		Thread t2= new Thread(impl2);
		
		t2.start();
		
		
	}
}
