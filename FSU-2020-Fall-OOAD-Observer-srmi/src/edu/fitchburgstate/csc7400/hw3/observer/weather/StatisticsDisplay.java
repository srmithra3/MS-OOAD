/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Observer Homework
 * Submitted by: Mithra Sripathi
 * 
 * Date: 2020-11-10
 * 
 * Code taken from HeadFirst Object-Oriented Design Patterns sample
 */
package edu.fitchburgstate.csc7400.hw3.observer.weather;

import java.util.Observer;
import java.util.Observable;
/**
 * Display of weather statistics
 * keeps track of min,max and avg temperaturesS
 */
public class StatisticsDisplay implements Observer, DisplayElement {

	private Observable obsr;
	/**
	 * Constructor with observable as input
	 * 
	 * @param observable
	 *            which  contains weather data for initialization
	 * 
	 * @precondition observable != null
	 */
	public StatisticsDisplay(Observable observable) {
		this.obsr=observable;
		observable.addObserver(this);
	}

	/**
	 * Updates the display with new data
	 * retrieves temperature from observable and compares with
	 * maxTemp and minTemp
	 * Displays the changed values finally
	 * @param observable and optional argument
	 */
	public void update(Observable o, Object arg) {
		float temp=0.0f;
		if (o instanceof WeatherData) {
			WeatherData wd = (WeatherData)o;
			temp = wd.getTemperature();
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}

		if (temp < minTemp) {
			minTemp = temp;
		}

		display();
		}
	}

	/**
	 * Displays the data related to avg , min , max temperatures
	 */
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
	}

	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum = 0.0f;
	private int numReadings;
}
