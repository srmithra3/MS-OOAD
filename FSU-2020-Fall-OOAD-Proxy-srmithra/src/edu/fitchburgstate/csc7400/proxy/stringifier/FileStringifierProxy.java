/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Proxy Homework
 * 
 * Date: 2020-11-11
 * 
 * @author srmithra
 */
package edu.fitchburgstate.csc7400.proxy.stringifier;

import java.io.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * FileStringifierProxy gets the contents of a file so that it can
 * be written to a print writer. This writer has a delay of two
 * seconds when reading the file.
 * 
 * @author amontalvo
 * modified by - mithra sripathi
 */
public class FileStringifierProxy extends FileStringifierAbstract implements Runnable {

	SlowFileStringifier sfs;
	String outputString;
	PropertyChangeSupport pcs;
	Thread t;
	
	/**
	 * Constructor: Creates a file stringifier given the file name
	 * initializes 
	 * 
	 * @param filename the name of the file to stringify
	 */
    public FileStringifierProxy(String filename) {
        super(filename);
        outputString=null;
        sfs = new SlowFileStringifier(filename);
        pcs = new PropertyChangeSupport(this);
        
    }

    /**
     * Opens the file and returns the contents as a string
     * if output string is already loaded during run it returns outputString
     * if not it collects and reads the current file path
     * 
     * @return the file contents as a string
     */
    public String stringify() 
    {
    	if(outputString == null) 
    		{
            	t = new Thread(this);
            	t.start();
            	return ("Reading "+this.getFilePath());
    		}
    	else 
    		{
    			return outputString;
    		}
    }

    /**
     * calls SlowFileStringifier stringify which picks the file path 
     * reads the file and converts the contents to string and returns 
     * the string
     * fires a property change trigger with old value as null and new value with the 
     * file contents
     * 
     */
	@Override
	public void run() {
		outputString= sfs.stringify();
		pcs.firePropertyChange("fileContents", null, this);
		
	}
	/**
	 * Add a PropertyChangeListener for a specific property fileContents
	 * in PropertyChangeSupport
	 * @param listener
	 */
	 public void addObserver(PropertyChangeListener listener) {
		 pcs.addPropertyChangeListener("fileContents", listener);

	    }
}
