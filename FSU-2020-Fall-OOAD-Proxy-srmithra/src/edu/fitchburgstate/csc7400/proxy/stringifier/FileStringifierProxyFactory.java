/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Proxy Homework
 * 
 * Date: 2020-11-12
 * 
 * @author srmithra
 */
package edu.fitchburgstate.csc7400.proxy.stringifier;

import java.beans.PropertyChangeListener;

/**
 * Factory used to create slow stringifiers
 * 
 * @author amontalvo
 */
public class FileStringifierProxyFactory implements StringifierFactory {
	
	private PropertyChangeListener pcl;
	StringifierFactory   sf;
	/**
	 * accepts and saves PropertyChangeListener 
	 */
	public FileStringifierProxyFactory(PropertyChangeListener pcListener) {
		this.pcl=pcListener;
	}

	/**
	  * Creates a file stringifier given a filename
	  * adds PropertyChangeListener as observer to FileStringifierProxy
	  * 
	  * @param filename the name of the file to stringify
	  * 
	  * @return a new file stringifier
	  */
	@Override
	public FileStringifier createStringifier(String filename) {
		FileStringifierProxy fsp = new FileStringifierProxy(filename);
		fsp.addObserver(pcl);
		return fsp;
	}
}
