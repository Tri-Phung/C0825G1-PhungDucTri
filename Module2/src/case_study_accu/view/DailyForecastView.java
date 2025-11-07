package case_study_accu.view;

import case_study_accu.common.Validate.Validate;
import case_study_accu.controller.WeatherController;
import case_study_accu.entity.FiveDayForecast;
import case_study_accu.entity.OneDayForecast;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyForecastView {
    private static WeatherController weatherController = new WeatherController();

    public static void menuDailyForecast(String cityName) throws IOException {
        System.out.println("Which style you want to do forecast?");
        System.out.println("1. One Day Forecast");
        System.out.println("2. Five Day Forecast");
        int choice = Validate.inputInteger("your choice");
        switch (choice) {
            case 1:
                OneDayForecast dataOneDay = weatherController.getOneDayForecast(cityName);
                displayOnedayForeCast(dataOneDay);
                break;
            case 2:
                FiveDayForecast dataFiveDay = weatherController.getFiveDayForecast(cityName);
                displayFiveDayForecast(dataFiveDay);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void displayOnedayForeCast(OneDayForecast forecast) {
        if (forecast == null || forecast.getDailyForecasts() == null || forecast.getDailyForecasts().isEmpty()) {
            System.out.println("❌ Không có dữ liệu dự báo thời tiết!");
            return;
        }

        OneDayForecast.DailyForecast df = forecast.getDailyForecasts().getFirst();

        System.out.println("==========================================");
        System.out.println("🌤️  One Day Forecast");
        System.out.println("==========================================");

        // --- Định dạng ngày ---
        String dateStr = df.getDate();
        String formattedDate = dateStr;
        try {
            LocalDate date = LocalDate.parse(dateStr.substring(0, 10));
            formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM"));
        } catch (Exception ignored) {
        }

        // === PHẦN DAY ===
        System.out.println("☀️  Day [" + formattedDate + "]");
        System.out.printf("🌡️ %.0f°C | RealFeel %.0f°C | RealFeel Shade %.0f°C\n", df.getTemperature().getMaximum().getValue(), df.getRealFeelTemperature().getMaximum().getValue(), df.getRealFeelTemperatureShade().getMaximum().getValue());

        System.out.println(df.getDay().getLongPhrase());

        // --- UV Index ---
        df.getAirAndPollen().stream().filter(a -> a.getName().equalsIgnoreCase("UVIndex")).findFirst().ifPresent(uv -> System.out.printf("🔆 Max UV Index %.1f (%s)\n", (float) uv.getValue(), uv.getCategory()));


        // --- Wind ---
        if (df.getDay().getWind() != null && df.getDay().getWind().getSpeed() != null) {
            System.out.printf("💨 Wind %s %.0f km/h\n", df.getDay().getWind().getDirection().getLocalized(), df.getDay().getWind().getSpeed().getValue());
        }

        if (df.getDay().getWindGust() != null && df.getDay().getWindGust().getSpeed() != null) {
            System.out.printf("💨 Wind Gusts %.0f km/h\n", df.getDay().getWindGust().getSpeed().getValue());
        }

        System.out.printf("\uD83C\uDF27 Probability of Precipitation %d%%\n", df.getDay().getPrecipitationProbability());
        System.out.printf("⛈ Probability of Thunderstorms %d%%\n", df.getDay().getThunderstormProbability());

        if (df.getDay().getTotalLiquid() != null)
            System.out.printf("💧 Precipitation %.1f mm\n", df.getDay().getTotalLiquid().getValue());

        if (df.getDay().getRain() != null)
            System.out.printf("\uD83C\uDF27 Rain %.1f mm\n", df.getDay().getRain().getValue());

        System.out.printf("\uD83D\uDD50 Hours of Precipitation %.0f\n", df.getDay().getHoursOfPrecipitation());
        System.out.printf("\uD83D\uDD50 Hours of Rain %.0f\n", df.getDay().getHoursOfRain());
        System.out.printf("☁️ Cloud Cover %d%%\n", df.getDay().getCloudCover());

        System.out.println("------------------------------------------------------------");

        // === PHẦN NIGHT ===
        System.out.println("🌙  Night [" + formattedDate + "]");
        System.out.printf("🌡️ %.0f°C | RealFeel %.0f°C\n", df.getTemperature().getMinimum().getValue(), df.getRealFeelTemperature().getMinimum().getValue());

        System.out.println(df.getNight().getLongPhrase());

        if (df.getNight().getWind() != null && df.getNight().getWind().getSpeed() != null) {
            System.out.printf("💨 Wind %s %.0f km/h\n", df.getNight().getWind().getDirection().getLocalized(), df.getNight().getWind().getSpeed().getValue());
        }

        if (df.getNight().getWindGust() != null && df.getNight().getWindGust().getSpeed() != null) {
            System.out.printf("💨 Wind Gusts %.0f km/h\n", df.getNight().getWindGust().getSpeed().getValue());
        }

        System.out.printf("\uD83C\uDF27 Probability of Precipitation %d%%\n", df.getNight().getPrecipitationProbability());
        System.out.printf("⛈ Probability of Thunderstorms %d%%\n", df.getNight().getThunderstormProbability());

        if (df.getNight().getTotalLiquid() != null)
            System.out.printf("💧 Precipitation %.1f mm\n", df.getNight().getTotalLiquid().getValue());

        if (df.getNight().getRain() != null)
            System.out.printf("\uD83C\uDF27 Rain %.1f mm\n", df.getNight().getRain().getValue());

        System.out.printf("\uD83D\uDD50 Hours of Precipitation %.0f\n", df.getNight().getHoursOfPrecipitation());
        System.out.printf("\uD83D\uDD50 Hours of Rain %.0f\n", df.getNight().getHoursOfRain());
        System.out.printf("☁️ Cloud Cover %d%%\n", df.getNight().getCloudCover());

        System.out.println("==========================================");
    }

    public static void displayFiveDayForecast(FiveDayForecast forecast) {
        if (forecast == null || forecast.getDailyForecasts() == null || forecast.getDailyForecasts().isEmpty()) {
            System.out.println("❌ Không có dữ liệu dự báo 5 ngày!");
            return;
        }

        System.out.println("==========================================");
        System.out.println("🌤️  5-Day Weather Forecast");
        System.out.println("==========================================");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

        for (FiveDayForecast.DailyForecast df : forecast.getDailyForecasts()) {
            // --- Xử lý ngày ---
            String dateStr = df.getDate();
            String formattedDate = dateStr;
            try {
                LocalDate date = LocalDate.parse(dateStr.substring(0, 10));
                formattedDate = date.format(formatter);
            } catch (Exception ignored) {
            }

            System.out.println("☀️  Day [" + formattedDate + "]");
            System.out.printf("🌡️ %.0f°C | RealFeel %.0f°C | RealFeel Shade %.0f°C\n", df.getTemperature().getMaximum().getValue(), df.getRealFeelTemperature().getMaximum().getValue(), df.getRealFeelTemperatureShade().getMaximum().getValue());

            System.out.println(df.getDay().getLongPhrase());

            // --- UV Index ---
            df.getAirAndPollen().stream().filter(a -> a.getName().equalsIgnoreCase("UVIndex")).findFirst().ifPresent(uv -> System.out.printf("🔆 Max UV Index %.1f (%s)\n", (float) uv.getValue(), uv.getCategory()));


            // --- Wind ---
            if (df.getDay().getWind() != null && df.getDay().getWind().getSpeed() != null) {
                System.out.printf("💨 Wind %s %.0f km/h\n", df.getDay().getWind().getDirection().getLocalized(), df.getDay().getWind().getSpeed().getValue());
            }

            if (df.getDay().getWindGust() != null && df.getDay().getWindGust().getSpeed() != null) {
                System.out.printf("💨 Wind Gusts %.0f km/h\n", df.getDay().getWindGust().getSpeed().getValue());
            }

            System.out.printf("\uD83C\uDF27 Probability of Precipitation %d%%\n", df.getDay().getPrecipitationProbability());
            System.out.printf("⛈ Probability of Thunderstorms %d%%\n", df.getDay().getThunderstormProbability());

            if (df.getDay().getTotalLiquid() != null)
                System.out.printf("💧 Precipitation %.1f mm\n", df.getDay().getTotalLiquid().getValue());

            if (df.getDay().getRain() != null)
                System.out.printf("\uD83C\uDF27 Rain %.1f mm\n", df.getDay().getRain().getValue());
            System.out.printf("\uD83D\uDD50 Hours of Rain %.0f\n", df.getDay().getHoursOfRain());
            System.out.printf("☁️ Cloud Cover %d%%\n", df.getDay().getCloudCover());

            System.out.println("------------------------------------------------------------");

            // === PHẦN NIGHT ===
            System.out.println("🌙  Night [" + formattedDate + "]");
            System.out.printf("🌡️ %.0f°C | RealFeel %.0f°C\n", df.getTemperature().getMinimum().getValue(), df.getRealFeelTemperature().getMinimum().getValue());

            System.out.println(df.getNight().getLongPhrase());

            if (df.getNight().getWind() != null && df.getNight().getWind().getSpeed() != null) {
                System.out.printf("💨 Wind %s %.0f km/h\n", df.getNight().getWind().getDirection().getLocalized(), df.getNight().getWind().getSpeed().getValue());
            }

            if (df.getNight().getWindGust() != null && df.getNight().getWindGust().getSpeed() != null) {
                System.out.printf("💨 Wind Gusts %.0f km/h\n", df.getNight().getWindGust().getSpeed().getValue());
            }

            System.out.printf("\uD83C\uDF27 Probability of Precipitation %d%%\n", df.getNight().getPrecipitationProbability());
            System.out.printf("⛈ Probability of Thunderstorms %d%%\n", df.getNight().getThunderstormProbability());

            if (df.getNight().getTotalLiquid() != null)
                System.out.printf("💧 Precipitation %.1f mm\n", df.getNight().getTotalLiquid().getValue());

            if (df.getNight().getRain() != null)
                System.out.printf("\uD83C\uDF27 Rain %.1f mm\n", df.getNight().getRain().getValue());
            System.out.printf("\uD83D\uDD50 Hours of Rain %.0f\n", df.getNight().getHoursOfRain());
            System.out.printf("☁️ Cloud Cover %d%%\n", df.getNight().getCloudCover());

            System.out.println("==========================================");
        }
    }
}
