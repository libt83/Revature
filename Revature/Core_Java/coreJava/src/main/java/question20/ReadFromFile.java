package question20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFromFile {

	public String readAndParse() {
		List<String[]> listOfParsedLines = new ArrayList<String[]>();
	    try(Stream<String> stream = Files.lines(Paths.get("data.txt"))) {
	        listOfParsedLines = stream
	                                .map(line -> line.split(":", 0))
	                                .collect(Collectors.toList());
	        stream.close();
	    }catch(IOException ioe) {
	        ioe.printStackTrace();
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(String[] arr : listOfParsedLines) {
	    	sb.append("Name: " + arr[0] + " " + arr[1] + "\n");
	    	sb.append("Age: " + arr[2] + " " + "years\n");
	    	sb.append("State: " + arr[3] + " " + "State\n");
	    	sb.append("\n");
	    }
	    System.out.println(sb.toString());
	    
	return sb.toString();
	}
}
