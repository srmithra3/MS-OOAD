package edu.fitchburgstate.csc7400.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author srmithra
 * student id @01414266
 * 
 * This Junit is for unit tesing the constructor and the getters setters 
 * in the  Guitar.java 
 *
 */
class GuitarTest {
	Guitar guitar;
/**
 * initialize block in the junit test case
 * creating a new guitar Fender
 * @throws Exception
 */
	@BeforeEach
	void setUp() throws Exception {
		guitar = new Guitar("V95693", 1499.95, "Fender", "Stratocastor", "electric", "Alder", "Alder");
	}
/**
 * The final test case to be run
 * removing he guitar bject created by making its value null
 * @throws Exception
 */
	@AfterEach
	void tearDown() throws Exception {
		guitar = null;
	}
	/**
	 * Testing if the guitar created during set up has been added.
	 */

	@Test
	void testGuitar() {
		//fail("Not yet implemented");
		assertNotNull(guitar,"The guitar is not created in the constructor");
	}
/**
 * Creating  a new guitar and checking the serial number is correctly retrieved
 */
	@Test
	void testGetSerialNumber() {
		Guitar snumGuitar = new Guitar("70108276", 2295.95, "Gibson", "Les Paul", "electric", "Mahogany", "Maple");
		assertEquals(snumGuitar.getSerialNumber(),"70108276");
		//fail("Not yet implemented");
	}
	/**
	 * Creating  a new guitar and checking the price is correctly retrieved
	 */

	@Test
	void testGetPrice() {
		Guitar priceGuitar = new Guitar("122784", 5495.95, "Martin", "D-18", "acoustic", "Mahogany", "Adirondack");
		assertTrue(priceGuitar.getPrice()==5495.95);
		//fail("Not yet implemented");
	}
	/**
	 * Creating  a new guitar and setting a new price to it
	 */

	@Test
	void testSetPrice() {
		Guitar priceGuitar = new Guitar("122784", 5495.95, "Martin", "D-18", "acoustic", "Mahogany", "Adirondack");
		priceGuitar.setPrice(6675.99);
		assertTrue(priceGuitar.getPrice()==6675.99);
		//fail("Not yet implemented");
	}
	/**
	 * Creating  a new guitar and checking the guitar manufacturer is correctly retrieved
	 */

	@Test
	void testGetManufacturer() {
		//fail("Not yet implemented");
		Guitar manuGuitar = new Guitar("V95693", 1499.95, "Fender", "Stratocastor", "electric", "Alder", "Alder");;
		assertTrue(manuGuitar.getManufacturer()=="Fender");
	}
	/**
	 * Creating  a new guitar and checking the guitar model is correctly retrieved
	 */

	@Test
	void testGetModel() {
		//fail("Not yet implemented");
		Guitar modelGuitar = new Guitar("6 29584", 2100.95, "PRS", "Dave Navarro Signature", "electric", "Mahogany", "Maple");
		assertTrue(modelGuitar.getModel()=="Dave Navarro Signature");
	}
	/**
	 * Creating  a new guitar and checking the type of guitar is correctly retrieved
	 */

	@Test
	void testGetType() {
		//fail("Not yet implemented");
		Guitar typeGuitar = new Guitar("566-62", 8999.95, "Ryan", "Cathedral", "acoustic", "Cocobolo", "Cedar");
		assertTrue(typeGuitar.getType()=="acoustic");
	}
	/**
	 * Creating  a new guitar and checking the backwood is correctly retrieved
	 */
	@Test
	void testGetBackWood() {
		//fail("Not yet implemented");
		Guitar bwGuitar = new Guitar("122784", 5495.95, "Martin", "D-18", "acoustic", "Mahogany", "Adirondack");
		assertTrue(bwGuitar.getBackWood()=="Mahogany");
	}
	/**
	 * Creating  a new guitar and checking the top wood variable is correctly retrieved
	 */

	@Test
	void testGetTopWood() {
		//fail("Not yet implemented");
		Guitar twGuitar = new Guitar("1092", 12995.95, "Olson", "SJ", "acoustic", "Indian Rosewood", "Cedar");
		assertTrue(twGuitar.getTopWood()=="Cedar");
	}

}
