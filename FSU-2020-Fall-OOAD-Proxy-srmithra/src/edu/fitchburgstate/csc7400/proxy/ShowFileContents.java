/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Proxy Homework
 * 
 * Date: 2020-11-01
 * 
 * @author omontalv
 * Modified by : Mithra Sripathi
 */
package edu.fitchburgstate.csc7400.proxy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.PrintWriter;

import edu.fitchburgstate.csc7400.proxy.stringifier.FileStringifier;
import edu.fitchburgstate.csc7400.proxy.stringifier.FileStringifierProxyFactory;
import edu.fitchburgstate.csc7400.proxy.stringifier.SlowFileStringifierFactory;
import edu.fitchburgstate.csc7400.proxy.stringifier.StringifierFactory;

/**
 * Simple class that accepts a directory name and prints out
 * the file contents of each file in the directory
 * 
 * @author amontalvo
 */
public class ShowFileContents implements PropertyChangeListener {
	
	/**
	 * Create a new ShowFileContents that uses a specific PrintWriter
	 * 
	 * @param writer the writer that will be used to write the file contents
	 */
	public ShowFileContents(PrintWriter writer) {
		this.outWriter = writer;
	}
	
	/**
	 * Outputs the contents of a directory, file by file
	 * 
	 * @param directory the directory path
	 */
	public void outputFileContents(String directory) {
		if (factory == null) throw new IllegalStateException("Must set factory");
        File dir = new File(directory);
        if (!dir.exists()) {
            System.err.println(directory + " does not exist");
            return;
        }
        if (!dir.isDirectory()) {
            System.err.println(directory + " is not a directory");
            return;
        }

        for (File file: dir.listFiles()) {
        	if (file.isDirectory()) continue;
        	printFileContents(factory.createStringifier(file.getPath())); 
        }
	}
	
	/**
	 * Pretty print the stringfier contents
	 * 
	 * @param stringifier the file stringifier
	 */
	public void printFileContents(FileStringifier stringifier) {
    	outWriter.write(String.format("File: %s\n", stringifier.getFilePath()));
    	stringifier.display(outWriter);
    	outWriter.write("\n");
    	outWriter.flush();
	}

	/**
	 * Set the stringifier factory
	 * 
	 * @param sf the stringifier factory to use
	 */
	public void setFactory(StringifierFactory sf) {
		this.factory = sf;
	}

	/**
	 * Display the contents of the files in the directory
	 * 
	 * @param args the command line params, must have a directory
	 */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ShowFileContents <directory>");
            return;
        }
        ShowFileContents fileContents =
        		new ShowFileContents(new PrintWriter(System.out));
        StringifierFactory factory = new FileStringifierProxyFactory(fileContents);
        fileContents.setFactory(factory);
        fileContents.outputFileContents(args[0]);
    }

    private StringifierFactory factory;
    private final PrintWriter outWriter;
    /**
     * prints the new file contents
     * 
     * @param PropertyChangeEvent
     */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		printFileContents((FileStringifier) evt.getNewValue());
	}
  }
