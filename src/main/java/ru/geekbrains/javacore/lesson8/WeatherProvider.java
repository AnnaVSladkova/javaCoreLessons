package ru.geekbrains.javacore.lesson8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.javacore.lesson7.model.DailyForecast;
import ru.geekbrains.javacore.lesson7.model.WeatherResponse;
import ru.geekbrains.javacore.lesson8.model.City;
import ru.geekbrains.javacore.lesson8.model.CurrentCondition;

import java.io.IOException;
import java.util.List;

public class WeatherProvider {
    private final static String API_KEY = "BGE4gagZP8l2mIMnezZq8J1sxnCukFvW";
    private final static String SERVER_NAME = "http://dataservice.accuweather.com";

    public City findCityLication(String cityName) {
        StringBuilder url = new StringBuilder()
                .append(SERVER_NAME)
                .append("/locations/v1/cities/autocomplete/")
                .append("?apikey=").append(API_KEY)
                //.append("&language=ru-ru")
                .append("&q=").append(cityName);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .addHeader("accept", "application/json")
                .url(url.toString())
                .build();
        try (Response response = client.newCall(request).execute()) {
            String res = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            List<City> cities = objectMapper.readValue(res, new TypeReference<List<City>>() {
            });
            if (cities == null || cities.size() == 0)
                throw new RuntimeException("'" + cityName + "' не известный город");
            return cities.stream().findFirst().orElse(null);
        } catch (IOException ex) {
            throw new RuntimeException("Unknown error", ex);
        }
    }

    public CurrentCondition getCurrent(City city) {
        String locationId = city.key;
        StringBuilder url = new StringBuilder()
                .append(SERVER_NAME)
                .append("/currentconditions/v1/")
                .append(locationId)
                .append("?apikey=").append(API_KEY)
                .append("&language=ru-ru")
                .append("&metric=true");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .addHeader("accept", "application/json")
                .url(url.toString())
                .build();
        try (Response response = client.newCall(request).execute()) {
            String res = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            List<CurrentCondition> result = objectMapper.readValue(res, new TypeReference<List<CurrentCondition>>() {            });
            if(result==null || result.size()==0 ) throw new RuntimeException("Информация не найдена");
            return result.get(0);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            throw new RuntimeException(ex);
        }

    }

    public WeatherResponse get5Days(City city) {
        String locationId = city.key;
        //String locationId = "5-295212_1_AL";
        StringBuilder url = new StringBuilder()
                .append(SERVER_NAME)
                .append("/forecasts/v1/daily/5day/")
                .append(locationId)
                .append("?apikey=").append(API_KEY)
                .append("&language=ru-ru")
                .append("&metric=true");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .addHeader("accept", "application/json")
                .url(url.toString())
                .build();
        try (Response response = client.newCall(request).execute()) {
            String res = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(res, WeatherResponse.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            throw new RuntimeException(ex);
        }
    }
}
