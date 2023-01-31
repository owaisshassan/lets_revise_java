package map;

import java.util.Map;

public class Mapping {
	
	   private Map<Student, String> theMap; 
	    
	    public void setTheMap(Map<Student, String> theMap) {
	        this.theMap = theMap;
	    }

	    public void show() {
	        System.out.println(theMap);
	    }
	    

}
