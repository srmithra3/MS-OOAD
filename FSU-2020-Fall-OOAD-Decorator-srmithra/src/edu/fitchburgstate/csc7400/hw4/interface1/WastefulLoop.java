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

/**
 * Uses loop to waste time
 */
public class WastefulLoop implements WasteTime {

	/**
	 * Wastes time for certain number of seconds
	 * 
	 * @param secs the number of seconds to waste
	 * 
	 * @return number of milliseconds wasted
	 */
	@Override
	public long twiddle(int secs) {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + secs * 1000;
		
		long loopCount = 0;
		while (endTime > System.currentTimeMillis())
			loopCount++;
		
		System.out.println(String.format("Times through loop = %d", loopCount));
		return System.currentTimeMillis() - startTime;
	}

}
