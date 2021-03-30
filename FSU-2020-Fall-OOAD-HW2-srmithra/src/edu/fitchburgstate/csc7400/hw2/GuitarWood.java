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
 * GuitarWood contains the information regarding the wood used in guitar manufacture
 * The values that can be given for wood are presented as an enum in this file.
 * 
 * @author HeadFirstOODA
 */

	public enum GuitarWood { 

	  INDIAN_ROSEWOOD("Indian Rosewood"), BRAZILIAN_ROSEWOOD("Brazilian Rosewood"), MAHOGANY("Mahogany"), MAPLE("Maple"),
	  COCOBOLO("Cocobolo"), CEDAR("Cedar"), ADIRONDACK("Adirondack"), ALDER("Alder"), SITKA("Sitka"), NEWWOOD("new wood");

		/**
		 * Converts guitar wood type to string
		 * returns a string with display name of guitar wood
		 */
	  public String toString() {
	   return this.getDisplayName();
	  }
	  /** 
	   * Return the GuitarManufacturer enum value for a given display name 
	   * @param displayName the display name of the manufacturer 
	   * @return the enum value 
	   */ 
		public static GuitarWood forDislayName(String displayName) {
		    for (GuitarWood gm: GuitarWood.values()) {
				if (displayName.equalsIgnoreCase(displayName))
					return gm;
			}
			return null;
			
		}
/**
 * Constructor for GuitarWood
 * @param displayName
 */
	private GuitarWood(String displayName) {
		this.displayName = displayName;
		
	}
	/**
	 * getter for display name of guitar wood
	 * @returns display name of guitar which is of type String
	 */

	private String getDisplayName() {
		return this.displayName;
	}
/**
 * display name for guitar wood
 */
	private final String displayName; 
	}