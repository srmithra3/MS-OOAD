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

/**
 * Test harness for weather station
 */
public class WeatherStation {

	/**
	 * Creates and runs the weather app with a couple of changes for testing
	 * @param args ignored
	 */
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
	
		new CurrentConditionsDisplay(weatherData);
		new StatisticsDisplay(weatherData);
		new ForecastDisplay(weatherData);
		new HeatIndexDisplay(weatherData); //new heat index display call added

		weatherData.setMeasurements(80, 65, 30.4f);
		System.out.println();
		weatherData.setMeasurements(82, 70, 29.2f);
		System.out.println();
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
