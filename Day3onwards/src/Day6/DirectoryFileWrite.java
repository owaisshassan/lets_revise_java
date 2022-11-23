package Day6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DirectoryFileWrite {

	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the path to create a directory: ");
		String path=sc.next();
		
		System.out.println("Enter the name of the directory: ");
		path +=sc.next();
		
		File file = new File(path); // new file
		
		boolean bool=file.mkdir();  //creating dir
		
		if(bool) {
			System.out.println("Directory created successfully!");
		}else {
			System.out.println("Directory already exists!");
		}
		
		
		
		
		//creating new file:
		System.out.println("Enter file name to be created:");
		String fileName=sc.next();
		
		String completeFilePath=path+fileName;
		// completeFilePath:    ./resources/newDir/newFile
		
		File newFile=new File(fileName);
		if(newFile.exists()) {
			System.out.println("File already exists!");
		}else {
			System.out.println("Creating new file..");
			newFile.createNewFile();
			System.out.println("File created successfully!");
			System.out.println("writing into file..");
			//writing into file : 
			Path filePath=Paths.get(completeFilePath);
			
			List<String> writtenData= List.of("Hello","You're in a","new File");
			Files.write(filePath, writtenData);
			System.out.println("Data inserted successfully!");
		}
		
		
		sc.close();
		
		
	}

}
