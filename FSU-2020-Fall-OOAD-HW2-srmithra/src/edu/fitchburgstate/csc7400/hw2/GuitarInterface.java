/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * Author - Sai Sree Mithra Sripathi
 * 
 * Date: 2018-10-04
 */
package edu.fitchburgstate.csc7400.hw2;

public interface GuitarInterface extends GuitarSpecInterface {

	/**
	 * Return the manufacturer serial number
	 * 
	 * NB: Gets and sets do not need @params or @returns because they do one thing which
	 * is already in the comment
	 * 
	 * @postcondition return!= null && return !== ""
	 */
	String getSerialNumber();

	/**
	 * Return store price of guitar
	 */
	double getPrice();

	/**
	 * Set the store price of the guitar
	 */
	void setPrice(double newPrice);
	/**
	 * Compares if two guitars are equal , one is the current guitar which calls this method and the other is the guitar passed as parameter
	 * The guitar fields comapred if equal are - manufacturer , type , top wood , back wood , price and model
	 * 
	 * @param Guitar object as input
	 * @return boolean value
	 * True if the guitar passed as argument and the current loaded guitar are equal - compares manufacturer , type , top wood , back wood , price and model
	 * False if any of the above conditions are not equal
	 * 
	 * @precondition Guitar object must not be null
	 */

	boolean equal(Guitar guitar);

}