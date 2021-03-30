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
 * Display for current conditions
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

	/**
	 * Constructor with weather data
	 * Takes an observable as input to add the current conditions 
	 * to observer
	 * 
	 * @param Observable
	 *            the weather data for initialization
	 * 
	 * @precondition Observable != null
	 */
	public CurrentConditionsDisplay(Observable observable) {
		this.obsr=observable;
		observable.addObserver(this);
	}

	/**
	 * Displays the data
	 */
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
	Observable obsr;
	private float temperature;
	private float humidity;
	
	/**
	 * Updates the temperature and humidity values
	 * makes sure the observable is of type weather data 
	 * displays the values obtained
	 * 
	 * @param observable and optional data argument
	 * @precondition observable must be of type weather data 
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData wd = (WeatherData)o;
			this.temperature = wd.getTemperature();
			this.humidity = wd.getHumidity();
			display();
		}
		
	}
}
