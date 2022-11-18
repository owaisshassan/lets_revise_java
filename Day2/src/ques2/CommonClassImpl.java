package ques2;

public class CommonClassImpl implements Interface1,Interface2{

	@Override
	public void commonDefault() {
		// TODO Auto-generated method stub
		Interface1.super.commonDefault();
	}
	
	public static void main(String[] args) {
		
		CommonClassImpl c= new CommonClassImpl();
		c.commonDefault();
		
		
	}

}
