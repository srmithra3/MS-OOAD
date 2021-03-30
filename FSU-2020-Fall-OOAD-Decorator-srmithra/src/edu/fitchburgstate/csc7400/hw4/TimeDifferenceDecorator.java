/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Decorator/Adapter Homework
 * Submitted by :Mithra Sripathi
 * 
 * Date: 2020-11-01
 * 
 * @author omontalv
 */
package edu.fitchburgstate.csc7400.hw4;

import edu.fitchburgstate.csc7400.hw4.interface1.WasteTime;

/**
 * Calculates time difference of time taken to twiddle
 */
public class TimeDifferenceDecorator implements WasteTime {

	private WasteTime waster;

	public TimeDifferenceDecorator(WasteTime wr) {
		this.waster=wr;
	}

	/**
	 * Wastes time for certain number of seconds
	 * calculate difference of start and end time
	 * display difference
	 * 
	 * @param seconds the number of seconds to waste
	 * 
	 * @return number of milliseconds wasted
	 */
		@Override
		public long twiddle(int secs) {
			long startTime = System.currentTimeMillis();
			long runtime= waster.twiddle(secs);
			long endTime = startTime + secs * 1000;
			
			System.out.println(String.format("Total amount of time twiddled is %dms, difference from expected %dms",
					endTime-startTime,
					runtime- secs * 1000));
			
			return runtime;
		}

}
