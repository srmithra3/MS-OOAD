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

import java.io.PrintWriter;

/**
 * Abstract file stringifier that performs most of the operations
 * 
 * @author amontalvo
 */
public abstract class FileStringifierAbstract implements FileStringifier {

	/**
	 * Constructor: Creates a file stringifier given the file name
	 * 
	 * @param filename the name of the file to stringify
	 */
    public FileStringifierAbstract(String filename) {
        this.fileName = filename;
    }

    /**
     * Outputs the file to a give PrintWriter
     * 
     * @param out the writer used to output file contents
     */
    public void display(PrintWriter out) {
    	out.println(this.stringify());
    	out.flush();
    }
    
	/**
	 * Returns the file path for the file being stringified
	 */
	@Override
	public String getFilePath() {
		return fileName;
	}

    private final String fileName;
}
