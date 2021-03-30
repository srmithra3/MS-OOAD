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
import edu.fitchburgstate.csc7400.hw4.interface2.Sleeper;

/**
 * Adapter class for sleeper, uses waste time interface to run time 
 */
public class SleeperAdapter implements WasteTime {
	Sleeper sp;
	/**
	 * constructor for sleeper adapter , creates new sleeper object when called
	 */
	public SleeperAdapter() {
		sp = new Sleeper();
	}

	/**
	 * Wastes time for certain number of seconds
	 * 
	 * @param seconds the number of seconds to waste
	 * 
	 * @return number of milliseconds wasted
	 */
		@Override
		public long twiddle(int secs) {
			long  time = sp.nomNom(secs);
			return time;
		}

}
