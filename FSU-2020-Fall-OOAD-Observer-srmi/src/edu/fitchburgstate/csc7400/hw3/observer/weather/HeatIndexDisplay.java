/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: Observer Homework
 * Author: Mithra Sripathi
 * 
 * Date: 2020-11-10
 * 
 * Created for HeadFirst Object-Oriented Design Patterns sample
 */
package edu.fitchburgstate.csc7400.hw3.observer.weather;

import java.util.Observer;
import java.util.Observable;
/**
 * Obtains the temperature and humidity from observable 
 * calculates the heat index and 
 * displays the heat index value
 * @author Mithra Sripathi
 *
 */
public class HeatIndexDisplay implements Observer,DisplayElement{
	float heatIndex = 0.0f;
	
/**
 * constructor for HeatIndexDisplay
 * @param observable
 */
	public HeatIndexDisplay(Observable observable) {
		observable.addObserver(this);
	}
	/**
	 * displays heatindex value
	 */
	@Override
	public void display() {
		System.out.println("The heat index is :  " + heatIndex);
	}
	/**
	 * obtains temperature and humidity values
	 * calculates the heat index using mathematical formula
	 * displays the heat index value obtained
	 * makes sure the observable is of type weather data 
	 * 
	 * @param observable and optional data argument
	 * @precondition observable must be of type weather data 
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData wd = (WeatherData)o;
			float t = wd.getTemperature();
			float rh = wd.getHumidity();
			heatIndex = (float)
				(
				(16.923 + (0.185212 * t)) + (5.37941 * rh) - (0.100254 * t * rh) + 
				(0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) + 
				(0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
				(0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + 
				(0.0000291583 * (rh * rh * rh)) +(0.00000142721 * (t * t * t * rh)) + 
				(0.000000197483 * (t * rh * rh * rh)) - 
				(0.0000000218429 * (t * t * t * rh * rh)) +
				(0.000000000843296 * (t * t * rh * rh * rh)) -
				(0.0000000000481975 * (t * t * t * rh * rh * rh)));
			display();
		}
		
	}
	
}
