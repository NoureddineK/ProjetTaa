package weather;

import java.io.IOException;
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

public class MainFrame {
	public MainFrame(String title) {
		double latitude = 48.117266;
		double longitude = -1.6777926;
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(Api.getFinalUrl("Nantes")).build();

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
						JSONObject json_object = (JSONObject) JSONValue.parseWithException(json_data);
						System.out.println(json_object);
						
						 JSONObject currently = (JSONObject) JSONValue
						 .parseWithException(json_object.get("currently").toString());
						 
						 CurrentWeather currentWeather = new CurrentWeather();
						 currentWeather.setTimezone((String) json_object.get("timezone"));
						 currentWeather.setTime((Long) currently.get("time"));
						 currentWeather.setTemperature(Double.parseDouble(currently.get("temperature")
						 + "")); currentWeather.setSummary((String) currently.get("summary"));
						 currentWeather
						 .setPrecipProbability(Double.parseDouble(currently.get("precipProbability") +
						 "")); currentWeather.setHumidity(Double.parseDouble(currently.get("humidity")
						 + ""));
						 
						 System.out.println("Time zone + time : " + currentWeather.getTimezone() +
						 " / " + Api.getFormattedDate(currentWeather.getTime(),
						 currentWeather.getTimezone()));
						 
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
