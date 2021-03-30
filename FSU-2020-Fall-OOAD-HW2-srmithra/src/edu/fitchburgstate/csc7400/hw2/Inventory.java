/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * 
 * Date: 2020-09-03
 */

package edu.fitchburgstate.csc7400.hw2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory contains all information about guitars that are available in store. The inventory
 * allows search by the following attributes or some combination thereof: manufacturer, model,
 * type, back wood, and top wood. The inventory also allows a search by serial number
 *
 * @author OMontalv, HeadFirst
 *
 */
public class Inventory {
	/**
	 * List of guitars of type Guitar
	 */
	private List<Guitar> guitars;

	/**
	 * Create the inventory storage
	 * Initializing the guitars list
	 */

	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}

	/**
	 * Add a guitar to the inventory 
	 * 
	 * @param serialNumber the manufacturer or store serial number
	 * @param price the store price for the guitar
	 * @param guitar spec
	 */
	public void addGuitar(String serialNumber, double price, GuitarSpecInterface gspec) {
		Guitar guitar = new Guitar(serialNumber, price, gspec.getGuitarManufacturer(),gspec.getModel(),gspec.getGuitarType(),gspec.getBackGuitarWood(),gspec.getTopGuitarWood());
		guitars.add(guitar);
	}
	/**
	 * Add a guitar to the inventory 
	 * 
	 * @param serialNumber the manufacturer or store serial number
	 * @param price the store price for the guitar
	 * @param manufacturer the guitar manufacturer
	 * @param model the manufacturer serial number
	 * @param type the type of guitar
	 * @param backWood the wood used to create the body of the guitar
	 * @param topWood the wood used on the face of the guitar
	 */
	
	public void addGuitar(String serialNumber, double price, GuitarManufacturer manufacturer, String model, GuitarType type, 
			GuitarWood backWood, GuitarWood topWood) {
		Guitar guitar = new Guitar(serialNumber, price, manufacturer, model,type,backWood,topWood);
		guitars.add(guitar);
	}
	/**
	 * Return a guitar based on serial number
	 * 
	 * @param serialNumber the manufacturer or store serial number
	 * 
	 * @return the matching guitar or null if not found
	 */

	public Guitar getGuitar(String serialNumber) {
		for (Guitar guitar : guitars) {
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	/**
	 * Return a list of guitars that meet the attributes passed in searchGuitar. Search 
	 * only matches on manufacturer, model, type, backWood, and topWood. If any of these
	 * are null, or an empty string, then they are considered wild cards 
	 * 
	 * @param searchGuitar the guitar containing the search criteria
	 * @param double lowest price
	 * @param double highest price
	 * 
	 * @return list of guitars that meet the criteria in searchGuitar, or an empty list
	 * @postcondition return != null
	 */

	public List<Guitar> search(GuitarSpec searchGuitar, Double lowestPrice, Double highestPrice) {
		List<Guitar> returnList = new ArrayList<Guitar>();
		for (Guitar guitar : guitars) {
			// Ignore serial number since that's unique
			// Ignore price since that's unique
			if (matchEnum(guitar.getGuitarManufacturer(), searchGuitar.getGuitarManufacturer()) &&
					matchAttribute(guitar.getModel(), searchGuitar.getModel()) &&
					matchEnum(guitar.getGuitarType(), searchGuitar.getGuitarType()) &&
					matchEnum(guitar.getBackGuitarWood(), searchGuitar.getBackGuitarWood()) &&
					matchEnum(guitar.getTopGuitarWood(), searchGuitar.getTopGuitarWood()))
			{
				returnList.add(guitar);
			}
		}
		return returnList;
	}
	
	/**
	 * matches two guitar attributes
	 * @param strings
	 * @return boolean
	 */
	private boolean matchAttribute(String localAttr, String testAttr) {
		if (wildCard(localAttr) || wildCard(testAttr)) return true;
		else return localAttr.equalsIgnoreCase(testAttr);
	}
	/**
	 * Return true if enum  is a wildcard
	 * @param enum
	 * @return boolean
	 */
	
	private boolean matchEnum(Object o1, Object o2) {
		if (wildEnum(o1) || wildEnum(o2)) return true;
		else return o1.equals(o2);
	}
	
	/**
	 * Return true if attribute is a wildcard
	 * @param string
	 * @return boolean
	 */
	private boolean wildCard(String attr) {
		return attr == null || attr.isEmpty();
	}
	/**
	 * Return true if enum is a wildcard
	 * @param enum 
	 * @return boolean
	 */
	
	private boolean wildEnum(Object object) {
		return object == null;
	}
	

}
