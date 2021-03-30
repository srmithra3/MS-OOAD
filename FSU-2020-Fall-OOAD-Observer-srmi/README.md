# FSU-2020-Fall-OOAD-Observer
Observer Pattern Homework

I want you to change this code to use the pull model. You can do that in one
of two ways. If you know Java then you should use the Java util classes: java.util.Observer,
java.util.Observable. If you are struggling with Java then just change the 
WeatherData class.

Additionally, I'd like you to add a new observer, HeatIndexDisplay which calculates the heat index like
so (and of course displays it)

float t = weatherData.getTemperature();
float rh = weatherData.getHumidity();
heatIndex = (float) ( (16.923 + (0.185212 * t)) +  (5.37941 * rh) -  
  (0.100254 * t * rh) +  (0.00941695 * (t * t)) +  (0.00728898 * (rh * rh)) +  
  (0.000345372 * (t * t * rh)) -  (0.000814971 * (t * rh * rh)) + (0.0000102102 * 
  (t * t * rh * rh)) -  (0.000038646 * (t * t * t)) +  (0.0000291583 * (rh * rh * rh)) + 
  (0.00000142721 * (t * t * t * rh)) +  (0.000000197483 * (t * rh * rh * rh)) - 
  (0.0000000218429 * (t * t * t * rh * rh)) + (0.000000000843296 * (t * t * rh * rh * rh)) - 
  (0.0000000000481975 * (t * t * t * rh * rh * rh)));
  