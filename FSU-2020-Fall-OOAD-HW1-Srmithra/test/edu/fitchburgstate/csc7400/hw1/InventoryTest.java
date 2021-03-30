/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * 
 * Date: 2018-09-03
 */

package edu.fitchburgstate.csc7400.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for guitar inventory. 
 */
class InventoryTest {
	Inventory inventory;

	/**
	 * Adds inventory for testing
	 * 
	 * @throws Exception setup exception - needed for test compile
	 */
	@BeforeEach
	void setUp() throws Exception {
		inventory = new Inventory(); 
		inventory.addGuitar("11277", 3999.95, "Collings", "CJ", "acoustic", "Indian Rosewood", "Sitka");
		inventory.addGuitar("V95693", 1499.95, "Fender", "Stratocastor", "electric", "Alder", "Alder");
		inventory.addGuitar("V9512", 1549.95, "Fender", "Stratocastor", "electric", "Alder", "Alder");
		inventory.addGuitar("122784", 5495.95, "Martin", "D-18", "acoustic", "Mahogany", "Adirondack");
		inventory.addGuitar("76531", 6295.95, "Martin", "OM-28", "acoustic", "Brazilian Rosewood", "Adriondack");
		inventory.addGuitar("70108276", 2295.95, "Gibson", "Les Paul", "electric", "Mahogany", "Maple");
		inventory.addGuitar("82765501", 1890.95, "Gibson", "SG '61 Reissue", "electric", "Mahogany", "Mahogany");
		inventory.addGuitar("77023", 6275.95, "Martin", "D-28", "acoustic", "Brazilian Rosewood", "Adirondack");
		inventory.addGuitar("1092", 12995.95, "Olson", "SJ", "acoustic", "Indian Rosewood", "Cedar");
		inventory.addGuitar("566-62", 8999.95, "Ryan", "Cathedral", "acoustic", "Cocobolo", "Cedar");
		inventory.addGuitar("6 29584", 2100.95, "PRS", "Dave Navarro Signature", "electric", "Mahogany", "Maple");
	}
	

	/**
	 * Deletes inventory
	 * 
	 * @throws Exception tearDown exception - needed for test compile 
	 */
	@AfterEach
	void tearDown() throws Exception {
		inventory = null;
	}

	/**
	 * Test insertion of guitar into inventory. If it fails, we cannot be sure if it is the insertion
	 * (addGuitar) or the retrieval that fails (getGuitar)
	 */
	@Test
	void testAddGuitar() {
		inventory.addGuitar("123", 1.0, "Canary", "Big-Bird", "acoustic", "Yellow-wood", "Yellow-wood");
		
		assertNull(inventory.getGuitar("223"), "Found a guitar that shouldn't be there");
		Guitar guitar = inventory.getGuitar("123");
		assertNotNull(guitar, "Either insertion or retrieval failed");
		assertEquals("123", guitar.getSerialNumber(), "Retrieved wrong guitar");
	}

	/**
	 * Test retrieval of guitar into inventory. If it fails, we cannot be sure if it is the insertion
	 * (addGuitar) or the retrieval that fails (getGuitar)
	 */
	@Test
	void testGetGuitar() {
		Guitar guitar = inventory.getGuitar("76531");
		assertNotNull(guitar, "Could not retrieve guitar with sn: 76531");
		assertEquals("76531", guitar.getSerialNumber(), "Retrieved wrong guitar");
	}

	/**
	 * Test a guitar search. Simple search for guitar in the inventory with all parameters known.
	 * There are two guitars that meet this criteria
	 */
	@Test
	void testSearch_all_multiple_return() {
		Guitar whatErinLikes = new Guitar("", 0, "Fender", "Stratocastor", "electric", "Alder", "Alder");
		//Guitar guitar = inventory.search(whatErinLikes);
		List<Guitar> searchResult = new LinkedList<Guitar>();
		searchResult = inventory.search(whatErinLikes);
		for(Guitar guitar:searchResult) {
		assertNotNull(guitar, "Gibson guitar not found");
		assertTrue(compareGuitars(whatErinLikes, guitar), "Guitars don't match");
		assertTrue(searchResult.size()>1);
		}
	}
	/**
	* Test a guitar search. Simple search for guitar such that some items will match, but others
	* won't.
	* There are should be no guitars returned
	*/

	@Test

	void testSearch_all_multiple_return_fail() {

	Guitar whatErinLikes = new Guitar("", 0, "Fender", "Stratocastor", "electric", "Alder", "Hunny");
		//The last atribute topwood is mentioned as Alder in the guitas list above,
		//as "Hunny" doesnot match the guitar is not rerieved.

	List<Guitar> searchresults = inventory.search(whatErinLikes);
	for(Guitar guitar:searchresults) {

	assertNull(guitar, "Guitar should not be found");
	}

	}


	/**
	 * Test a guitar search. Simple search for guitar in the inventory with just manufacturer. It fetches multiple guitars.
	 * There are two Gibson guitars
	 */
	@Test
	void testSearch_manufacturer() {
		Guitar whatAbbyLikes = new Guitar("", 0, "Gibson", "", "", "", "");
		List<Guitar> guitarList = inventory.search(whatAbbyLikes);
		for(Guitar guitar:guitarList) {
		assertNotNull(guitar, "Gibson guitar not found");
		assertTrue(compareGuitars(whatAbbyLikes, guitar), "Guitars don't match");
		}
	}

	/**
	 * Test a guitar search. Simple search for guitar in the inventory with all parameters known.
	 * There is in only one PRS guitar in the test inventory
	 */
	@Test
	void testSearch_manufacturer_single_return() {
		Guitar whatCarlLikes = new Guitar("", 0, "PRS", "", "", "", "");
		List<Guitar> findGuitars = inventory.search(whatCarlLikes);
		Guitar expectedGuitar = new Guitar("6 29584", 2100.95, "PRS", "Dave Navarro Signature", "electric", "Mahogany", "Maple");
		for(Guitar fndGuitar:findGuitars) {
		assertNotNull(fndGuitar, "Gibson guitar not found");
		assertTrue(compareGuitars(whatCarlLikes, fndGuitar), "Guitars don't match");
		assertTrue(compareGuitars(expectedGuitar, fndGuitar), "Returned guitar is not what was expected");
		assertEquals("6 29584", fndGuitar.getSerialNumber(), "Serial numbers don't match");
		}
	}

	/**
	 * Test a guitar search. Simple search for guitar in the inventory with just manufacturer
	 */
	@Test
	void testSearch_manufacturer_fail() {
		// There is no Monster manufacturer
		Guitar whatBettyLikes = new Guitar("", 0, "Monster", "", "", "", "");
		List<Guitar> guitarList = inventory.search(whatBettyLikes);
		for(Guitar guitar:guitarList)
		assertNull(guitar, "Found guitar when none should have been found");
	}

	/**
	 * Compares the guitar for which we are searching, with the Guitar found
	 * 
	 * @param searchGuitar the guitar use in the search
	 * @param foundGuiter the guitar returned by the search
	 * 
	 * @return true if there is a match
	 */
	private boolean compareGuitars(Guitar searchGuitar, Guitar foundGuitar) {
		String srchManufacturer = searchGuitar.getManufacturer();
		String fndManufacturer = foundGuitar.getManufacturer();
		if (!wildCard(srchManufacturer) && !srchManufacturer.equalsIgnoreCase(fndManufacturer))
			return false;
		
		String srchBackWood = searchGuitar.getBackWood();
		String fndBackWood = foundGuitar.getBackWood();
		if (!wildCard(srchBackWood) && !srchBackWood.equalsIgnoreCase(fndBackWood))
			return false;

		String srchTopWood = searchGuitar.getTopWood();
		String fndTopWood = foundGuitar.getTopWood();
		if (!wildCard(srchTopWood) && !srchTopWood.equalsIgnoreCase(fndTopWood))
			return false;

		String srchType = searchGuitar.getType();
		String fndType = foundGuitar.getType();
		return wildCard(srchType) || srchType.equalsIgnoreCase(fndType);
	}
	
	/**
	 * Returns true if searchStr is the wild-card value
	 */
	private boolean wildCard(String searchStr) {
		return searchStr == null || searchStr.isBlank();
	}
}
