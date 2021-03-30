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

/**
 * Uses sleep to waste time
 */
public class Sleeper implements TimeEater {

	/**
	 * Wastes time for certain number of seconds
	 * 
	 * @param seconds the number of seconds to waste
	 * 
	 * @return number of milliseconds wasted
	 */
	@Override
	public long nomNom(int seconds) {
		long startTime = System.currentTimeMillis();
		
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// Shouldn't happen
			e.printStackTrace();
		}
		System.out.println(String.format("Slept %d", seconds));

		return System.currentTimeMillis() - startTime;
	}

}
