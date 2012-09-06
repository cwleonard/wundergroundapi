package com.amphibian.weather.request;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import com.amphibian.weather.response.WeatherResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WeatherRequest {

	private final static String BASE_URL = "http://api.wunderground.com/api/";
	
	private String apiKey;
	
	private Set<Feature> features;
	
	public WeatherRequest() {
		this.apiKey = null;
		this.features = new HashSet<Feature>();
	}
	
	public void setApiKey(String k) {
		this.apiKey = k;
	}
	
	public void addFeature(Feature f) {
		this.features.add(f);
	}
	
	public WeatherResponse query(String zip) {
		
		if (this.apiKey == null) {
			return null;
		}
		
		if (this.features.size() == 0) {
			return null;
		}
		
		Client c = Client.create();
		
		String url = BASE_URL + this.apiKey + "/";
		Iterator<Feature> i = this.features.iterator();
		while (i.hasNext()) {
			url += i.next() + "/";
		}
		url += "q/" + zip + ".json";
		
		WebResource r = c.resource(url);
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		WeatherResponse w = response.getEntity(WeatherResponse.class);
		return w;
		
	}
	
	
	public static void main(String[] args) {

		WeatherRequest req = new WeatherRequest();
		req.setApiKey("your_api_key");
		req.addFeature(Feature.CONDITIONS);
		req.addFeature(Feature.FORECAST);
		req.addFeature(Feature.ALERTS);
		WeatherResponse resp = req.query("17084");
		
		System.out.println("Current weather: " + resp.getConditions().getWeather());
		System.out.println("Current temp(F): " + resp.getConditions().getTempF());
		
		
	}
	
}
