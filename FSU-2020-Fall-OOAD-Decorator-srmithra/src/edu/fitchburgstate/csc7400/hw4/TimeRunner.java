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
 * Runs the time code several times with output
 */
public class TimeRunner {

	/**
	 * Run the time decorator for 4 different amounts of time
	 * @param args
	 */
	public static void main(String[] args) {
		WasteTime waster = new SleeperAdapter();
		TimeDifferenceDecorator decorator = new TimeDifferenceDecorator(waster);
		long startTime = System.currentTimeMillis();
		
		int totalSecs = 0;
		for (int i = 0; i < 5; i++) {
			totalSecs += i;
			decorator.twiddle(i);
		}
		
		long timeWasted = System.currentTimeMillis() - startTime;
		System.out.println(String.format("Total amount of time wasted is %dms, difference from expected %dms",
				timeWasted,
				timeWasted - totalSecs * 1000));
	}
}
