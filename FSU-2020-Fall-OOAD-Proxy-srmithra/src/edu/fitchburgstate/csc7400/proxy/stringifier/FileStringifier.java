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

/**
 * FileStringifier is a way of outputting to a writer the contents of
 * a file.
 * 
 * @author amontalvo
 */
public interface FileStringifier {
	/**
	 * Outputs the contents to a given print writer
	 * 
	 * @param out the print writer to use
	 */
	public void display(PrintWriter out);

	/**
	 * Returns the file path for the file being stringified
	 */
	public String getFilePath();

	/**
	 * Turns the file contents into a string so that it can be written
	 * 
	 * @return the string to be written out
	 */
	public String stringify();
}
