package Day5;

public class ThreadImpl2 implements Runnable{

	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		
			int sum=0;
			int i=1;
			while(i<=10000) {
				sum+=i;
				i++;
			}
			
			System.out.println("ThreadImpl2 sum is :"+sum);
//			notifyAll();
	}
}
