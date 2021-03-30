/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Decorator/Adapter Homework
 * 
 * Date: 2020-11-01
 * 
 * @author omontalv
 */
package edu.fitchburgstate.csc7400.hw4.interface2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fitchburgstate.csc7400.hw4.interface1.WastefulLoop;

/**
 * Test the amount of time wasted in Sleeper
 */
class SleeperTest {

	@Test
	void testNomNom() {
		this.nommer(0);
	}


	@Test
	void testNomNom_1() {
		this.nommer(1);
	}

	@Test
	void testNomNom_2() {
		this.nommer(2);
	}

	@Test
	void testNomNom_3() {
		this.nommer(3);
	}

	void nommer(int secs) {
		Sleeper sleeper = new Sleeper();
		
		long estTime = secs*1000;
		long actualTime = sleeper.nomNom(secs);
		assertTrue(
				estTime <= actualTime,
				String.format("Run time %d should be greater than %s", actualTime, estTime)
		);
	}
}
