import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class Main {

	
	public static void main(String args[]) throws FileNotFoundException{
		
		System.out.println("Process started !!\n");
		final String SourcePath = "E:/Spring_BOOT_Program/Microservice/.metadata/.plugins/org.eclipse.jdt.core/";
							
		
		File folder = new File(SourcePath);
		BufferedReader reader = null;
		File[] listofFiles = folder.listFiles();
		List<String> inputLineList = new ArrayList<String>();
		int count = 0;
		int FileCounter = 1;
		
		//Files counter
		for (int i=0; i<listofFiles.length; i++){
			String fileName = listofFiles[i].getName();
			System.out.println("["+(i+1)+"] : "+fileName);
			if(fileName.contains("txt")){ count ++; }		 
		  }
		
		System.out.println("Source Path given : " + SourcePath);
		System.out.println("Number of Files in Source path : " + listofFiles.length);
		System.out.println("Number of Text Files in Source path : " + count +"\n\n");
		
		
		//File processor
		for (int i=0; i<listofFiles.length; i++){
			String fileName = listofFiles[i].getName();
			
			if(fileName.contains("txt")){
				System.out.println("FILE NO ["+FileCounter+"] with Name : "  + fileName);				
				
				String path = SourcePath+fileName;
				File fileForUploading = new File(path);
				reader = new BufferedReader(new FileReader(fileForUploading));
				String inputLine = null;
				
				try { 
					while((inputLine = reader.readLine())!=null){
						for (int k=0; k<inputLine.length(); k++){
							
							char c = inputLine.charAt(k);
							System.out.print(c);
						}
					}
						System.out.println("\n");
						inputLineList.add(inputLine);
						FileCounter++;
				}				
				catch(Exception e){
					
					System.out.println("Exception : " + e);
				}	
			}
		 }		
	}
}
