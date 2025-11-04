package case_study;

import case_study.entity.WeatherResponse;
import case_study.service.WeatherService;
import case_study.view.ConsoleView;

import java.util.Scanner;

public class AppWeatherProMax {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        WeatherService service = new WeatherService();
        ConsoleView view = new ConsoleView();

        while (true) {
            System.out.print("Nhập tên thành phố: ");
            String city = scanner.nextLine();

            if (city.equalsIgnoreCase("exit")) {
                System.out.println("Thoát chương trình...");
                break;
            }

            WeatherResponse data = service.getWeatherByCity(city);
            view.displayWeather(data);
            System.out.println();
        }
        scanner.close();
    }
}
