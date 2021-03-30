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
 * GuitarType contains the information regarding the type of guitar.
 * The values that can be given for type are presented as an enum in this file.
 * 
 * @author HeadFirstOODA
 */
public enum GuitarType
{ 
	ACOUSTIC("acoustic"),
	ELECTRIC("electric"),
	NEWTYPE("newtype");

/** 
 * 
 * 
 *  Return the GuitarType enum value for a given display name
 *  @param displayName the display name of the manufacturer 
 *  @return the enum value 
 *  
 */ 
	public static GuitarType forDislayName(String displayName) {
		for (GuitarType gm: GuitarType.values()) {
			if (displayName.equalsIgnoreCase(displayName))
				return gm;
		}
		return null;
		
	}
/**
 * Constructor for GuitarType
 * @param displayName
 */
private GuitarType(String displayName) {
	this.displayName = displayName;
	
}
/**
 * getter for display name of GuitarType
 * @return string which is the display name of guitar type
 */
private String getDisplayName() {
	return this.displayName;
}
/**
 * converts display name to string of lower case
 */
public String toString() { 
	return this.getDisplayName().toLowerCase(); 
}
/**
 * display name for guitar type
 */
private final String displayName; 
}
//This enum is used to specify the type of a guitar