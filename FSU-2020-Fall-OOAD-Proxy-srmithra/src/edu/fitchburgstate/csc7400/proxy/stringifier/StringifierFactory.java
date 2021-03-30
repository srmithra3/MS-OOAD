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

/**
 * A simple factory for Stringifiers 
 */
public interface StringifierFactory {
	
	/**
	  * Creates a file stringifier given a filename
	  * 
	  * @param filename the name of the file to stringify
	  * 
	  * @return a new file stringifier
	  */
	public FileStringifier createStringifier(String filename);
}
