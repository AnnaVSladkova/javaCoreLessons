package ru.geekbrains.javacore.lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.javacore.lesson7.model.DailyForecast;
import ru.geekbrains.javacore.lesson7.model.WeatherResponse;
import ru.geekbrains.javacore.lesson8.entity.CurrentWeatherEntity;
import ru.geekbrains.javacore.lesson8.model.City;
import ru.geekbrains.javacore.lesson8.model.CurrentCondition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        WeatherProvider weatherProvider = new WeatherProvider();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите название города на английском языке");
                String city = scanner.nextLine();

                City cityLication = weatherProvider.findCityLication(city);
                System.out.println("Найден город " + cityLication.localizedName + " в стране " + cityLication.country.localizedName);

                System.out.println("Введите ответ: 1 - Получить текущую погоду, " +
                        "2 - Получить погоду на следующие 5 дней, " +
                        "3 - Прочитать все данные из БД, " +
                        "выход (exit) - завершить работу");
                String result = scanner.nextLine();
                switch (result) {
                    case "1":
                        CurrentCondition obj1 = weatherProvider.getCurrent(cityLication);
                        System.out.println(String.format("Текущая погода: %s, температура %.1f %s", obj1.weatherText, obj1.temperature.metric.value, obj1.temperature.metric.unit));
                        try (DatabaseProvider data = new DatabaseProvider()) {
                            data.writeWeather(cityLication.localizedName, obj1.weatherText, obj1.temperature.metric.value);
                        }
                        break;
                    case "2":
                        WeatherResponse obj2 = weatherProvider.get5Days(cityLication);
                        System.out.println("Прогноз погоды на 5 дней");
                        for (DailyForecast df : obj2.dailyForecasts) {
                            String row = String.format("| В городе %s на дату %tF ожидается днем %s, ночью %s, температура %.1f / %.1f |", city, df.date, df.day.iconPhrase, df.night.iconPhrase, df.temperature.minimum.value, df.temperature.maximum.value);
                            System.out.println(row);
                        }
                        break;
                    case "3":
                        System.out.println("Архивные данные по городу " + city);
                        try (DatabaseProvider data = new DatabaseProvider()) {
                            List<CurrentWeatherEntity> currentWeatherEntities = data.readAllDataForCity(city);
                            if (currentWeatherEntities.isEmpty()) System.out.println("Данные отсутствуют");
                            currentWeatherEntities.stream().forEach(System.out::println);
                        }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
