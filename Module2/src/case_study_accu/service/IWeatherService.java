package case_study_accu.service;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IWeatherService {
    String  getLocationKey(String cityName) throws IOException;
}
