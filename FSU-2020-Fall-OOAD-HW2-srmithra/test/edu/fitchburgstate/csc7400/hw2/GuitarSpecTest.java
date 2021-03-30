/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * 
 * Date: 2020-09-03
 */
package edu.fitchburgstate.csc7400.hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test Guitar
 */
class GuitarSpecTest {

	/**
	 * Can we create a new object?
	 */
	@Test
	void testGuitarSpec() {
		new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
	}

	/**
	 * Can we get the manufacturer?
	 */
	@Test
	void testGetManufacturer() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(GuitarManufacturer.COLLINS, guitarSpec.getGuitarManufacturer());
	}

	/**
	 * Can we get the model?
	 */
	@Test
	void testGetModel() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals("CJ", guitarSpec.getModel());
	}

	/**
	 * Can we get the type?
	 */
	@Test
	void testGetType() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(GuitarType.ACOUSTIC, guitarSpec.getGuitarType());
	}

	/**
	 * Can we get the back wood?
	 */
	@Test
	void testGetBackWood() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(GuitarWood.INDIAN_ROSEWOOD, guitarSpec.getBackGuitarWood());
	}
	/**
	 * Can we get the top wood?
	 */
	@Test
	void testGetTopWood() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		assertEquals(GuitarWood.SITKA, guitarSpec.getTopGuitarWood());
	}

	/**
	 * Test match of manufacturer only, both match and match failure
	 */
	@Test
	void testMatches_manufacturer() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec2 = new GuitarSpec(GuitarManufacturer.COLLINS, null, 
				null, null, null);
		
		GuitarSpec guitarSpec3 = new GuitarSpec(GuitarManufacturer.FENDER, null, 
				null, null, null);
		
		assertFalse(guitarSpec.matches(guitarSpec2));
		assertFalse(guitarSpec.matches(guitarSpec3));
	}

	/**
	 * Test match of model only, both match and match failure
	 */
	@Test
	void testMatches_model() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec2 = new GuitarSpec(GuitarManufacturer.COLLINS, null, 
				null, null, null);
		
		
		GuitarSpec guitarSpec3 = new GuitarSpec(GuitarManufacturer.FENDER, null, 
				null, null, null);
		
		assertFalse(guitarSpec.matches(guitarSpec2));
		assertFalse(guitarSpec.matches(guitarSpec3));
	}

	/**
	 * Test match of typu only, both match and match failure
	 */
	void testMatches_type() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec2 = new GuitarSpec(null, null, 
				GuitarType.ACOUSTIC, null, null);
		
		
		GuitarSpec guitarSpec3 = new GuitarSpec(null, null, 
				GuitarType.ELECTRIC, null, null);
		
		assertTrue(guitarSpec.matches(guitarSpec2));
		assertFalse(guitarSpec.matches(guitarSpec3));
	}

	/**
	 * Test match of body wood only, both match and match failure
	 */
	void testMatches_backWood() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec2 = new GuitarSpec(null, null, 
				null, GuitarWood.INDIAN_ROSEWOOD, null);
		
		
		GuitarSpec guitarSpec3 = new GuitarSpec(null, null, 
				null, GuitarWood.BRAZILIAN_ROSEWOOD, null);
				
		assertTrue(guitarSpec.matches(guitarSpec2));
		assertFalse(guitarSpec.matches(guitarSpec3));
	}

	/**
	 * Test match of top wood only, both match and match failure
	 */
	void testMatches_topWood() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec2 = new GuitarSpec(null, null, 
				null, null, GuitarWood.SITKA);
		
		
		GuitarSpec guitarSpec3 = new GuitarSpec(null, null, 
				null, null, GuitarWood.MAPLE);
				
		assertTrue(guitarSpec.matches(guitarSpec2));
		assertFalse(guitarSpec.matches(guitarSpec3));
	}

	/**
	 * Test match of two attributes: manufacturer and model.
	 * A match and two failures one for each attribute
	 */
	void testMatches_multi_manufacturer_model() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec2 = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				null, null, null);		
		
		GuitarSpec guitarSpec3 = new GuitarSpec(GuitarManufacturer.COLLINS, "PJ", 
				null, null, null);		
		
		GuitarSpec guitarSpec4 = new GuitarSpec(GuitarManufacturer.FENDER, "CJ", 
				null, null, null);		
		
		assertTrue(guitarSpec.matches(guitarSpec2));
		assertFalse(guitarSpec.matches(guitarSpec3));
		assertFalse(guitarSpec.matches(guitarSpec4));
	}

	/**
	 * Test match of two attributes: model and type.
	 * A match and two failures one for each attribute
	 */
	void testMatches_multi_model_type() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec2 = new GuitarSpec(null, "CJ", 
				GuitarType.ACOUSTIC, null, null);		
		
		GuitarSpec guitarSpec3 = new GuitarSpec(null, "CJ", 
				GuitarType.ELECTRIC, null, null);		
		
		GuitarSpec guitarSpec4 = new GuitarSpec(null, "PJ", 
				GuitarType.ACOUSTIC, null, null);		
		
		assertTrue(guitarSpec.matches(guitarSpec2));
		assertFalse(guitarSpec.matches(guitarSpec3));
		assertFalse(guitarSpec.matches(guitarSpec4));
	}

	/**
	 * Test match of two attributes: bottom and top wood
	 * A match and two failures one for each attribute
	 */
	void testMatches_multi_bottom_top_wood() {
		GuitarSpecInterface guitarSpec = new GuitarSpec(GuitarManufacturer.COLLINS, "CJ", 
				GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec2 = new GuitarSpec(null, null, 
				null, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec3 = new GuitarSpec(null, null, 
				null, GuitarWood.BRAZILIAN_ROSEWOOD, GuitarWood.SITKA);
		
		GuitarSpec guitarSpec4 = new GuitarSpec(null, null, 
				null, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.MAPLE);
		
		assertTrue(guitarSpec.matches(guitarSpec2));
		assertFalse(guitarSpec.matches(guitarSpec3));
		assertFalse(guitarSpec.matches(guitarSpec4));
	}
}
