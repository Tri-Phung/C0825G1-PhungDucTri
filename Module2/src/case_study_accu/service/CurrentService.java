package case_study_accu.service;

import case_study_accu.common.Key.ApiKey;
import case_study_accu.entity.CurrentWeather;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CurrentService implements ICurrentWeatherService {
    @Override
    public String getLocationKey(String cityName) throws IOException {
        String encodeCity = URLEncoder.encode(cityName, StandardCharsets.UTF_8);
        String urlString = "https://dataservice.accuweather.com/locations/v1/cities/search?apikey="
                + ApiKey.getApiKey() + "&q=" + encodeCity;
        HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            JsonArray results = JsonParser.parseReader(reader).getAsJsonArray();
            if (results.size() > 0) {
                String locationKey = results.get(0).getAsJsonObject().get("Key").getAsString();
                return locationKey;
            } else {
                throw new IOException("Không tìm thấy thành phố " + cityName);
            }
        }
    }

    @Override
    public CurrentWeather[] getCurrentWeather(String cityName) throws IOException {
        String key = getLocationKey(cityName);
        String urlString = "https://dataservice.accuweather.com/currentconditions/v1/"
                + key + "?apikey=" + ApiKey.getApiKey() + "&details=true&metric=true";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Gson gson = new Gson();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    CurrentWeather[] responseObj = gson.fromJson(reader, CurrentWeather[].class);
                    return responseObj;
                }

            } else {
                return null;
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi gọi API: " + e.getMessage());
            return null;
        }
    }
}
