package case_study;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class accuWeather {
    static String apiKey = "zpka_1ff5336c6e104f1788e123a16d84b303_65df6f6a";
    public static String getLocationKey(String cityName) throws IOException {
        String encodeCity = URLEncoder.encode(cityName, StandardCharsets.UTF_8);
        String urlString = "https://dataservice.accuweather.com/locations/v1/cities/search?apikey="
                + apiKey + "&q=" + encodeCity;
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
    static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city name:");
        String cityName = sc.nextLine();
        String locationKey = getLocationKey(cityName);

        // Construct the URL
        String urlString = "https://dataservice.accuweather.com/currentconditions/v1/"
                + locationKey + "?apikey=" + apiKey + "&details=true&metric=true";

        try {
            // 1️⃣ Tạo URL object
            URL url = new URL(urlString);

            // 2️⃣ Mở kết nối HTTP
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET"); // dùng phương thức GET

            // 3️⃣ Kiểm tra mã phản hồi (HTTP Status)
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 4️⃣ Đọc dữ liệu JSON trả về
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // 5️⃣ In chuỗi JSON ra console (bước sau sẽ parse bằng Gson)
                System.out.println("Response JSON:");
                System.out.println(response.toString());

            } else {
                System.out.println("Lỗi: API trả về mã " + responseCode);
            }

            // 6️⃣ Đóng kết nối
            conn.disconnect();

        } catch (IOException e) {
            System.out.println("Lỗi khi gọi API: " + e.getMessage());
        }
    }
}
