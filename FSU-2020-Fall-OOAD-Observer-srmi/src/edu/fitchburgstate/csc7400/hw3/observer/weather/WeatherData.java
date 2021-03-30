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
 * WeatherData collects readings from sensors and then broadcasts the values to observers
 */
public class WeatherData extends Observable {
	
	/**
	 * Default constructor
	 * Doesnt need a data structure to hold observers
	 * as using Observable class
	 * 	 
	 */
	
	public WeatherData() {
	}
	
	/**
	 * Does whatever it needs to do when a sensor sends a change
	 * Uses PULL model , as data object is not sent while calling notifyObservers
	 */
	public void measurementsChanged() {
		setChanged(); //to indicate that state has been changed
		notifyObservers(); //update the change to observers
	}
	
	/**
	 * Sets the weather values from the sensors.
	 * 
	 * @param temperature current temperature
	 * @param humidity current humidity level
	 * @param pressure current barometric pressure
	 */
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	/**
	 * Returns the current temperature
	 */
	public float getTemperature() {
		return temperature;
	}
	
	/**
	 * Returns the current humidity level
	 */
	public float getHumidity() {
		return humidity;
	}
	
	/**
	 * Returns the current barometric pressure
	 */
	public float getPressure() {
		return pressure;
	}
	
	private float temperature;
	private float humidity;
	private float pressure;
}
