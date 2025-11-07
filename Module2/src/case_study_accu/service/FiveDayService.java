package case_study_accu.service;

import case_study_accu.common.Key.ApiKey;
import case_study_accu.entity.FiveDayForecast;
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

public class FiveDayService implements IDailyForecastService {
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
                String text = results.get(0).getAsJsonObject().get("Key").getAsString();
                return text;
            } else {
                throw new IOException("Không tìm thấy thành phố" + cityName);
            }
        }
    }
    @Override
    public FiveDayForecast getWeather(String cityName) throws IOException {
        String locationKey = getLocationKey(cityName);
        String urlString = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/"
                + locationKey + "?apikey=" + ApiKey.getApiKey() + "&details=true&metric=true";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Gson gson = new Gson();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    FiveDayForecast responseObj = gson.fromJson(reader, FiveDayForecast.class);
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
