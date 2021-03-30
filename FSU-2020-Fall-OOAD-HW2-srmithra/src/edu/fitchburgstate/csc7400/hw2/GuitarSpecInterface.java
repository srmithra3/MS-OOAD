/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * Author - Sai Sree Mithra Sripathi
 * 
 * Date: 2018-10-04
 */
package edu.fitchburgstate.csc7400.hw2;

/**
 * GuitarSpec contains the information needed to keep track of a type of guitar specifications from
 * Rick's music store
 * 
 * @author HeadFirstOODA- Sai Sree Mithra Sripathi
 */

public interface GuitarSpecInterface {

	
	/**
	 * returns the Guitar Manufacturer from the GuitarManufacturer enum
	 */
	GuitarManufacturer getGuitarManufacturer();

	/**
	 * 
	 * returns a string, which defines the Model of the Guitar
	 */
	String getModel();

	/**
	 * Returns type of guitar from GuitarType enum
	 * @return the type
	 */
	GuitarType getGuitarType();

	/**
	 * Returns backWood of Guitar which belongs to GuitarWood enum
	 * @return the backGuitarWood
	 */
	GuitarWood getBackGuitarWood();

	/**
	 * Returns topWood of Guitar which belongs to GuitarWood enum 
	 * @return the topGuitarWood
	 */
	GuitarWood getTopGuitarWood();
	/**
	 * This method checks the guitar specs - manufacturer , model , type , back wood and top wood 
	 * if they are null / empty or whether they match the existing guitar entries
	 * null or empty are not accepted
	 * if the values passed to the method as parameter and the existing values do not match it is not accepted. 
	 * in case any condition is not met it returns false value. 
	 * if all conditions it finally returns a true value.
	 * @param Guitar spec containing details about manufacturer , model , type , back wood and top wood
	 * @returns boolean value - True if guitar passed as argument matches existing guitar
	 * False if any of the spec values is null or empty or doesnt match with the existing guitar values.
	 */

	boolean matches(GuitarSpec otherSpec);

}