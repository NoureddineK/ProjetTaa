package myApp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Api {
	private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
	private static final String API_KEY = ",fr&appid=bd4f34566c53fd4ec9b07bf3e4995e1c";

	public static String getFinalUrl(double latitude, double longitude) {
		return BASE_URL + API_KEY + "/" + latitude + "," + longitude;
	}

	public static String getFinalUrl(String city) {
		return BASE_URL + city + API_KEY;
	}

	public static String getFormattedDate(long unixSeconds, String timezone) {
		Date date = new Date(unixSeconds * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		sdf.setTimeZone(TimeZone.getTimeZone(timezone));
		return sdf.format(date);
	}

	public static String getFormattedDate(long unixSeconds) {
		Date date = new Date(unixSeconds * 1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));
		return sdf.format(date);
	}

	// convert temperature from kelvin to celsius
	public static Double convertTempKeltoCel(double temperature) {
		return (temperature - 273.15);
	}

}
