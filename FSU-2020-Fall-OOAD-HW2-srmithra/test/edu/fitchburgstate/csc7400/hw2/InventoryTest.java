/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * 
 * Date: 2018-09-03
 */

package edu.fitchburgstate.csc7400.hw2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fitchburgstate.csc7400.hw2.Guitar;
import edu.fitchburgstate.csc7400.hw2.GuitarManufacturer;
import edu.fitchburgstate.csc7400.hw2.GuitarSpec;
import edu.fitchburgstate.csc7400.hw2.GuitarType;
import edu.fitchburgstate.csc7400.hw2.GuitarWood;
import edu.fitchburgstate.csc7400.hw2.Inventory;

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
		inventory.addGuitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		inventory.addGuitar("V95693", 1499.95, GuitarManufacturer.FENDER, "Stratocastor", GuitarType.ELECTRIC, GuitarWood.ALDER, GuitarWood.ALDER);
		inventory.addGuitar("V9512", 1549.95, GuitarManufacturer.FENDER, "Stratocastor", GuitarType.ELECTRIC, GuitarWood.ALDER, GuitarWood.ALDER);
		inventory.addGuitar("122784", 5495.95, GuitarManufacturer.MARTIN, "D-18", GuitarType.ACOUSTIC, GuitarWood.MAHOGANY, GuitarWood.ADIRONDACK);
		inventory.addGuitar("76531", 6295.95, GuitarManufacturer.MARTIN, "OM-28", GuitarType.ACOUSTIC, GuitarWood.BRAZILIAN_ROSEWOOD, GuitarWood.ADIRONDACK);
		inventory.addGuitar("70108276", 2295.95, GuitarManufacturer.GIBSON, "Les Paul", GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAPLE);
		inventory.addGuitar("82765501", 1890.95, GuitarManufacturer.GIBSON, "SG '61 Reissue", GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAHOGANY);
		inventory.addGuitar("77023", 6275.95, GuitarManufacturer.MARTIN, "D-28", GuitarType.ACOUSTIC, GuitarWood.BRAZILIAN_ROSEWOOD, GuitarWood.ADIRONDACK);
		inventory.addGuitar("1092", 12995.95, GuitarManufacturer.OLSON, "SJ", GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.CEDAR);
		inventory.addGuitar("566-62", 8999.95, GuitarManufacturer.RYAN, "Cathedral", GuitarType.ACOUSTIC, GuitarWood.COCOBOLO, GuitarWood.CEDAR);
		inventory.addGuitar("6 29584", 2100.95, GuitarManufacturer.PRS, "Dave Navarro Signature", GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAPLE);
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
		inventory.addGuitar("123", 1.0, GuitarManufacturer.COLLINS, "Big-Bird", GuitarType.ACOUSTIC, GuitarWood.COCOBOLO, GuitarWood.COCOBOLO);
		
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
		GuitarInterface guitar = inventory.getGuitar("76531");
		assertNotNull(guitar, "Could not retrieve guitar with sn: 76531");
		assertEquals("76531", guitar.getSerialNumber(), "Retrieved wrong guitar");
	}

	/**
	 * Test a guitar search. Simple search for guitar in the inventory with all parameters known.
	 * There are two guitars that meet this criteria
	 */
	@Test
	void testSearch_all_multiple_return() {
		GuitarSpec whatErinLikes = new GuitarSpec(GuitarManufacturer.FENDER, "Stratocastor", GuitarType.ELECTRIC, GuitarWood.ALDER, GuitarWood.ALDER);
		List<Guitar> guitars = inventory.search(whatErinLikes, null, null);
		assertEquals(2, guitars.size(), "Should have found two guitars");
		for (GuitarInterface guitar: guitars) assertTrue(compareGuitars(whatErinLikes, guitar));
	}

	/**
	 * Test a guitar search. Simple search for guitar in the inventory with just manufacturer.
	 * There are two Gibson guitars
	 */
	@Test
	void testSearch_manufacturer() {
		GuitarSpec whatAbbyLikes = new GuitarSpec(GuitarManufacturer.GIBSON, null, null, null, null);
		List<Guitar> guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(2, guitars.size(), "Should have found two guitars");
		Guitar gibson1 = new Guitar("70108276", 2295.95, GuitarManufacturer.GIBSON, "Les Paul", GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAPLE);
		Guitar gibson2 = new Guitar("82765501", 1890.95, GuitarManufacturer.GIBSON, "SG '61 Reissue", GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAHOGANY);

		for (GuitarInterface guitar: guitars) {
			assertTrue(compareGuitars(whatAbbyLikes, guitar));
			if (guitar.getSerialNumber().equals("70108276"))
				assertTrue(gibson1.getSerialNumber().equals(guitar.getSerialNumber()));
			else 
				assertTrue(gibson2.getSerialNumber().equals(guitar.getSerialNumber()));
		}
	}

	/**
	 * Test a guitar search for model
	 */
	@Test
	void testSearch_model() {
		GuitarSpec whatAbbyLikes = new GuitarSpec(null, "Dave Navarro Signature", null, null, null);
		List<Guitar> guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(1, guitars.size(), "Should have found one guitars");
		Guitar guitar = new Guitar("6 29584", 2100.95, GuitarManufacturer.PRS, "Dave Navarro Signature", GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAPLE);
		assertTrue(guitar.equal(guitars.get(0)));

		whatAbbyLikes = new GuitarSpec(null, "Death Metal Nuclear", null, null, null);
		guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(0, guitars.size(), "Should have found 0 guitars");
	}


	/**
	 * Test a guitar search for type
	 */
	@Test
	void testSearch_type() {
		GuitarSpec whatAbbyLikes = new GuitarSpec(null, null, GuitarType.ACOUSTIC, null, null);
		List<Guitar> guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(6, guitars.size(), "Should have found six guitars");
		
		whatAbbyLikes = new GuitarSpec(null, null, GuitarType.ELECTRIC, null, null);
		guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(5, guitars.size(), "Should have found five guitars");
	}

	/**
	 * Test a guitar search for top wood
	 */
	@Test
	void testSearch_topWood() {
		GuitarSpec whatAbbyLikes = new GuitarSpec(null, null, null, null, GuitarWood.SITKA);
		List<Guitar> guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(1, guitars.size(), "Should have found one guitars");
		
		whatAbbyLikes = new GuitarSpec(null, null, null, null, GuitarWood.MAPLE);
		guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(2, guitars.size(), "Should have found two guitars");
	}

	/**
	 * Test a guitar search for bottom wood
	 */
	@Test
	void testSearch_backWood() {
		GuitarSpec whatAbbyLikes = new GuitarSpec(null, null, null, GuitarWood.MAHOGANY, null);
		List<Guitar> guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(4, guitars.size(), "Should have found four guitars");
		
		whatAbbyLikes = new GuitarSpec(null, null, null, GuitarWood.INDIAN_ROSEWOOD, null);
		guitars = inventory.search(whatAbbyLikes, null, null);
		assertEquals(2, guitars.size(), "Should have found one guitar");
	}

	/**
	 * Test a guitar search. Simple search for guitar in the inventory with all parameters known.
	 * There is in only one PRS guitar in the test inventory
	 */
	@Test
	void testSearch_manufacturer_single_return() {
		GuitarSpec whatCarlLikes = new GuitarSpec(GuitarManufacturer.PRS, null, null, null, null);
		List<Guitar> guitars = inventory.search(whatCarlLikes, null, null);
		assertEquals(1, guitars.size(), "Should have found one guitar");
		for (Guitar guitar: guitars) assertTrue(compareGuitars(whatCarlLikes, guitar));
		Guitar foundGuitar = guitars.get(0);
		Guitar expectedGuitar = new Guitar("6 29584", 2100.95, GuitarManufacturer.PRS, "Dave Navarro Signature", GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAPLE);
		assertTrue(compareGuitars(expectedGuitar, foundGuitar));
		assertEquals("6 29584", foundGuitar.getSerialNumber(), "Serial numbers don't match");
	}


	/**
	 * Test a guitar search. Simple search for guitar in the inventory with just manufacturer
	 */
	@Test
	void testSearch_multi_fail() {
		// There is no Monster manufacturer
		GuitarSpec whatBettyLikes = new GuitarSpec(GuitarManufacturer.PRS, null, GuitarType.ACOUSTIC, null, null);
		List<Guitar> guitars = inventory.search(whatBettyLikes, null, null);
		assertTrue(guitars.isEmpty(), "Found guitar when none should have been found");
	}

	/**
	 * Compares the guitar for which we are searching, with the Guitar found
	 * 
	 * @param searchGuitar the guitar use in the search
	 * @param foundGuiter the guitar returned by the search
	 * 
	 * @return true if there is a match
	 */
	private boolean compareGuitars(GuitarSpecInterface searchGuitar, GuitarInterface foundGuitar) {
		GuitarManufacturer srchManufacturer = searchGuitar.getGuitarManufacturer();
		GuitarManufacturer fndManufacturer = foundGuitar.getGuitarManufacturer();
		if (srchManufacturer != null  && srchManufacturer != fndManufacturer)
			return false;
		
		GuitarWood srchBackWood = searchGuitar.getBackGuitarWood();
		GuitarWood fndBackWood = foundGuitar.getBackGuitarWood();
		if (srchBackWood != null && srchBackWood != fndBackWood)
			return false;

		GuitarWood srchTopWood = searchGuitar.getTopGuitarWood();
		GuitarWood fndTopWood = foundGuitar.getTopGuitarWood();
		if (srchTopWood != null && srchTopWood != fndTopWood)
			return false;

		String srchModel = searchGuitar.getModel();
		String fndModel = foundGuitar.getModel();
		if (srchModel != null && !fndModel.equalsIgnoreCase(srchModel))
			return false;

		GuitarType srchType = searchGuitar.getGuitarType();
		GuitarType fndType = foundGuitar.getGuitarType();
		return srchType == null || srchType == fndType;
	}
}
