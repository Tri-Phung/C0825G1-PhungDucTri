package case_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestHttpProtocolApiCall {
    static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city name:");
        String cityName = sc.nextLine();
        String apiKey = "78cad82bb3f39568e57ba08fa2fc8f6f";

        String encodedCity = URLEncoder.encode(cityName + ",vn", StandardCharsets.UTF_8);
        String urlString = "https://api.openweathermap.org/data/2.5/onecall?q="
                + encodedCity + "&exclude=minutely,hourly,daily,alerts&appid=" + apiKey + "&units=metric";

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
