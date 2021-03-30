/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * 
 * Date: 2020-09-03
 */

package edu.fitchburgstate.csc7400.hw1;

import java.util.HashSet;
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
	private List<Guitar> guitars;
	private List<Guitar> guitarlist=new LinkedList<Guitar>();
	//List<Guitar> guitarlist = new ArrayList<Guitar>(guitarset);
	HashSet<Guitar> guitarset=new HashSet(); 

	/**
	 * Create the inventory storage
	 */

	public Inventory() {
		guitars = new LinkedList<Guitar>();
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
	public void addGuitar(String serialNumber, double price, String manufacturer, String model, String type, String backWood,
			String topWood) {
		Guitar guitar = new Guitar(serialNumber, price, manufacturer, model, type, backWood, topWood);
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
	 * Return a list of guitars that meets the attributes passed in searchGuitar. Search only matches on
	 * manufacturer, model, type, backWood, and topWood. If any of these are null, or an
	 * empty string, then they are considered wild cards 
	 * 
	 * @param searchGuitar the guitars containing the search criteria
	 * 
	 * @return a list of guitars that meets the criteria in searchGuitar, or empty list if not found
	 */

	public List<Guitar> search(Guitar searchGuitar) {
		String manufacturer = searchGuitar.getManufacturer();
		String model = searchGuitar.getModel();
		String type = searchGuitar.getType();
		String backWood = searchGuitar.getBackWood();
		String topWood = searchGuitar.getTopWood();
		
		for (Guitar guitar : guitars) {
			// Ignore serial number since that's unique
			// Ignore price since that's unique
			if (!manufacturer.equals(guitar.getManufacturer()))
				continue;
			if (model!=""&&!model.equals(guitar.getModel()))
				continue;
			if (type!=""&&!type.equals(guitar.getType()))
				continue;
			if (backWood!=""&&!backWood.equals(guitar.getBackWood()))
				continue;
			if (topWood!=""&&!topWood.equals(guitar.getTopWood()))
				continue;
			guitarlist.add(guitar);
		}
		
		return guitarlist;
	}
}
