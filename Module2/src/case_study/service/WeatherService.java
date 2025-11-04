package case_study.service;

import case_study.entity.WeatherResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WeatherService {
    private static final String API_KEY = "78cad82bb3f39568e57ba08fa2fc8f6f";

    public WeatherResponse getWeatherByCity(String city) {
        try {
            String encodedCity = URLEncoder.encode(city + ",vn", StandardCharsets.UTF_8);
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + encodedCity + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }
                reader.close();
                Gson gson = new Gson();
                WeatherResponse response = gson.fromJson(json.toString(), WeatherResponse.class);

                conn.disconnect();
                return response;
            } else return null;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
