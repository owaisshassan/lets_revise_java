package Day5;

public class ThreadImpl1 extends Thread{

	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=1;i<=10000;i++) {
			sum+=(i+(i+1));
		}
		try {
			wait();
			System.out.println("ThreadImpl1 sum is :"+sum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		notifyAll();
	}
}
