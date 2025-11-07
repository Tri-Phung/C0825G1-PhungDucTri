package case_study_accu.view;

import case_study_accu.common.Validate.Validate;
import case_study_accu.controller.WeatherController;
import case_study_accu.entity.CurrentWeather;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    private static WeatherController weatherController = new WeatherController();

    public static void mainMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Weather Pro Max Program");
        String cityName = inputCityName(sc);
        System.out.println("What you want to know:");
        while (true) {
            System.out.println("1. Current weather");
            System.out.println("2. Daily forecast weather");
            System.out.println("3. Re-enter city name");
            System.out.println("0. Exit program");
            int choice = Validate.inputInteger("your choice");
            switch (choice) {
                case 0:
                    System.out.println("Thank you for using our Weather Pro Max Program");
                    return;
                case 1:
                    CurrentWeather[] curr = weatherController.getCurrentWeather(cityName);
                    CurrentWeatherView.displayCurrentWeather(curr);
                    break;
                case 2:
                    DailyForecastView.menuDailyForecast(cityName);
                    break;
                case 3:
                    cityName = inputCityName(sc);
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }

    private static String inputCityName(Scanner sc) {
        System.out.print("Enter the city name: ");
        return sc.nextLine();
    }
}
