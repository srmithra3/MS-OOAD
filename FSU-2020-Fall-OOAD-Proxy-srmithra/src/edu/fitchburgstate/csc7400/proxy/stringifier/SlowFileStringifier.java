/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Proxy Homework
 * 
 * Date: 2020-11-01
 * 
 * @author omontalv
 */
package edu.fitchburgstate.csc7400.proxy.stringifier;

import java.io.*;
import java.util.ArrayList;

/**
 * SlowFileStringifier gets the contents of a file so that it can
 * be written to a print writer. This writer has a delay of two
 * seconds when reading the file.
 * 
 * @author amontalvo
 */
public class SlowFileStringifier extends FileStringifierAbstract {

	/**
	 * Constructor: Creates a file stringifier given the file name
	 * 
	 * @param filename the name of the file to stringify
	 */
    public SlowFileStringifier(String filename) {
        super(filename);
    }

    /**
     * Opens the file and returns the contents as a string
     * 
     * @return the file contents as a string
     */
    public String stringify() {
    	String filePath = this.getFilePath();
        FileReader f;
		try {
			f = new FileReader(filePath);
	        BufferedReader bf = new BufferedReader(f);
	
	        ArrayList<String> lines = new ArrayList<String>();
	        String line = null;
	        while ((line = bf.readLine()) != null) {
	            Thread.sleep(2000);
	            lines.add(line);
	        }
	        bf.close();
	        
	        int lineno = 0;
	        while (lineno < lines.size()) {
	        	line = lines.get(lineno);
	        	if (line.length() > 80) {
	        		int breakat = line.lastIndexOf(' ', 80);
	        		String shortLine = line.substring(0, breakat);
	        		String restLine = line.substring(breakat);
	        		lines.set(lineno, shortLine);
	        		lines.add(lineno+1, restLine);
	        	}
	        	lineno++;
	        }
	        
	        return String.join("\n", lines);
        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File "+filePath+" was not found.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Problem reading file "+filePath+".");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("File reading interrupted: "+filePath);
		}
		return "";
    }
}
