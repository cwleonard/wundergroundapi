wundergroundapi
---------------

A Java client library for accessing the Weather Underground REST API.

See http://www.wunderground.com/weather/api/ for more information and to register for your own API key.


Example Usage
-------------

	WeatherRequest req = new WeatherRequest();
	req.setApiKey("your_api_key");
	req.addFeature(Feature.CONDITIONS);

	WeatherResponse resp = req.query("17084");
	System.out.println("Current weather: " + resp.getConditions().getWeather());


Author
------

Casey Leonard (@THECaseyLeonard, http://www.caseyleonard.com)