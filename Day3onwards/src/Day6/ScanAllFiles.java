package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScanAllFiles {

	
	public static void main(String[] args) throws IOException {
		
		
		Path currPath=Paths.get(".");
	
		Files.list(currPath).forEach(System.out::println);
		
		
		//Files.walk(currPath, 4).forEach(f -> System.out.println(f));
		
	}
}
