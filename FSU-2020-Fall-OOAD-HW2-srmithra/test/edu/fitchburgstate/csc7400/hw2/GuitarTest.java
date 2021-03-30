/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * 
 * Date: 2018-09-03
 */
package edu.fitchburgstate.csc7400.hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fitchburgstate.csc7400.hw2.Guitar;
import edu.fitchburgstate.csc7400.hw2.GuitarManufacturer;
import edu.fitchburgstate.csc7400.hw2.GuitarType;
import edu.fitchburgstate.csc7400.hw2.GuitarWood;

/**
 * Test the Guitar class
 * 
 * @author amontalvo
 */
class GuitarTest {

	/**
	 * Can we create a new object?
	 */
	@Test
	void testGuitar() {
		new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
	}

	/**
	 * Can we get the serial number?
	 */
	@Test
	void testGetSerialNumber() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals("11277", guitar.getSerialNumber());
	}

	/**
	 * Can we get the price?
	 */
	@Test
	void testGetPrice() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(3999.95, guitar.getPrice());
	}

	/**
	 * Can we change the price?
	 */
	@Test
	void testSetPrice() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		guitar.setPrice(3499.95);
		assertEquals(3499.95, guitar.getPrice());
	}

	/**
	 * Can we get the manufacturer?
	 */
	@Test
	void testGetManufacturer() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(GuitarManufacturer.COLLINS, guitar.getGuitarManufacturer());
	}

	/**
	 * Can we get the model?
	 */
	@Test
	void testGetModel() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals("CJ", guitar.getModel());
	}

	/**
	 * Can we get the type?
	 */
	@Test
	void testGetType() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(GuitarType.ACOUSTIC, guitar.getGuitarType());
	}

	/**
	 * Can we get the back wood?
	 */
	@Test
	void testGetBackWood() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(GuitarWood.INDIAN_ROSEWOOD, guitar.getBackGuitarWood());
	}

	/**
	 * Can we get the top wood?
	 */
	@Test
	void testGetTopWood() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(GuitarWood.SITKA, guitar.getTopGuitarWood());
	}
	
	/**
	 * Test equals, and failure with serial number, price, manufacturer
	 */
	@Test
	void testEquals() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);

		Guitar guitar2 = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);

		Guitar guitar3 = new Guitar("11276", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		Guitar guitar4 = new Guitar("11277", 3998.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		Guitar guitar5 = new Guitar("11277", 3999.95, GuitarManufacturer.FENDER, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		assertTrue(guitar.equal(guitar2));
		assertFalse(guitar.equal(guitar3));
		assertFalse(guitar.equal(guitar4));
		assertFalse(guitar.equal(guitar5));
	}

	/**
	 * We know guitar specs match, but let's check if they work in guitar and if
	 * price works
	 */
	@Test
	void testMatches() {
		Guitar guitar = new Guitar("11277", 3999.95, GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);

		GuitarSpec guitarspec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);

		assertTrue(guitar.matches(guitarspec, null, null));
		assertTrue(guitar.matches(guitarspec, 2000.0, 4000.0));
		assertTrue(guitar.matches(guitarspec, 2000.0, null));
		assertTrue(guitar.matches(guitarspec, null, 4000.0));
		assertFalse(guitar.matches(guitarspec, 2000.0, 3000.0));
		assertFalse(guitar.matches(guitarspec, null, 3000.0));
		assertFalse(guitar.matches(guitarspec, 4000.0, 5000.0));
		assertFalse(guitar.matches(guitarspec, 4000.0, null));
	}
}
