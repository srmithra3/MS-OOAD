/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * Author : srmithra (Sai Sree Mithra Sripathi)
 * 
 * Date: 2018-09-03
 */
package edu.fitchburgstate.csc7400.hw2;

/**
 * GuitarManufacturer contains the information regarding the manufacturer of the guitar.
 * The values that can be given for guitar manufacturer are presented as 
 * an enum in this file.
 * 
 * @author HeadFirstOODA
 */
//This enum is used to specify the builder or manufacturer of a guitar
	public enum GuitarManufacturer { 

	  FENDER("Fender"), MARTIN("Martin"), GIBSON("Gibson"), COLLINS("Collings"), OLSON("Olson"), RYAN("Ryan"), PRS("PRS"), ANY("any");

	  public String toString() {
	    return this.displayName;
	  }
	  /** * Return the GuitarManufacturer enum value for a given display name * * @param displayName the display name of the manufacturer * * @return the enum value */ 
		public static GuitarManufacturer forDislayName(String displayName) {
			for (GuitarManufacturer gm: GuitarManufacturer.values()) {
				if (displayName.equalsIgnoreCase(displayName))
					return gm;
			}
			return null;
		}
		/**
		 * Constructor for GuitarManufacturer
		 * @param displayName
		 */

	private GuitarManufacturer(String displayName) {
		this.displayName = displayName;
		
	}
	/**
	 * getter for display name of manufacturer
	 * @return string - display name , name of the manufacturer
	 */

	private String getDisplayName() {
		return this.displayName;
	}
/**
 * display name for manufacturer
 */
	private final String displayName; 
	}