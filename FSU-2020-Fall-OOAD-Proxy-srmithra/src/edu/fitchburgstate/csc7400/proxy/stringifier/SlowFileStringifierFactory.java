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
 * Factory used to create slow stringifiers
 * 
 * @author amontalvo
 */
public class SlowFileStringifierFactory implements StringifierFactory {
	/**
	  * Creates a file stringifier given a filename
	  * 
	  * @param filename the name of the file to stringify
	  * 
	  * @return a new file stringifier
	  */
	@Override
	public FileStringifier createStringifier(String filename) {
		return new SlowFileStringifier(filename);
	}
}
