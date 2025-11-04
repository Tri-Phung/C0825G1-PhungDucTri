package case_study.view;

import case_study.entity.Weather;
import case_study.entity.WeatherResponse;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ConsoleView {
    public void displayWeather(WeatherResponse weather) {
        if (weather == null) {
            System.out.println("Không thể lấy dữ liệu thời tiết.");
            return;
        }

        ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(weather.getTimezone());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter updateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Chuyển timestamp sang LocalDateTime theo timezone của thành phố
        LocalDateTime sunrise = Instant.ofEpochSecond(weather.getSys().getSunrise())
                .atOffset(zoneOffset)
                .toLocalDateTime();

        LocalDateTime sunset = Instant.ofEpochSecond(weather.getSys().getSunset())
                .atOffset(zoneOffset)
                .toLocalDateTime();

        LocalDateTime updatedAt = Instant.ofEpochSecond(weather.getDt())
                .atOffset(zoneOffset)
                .toLocalDateTime();

        // In ra console
        System.out.println("===== THỜI TIẾT HIỆN TẠI =====");
        System.out.printf("Địa điểm: %s, %s (Lat: %.4f, Lon: %.4f)%n",
                weather.getName(),
                weather.getSys().getCountry(),
                weather.getCoord().getLat(),
                weather.getCoord().getLon());

        // weather là một list — lấy phần tử đầu tiên
        if (weather.getWeather() != null && !weather.getWeather().isEmpty()) {
            Weather w = weather.getWeather().get(0);
            System.out.printf("Thời tiết: %s - %s%n", w.getMain(), w.getDescription());
        }

        System.out.printf("🌡  Nhiệt độ: %.1f°C (Cảm giác: %.1f°C)%n",
                weather.getMain().getTemp(),
                weather.getMain().getFeels_like());

        System.out.printf("⬆️  Cao nhất: %.1f°C | ⬇️  Thấp nhất: %.1f°C%n",
                weather.getMain().getTemp_max(),
                weather.getMain().getTemp_min());

        System.out.printf("💧  Độ ẩm: %d%% | Áp suất: %d hPa%n",
                weather.getMain().getHumidity(),
                weather.getMain().getPressure());

        System.out.printf("🌬  Gió: %.2f m/s, Hướng: %d°, Giật: %.2f m/s%n",
                weather.getWind().getSpeed(),
                weather.getWind().getDeg(),
                weather.getWind().getGust());

        System.out.printf("☁️  Mây che phủ: %d%%%n", weather.getClouds().getAll());
        System.out.printf("👁  Tầm nhìn: %,d m%n", weather.getVisibility());

        System.out.printf("🌅  Mặt trời mọc: %s | 🌇  Lặn: %s%n",
                sunrise.format(formatter),
                sunset.format(formatter));

        System.out.printf("🕒  Cập nhật: %s (Giờ địa phương)%n",
                updatedAt.format(updateFormatter));

        System.out.println("===============================");
    }
}
