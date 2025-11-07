package case_study_accu.view;

import case_study_accu.entity.CurrentWeather;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentWeatherView {
    public static void displayCurrentWeather(CurrentWeather[] weathers) throws IOException {
        if (weathers == null) {
            System.out.println("⚠️Không thể hiển thị thông tin thời tiết.");
            return;
        }
        CurrentWeather weather = weathers[0];
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String dateTime = now.format(formatter);
        String weatherText = weather.getWeatherText();
        String uv = String.format("%.1f (%s)", weather.getUVIndexFloat(), weather.getUVIndexText());
        String wind = String.format("%s %s %.1f %s", getWindArrow(weather.getWind().getDirection().getDegrees()), weather.getWind().getDirection().getEnglish(), weather.getWind().getSpeed().getMetric().getValue(), weather.getWind().getSpeed().getMetric().getUnit());
        String windGust = String.format("%.1f %s", weather.getWindGust().getSpeed().getMetric().getValue(), weather.getWindGust().getSpeed().getMetric().getUnit());
        String humidity = weather.getRelativeHumidity() + "%";
        String indoorHumidity = String.format("%d%% (%s)", weather.getIndoorRelativeHumidity(), getHumidityLevel(weather.getIndoorRelativeHumidity()));
        String dewPoint = String.format("%.1f°%s", weather.getDewPoint().getMetric().getValue(), weather.getDewPoint().getMetric().getUnit());
        String pressure = String.format("%s %.0f %s", getPressureTrendSymbol(weather.getPressureTendency().getCode()), weather.getPressure().getMetric().getValue(), weather.getPressure().getMetric().getUnit());
        String cloudCover = weather.getCloudCover() + "%";
        String visibility = String.format("%.1f %s", weather.getVisibility().getMetric().getValue(), weather.getVisibility().getMetric().getUnit());
        String ceiling = String.format("%.0f %s", weather.getCeiling().getMetric().getValue(), weather.getCeiling().getMetric().getUnit());
        System.out.println("============================================");
        System.out.println("Current Weather [⏰ " + dateTime + "]");
        System.out.println("--------------------------------------------");
        System.out.printf("🌡️  %.1f°C | RealFeel: %.1f°C | RealFeel Shade: %.1f°C%n", weather.getTemperature().getMetric().getValue(), weather.getRealFeelTemperature().getMetric().getValue(), weather.getRealFeelTemperatureShade().getMetric().getValue());
        System.out.println("☁️  " + weatherText);
        System.out.println();
        System.out.println("🔆 Max UV Index: " + uv);
        System.out.println("💨 Wind: " + wind);
        System.out.println("💨 Wind Gusts: " + windGust);
        System.out.println("💧 Humidity: " + humidity);
        System.out.println("🏠 Indoor Humidity: " + indoorHumidity);
        System.out.println("💧 Dew Point: " + dewPoint);
        System.out.println("🔽 Pressure: " + pressure);
        System.out.println("☁️  Cloud Cover: " + cloudCover);
        System.out.println("👁️  Visibility: " + visibility);
        System.out.println("☁️  Cloud Ceiling: " + ceiling);
        System.out.println("============================================");
    }

    private String formatLocalTime(String time) {
        try {
            ZonedDateTime zoned = ZonedDateTime.parse(time);
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return zoned.format(fmt);
        } catch (Exception e) {
            return time;
        }
    }

    private static String getPressureTrendSymbol(String code) {
        if (code == null) return "→";
        return switch (code) {
            case "F" -> "↓";
            case "R" -> "↑";
            default -> "→";
        };
    }

    private static String getHumidityLevel(int humidity) {
        if (humidity < 30) return "Dry";
        if (humidity < 60) return "Comfortable";
        if (humidity < 80) return "Humid";
        return "Extremely Humid";
    }

    private static String getWindArrow(int degree) {
        if (degree >= 337.5 || degree < 22.5) return "↑";
        if (degree < 67.5) return "↗";
        if (degree < 112.5) return "→";
        if (degree < 157.5) return "↘";
        if (degree < 202.5) return "↓";
        if (degree < 247.5) return "↙";
        if (degree < 292.5) return "←";
        return "↖";
    }
}
