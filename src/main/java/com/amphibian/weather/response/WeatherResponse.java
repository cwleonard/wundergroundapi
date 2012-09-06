package com.amphibian.weather.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name="response")
public class WeatherResponse {

	@XmlTransient private String version;
	@XmlTransient private String terms;

	@XmlTransient private Conditions conditions;
	@XmlTransient private ForecastWrapper forecasts;
	@XmlTransient private Astronomy astronomy;
	@XmlTransient private List<Alert> alerts;

	public WeatherResponse() {
		alerts = new ArrayList<Alert>();
	}
	
	/**
	 * @return the version
	 */
	@XmlElement(name="version")
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the terms
	 */
	@XmlElement(name="termsofService")
	public String getTerms() {
		return terms;
	}

	/**
	 * @param terms the terms to set
	 */
	public void setTerms(String terms) {
		this.terms = terms;
	}

	/**
	 * @return the conditions
	 */
	public Conditions getConditions() {
		return conditions;
	}

	/**
	 * @param c the conditions to set
	 */
	@XmlElement(name="current_observation")
	public void setConditions(Conditions c) {
		this.conditions = c;
	}

	/**
	 * @return the forecast
	 */
	@XmlElement(name="forecast")
	public ForecastWrapper getForecasts() {
		return forecasts;
	}

	/**
	 * @param forecast the forecast to set
	 */
	public void setForecasts(ForecastWrapper forecast) {
		this.forecasts = forecast;
	}

	@XmlTransient
	public Forecast getTextForecast() {
		if (this.forecasts == null) return null;
		return this.forecasts.getTextForecast();
	}
	
	@XmlTransient
	public Forecast getSimpleForecast() {
		if (this.forecasts == null) return null;
		return this.forecasts.getSimpleForecast();
	}

	/**
	 * @return the astronomy
	 */
	@XmlElement(name="moon_phase")
	public Astronomy getAstronomy() {
		return astronomy;
	}

	/**
	 * @param astronomy the astronomy to set
	 */
	public void setAstronomy(Astronomy astronomy) {
		this.astronomy = astronomy;
	}

	/**
	 * @return the alerts
	 */
	public List<Alert> getAlerts() {
		return alerts;
	}
	
	
	
}
