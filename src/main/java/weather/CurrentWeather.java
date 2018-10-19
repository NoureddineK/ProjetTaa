package weather;

import utils.Api;

public class CurrentWeather {
	private String cityName;
	private double temperature;
	private long time;
	private double humidity;
	private String description;

	public CurrentWeather(String cityName) {
		this.cityName = cityName;
	}
	
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.cityName +" [temperature=" + String.format("%.0f", temperature) + "°C, time=" + Api.getFormattedDate(time) + ", humidity=" + humidity + ", description="
				+ description + "]";
	}

}
