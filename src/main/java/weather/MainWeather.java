package weather;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import utils.Api;

public class MainWeather {
	private String cityName;

	public MainWeather(String cityName) {
		this.cityName = cityName;
		double latitude = 48.117266;
		double longitude = -1.6777926;
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(Api.getFinalUrl(this.cityName)).build();

		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				System.out.println("Erreur de connexion : " + e.getMessage());
			}

			@Override
			public void onResponse(Call call, Response response) {
				try (ResponseBody body = response.body()) {
					if (response.isSuccessful()) {
						String json_data = body.string();
						CurrentWeather currentWeather = new CurrentWeather(cityName);
						JSONObject json_object = (JSONObject) JSONValue.parseWithException(json_data);
						JSONArray weather = (JSONArray) JSONValue
								.parseWithException(json_object.get("weather").toString());
						JSONObject main = (JSONObject) JSONValue.parseWithException(json_object.get("main").toString());
						JSONObject description = (JSONObject) JSONValue.parseWithException(weather.get(0).toString());

						currentWeather.setTime((Long) json_object.get("dt"));
						currentWeather.setDescription((String) description.get("description"));
						currentWeather
								.setTemperature(Api.convertTempKeltoCel(Double.parseDouble(main.get("temp") + "")));
						currentWeather.setHumidity(Double.parseDouble(main.get("humidity") + ""));
						System.out.println(currentWeather.toString());

					} else {
						System.err.println("Une erreur est survenue ");
					}
				} catch (ParseException | IOException e) {
					System.err.println("Erreur au Parsing du JSON: " + e.getMessage());
				}
			}
		});
	}
}