package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadPrintContentOfAFile {

	
	public static void main(String[] args) throws IOException {
		
		
		Path currPath=Paths.get("./resources/readPrint.txt");
		
		
		List<String> files= Files.readAllLines(currPath);
		System.out.println(files);
		
	}
}
