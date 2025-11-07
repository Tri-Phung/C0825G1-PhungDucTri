package case_study_accu.service;

import case_study_accu.entity.CurrentWeather;

import java.io.IOException;

public interface ICurrentWeatherService extends IWeatherService {
    CurrentWeather[] getCurrentWeather(String cityName) throws IOException;
}
