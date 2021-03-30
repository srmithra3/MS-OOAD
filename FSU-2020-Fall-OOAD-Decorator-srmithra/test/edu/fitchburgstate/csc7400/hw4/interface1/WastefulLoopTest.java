/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Decorator/Adapter Homework
 * 
 * Date: 2020-11-01
 * 
 * @author omontalv
 */
package edu.fitchburgstate.csc7400.hw4.interface1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test the amount of time wasted in WastefulLoop
 */
class WastefulLoopTest {

	@Test
	void testTwiddle() {
		this.twiddle(0);
	}
	
	@Test
	void testTwiddle_1() {
		this.twiddle(1);
	}

	@Test
	void testTwiddle_2() {
		this.twiddle(2);
	}

	@Test
	void testTwiddle_3() {
		this.twiddle(3);
	}

	void twiddle(int secs) {
		WastefulLoop looper = new WastefulLoop();
		
		long estTime = secs*1000;
		long actualTime = looper.twiddle(secs);
		assertTrue(
				estTime <= actualTime,
				String.format("Run time %d should be greater than %s", actualTime, estTime)
		);
	}
}
