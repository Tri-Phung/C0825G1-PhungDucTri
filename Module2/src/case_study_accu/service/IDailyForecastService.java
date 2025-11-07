package case_study_accu.service;

import java.io.IOException;

public interface IDailyForecastService<T> extends IWeatherService{
    T getWeather(String cityName) throws IOException;
}
