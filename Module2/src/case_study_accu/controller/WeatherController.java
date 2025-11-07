package case_study_accu.controller;

import case_study_accu.entity.CurrentWeather;
import case_study_accu.entity.FiveDayForecast;
import case_study_accu.entity.OneDayForecast;
import case_study_accu.service.*;

import java.io.IOException;

public class WeatherController {
    private ICurrentWeatherService iCurrentService = new CurrentService();
    private IDailyForecastService iDailyForecastService;
    public CurrentWeather[] getCurrentWeather(String cityName) throws IOException {
        return iCurrentService.getCurrentWeather(cityName);
    }
    public OneDayForecast getOneDayForecast(String cityName) throws IOException {
        iDailyForecastService = new OneDayService();
        return (OneDayForecast) iDailyForecastService.getWeather(cityName);
    }
    public FiveDayForecast getFiveDayForecast(String cityName) throws IOException {
        iDailyForecastService = new FiveDayService();
        return (FiveDayForecast) iDailyForecastService.getWeather(cityName);
    }
}
