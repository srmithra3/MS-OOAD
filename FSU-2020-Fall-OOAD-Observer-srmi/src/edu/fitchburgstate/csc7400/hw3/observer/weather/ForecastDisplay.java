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

import java.util.Observable;
import java.util.Observer;

/**
 * Forecast display
 * shows weather forecast based on barometer
 * or pressure readings
 */
public class ForecastDisplay implements Observer, DisplayElement {
	
	private Observable obsr;
	/**
	 * Constructor with observable
	 * 
	 * @param observable
	 *            which the weather data for initialization
	 * 
	 * @precondition observable != null
	 */
	public ForecastDisplay(Observable observable) {
		this.obsr=observable;
		observable.addObserver(this);
	}

	/**
	 * Displays the data
	 * Analyzes current pressure and last pressure and 
	 * displays the observations
	 * @precondition current pressure and last pressure must not be null
	 */
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

	private float currentPressure = 29.92f;  
	private float lastPressure;
	/**
	 * Updates the last pressure and current pressure values
	 * makes sure the observable is of type weather data 
	 * displays the values obtained
	 * 
	 * @param observable and optional data argument
	 * @precondition observable must be of type weather data 
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData wd = (WeatherData)o;
			this.lastPressure = currentPressure;
			this.currentPressure = wd.getPressure();
			display();
		}
	}

}
