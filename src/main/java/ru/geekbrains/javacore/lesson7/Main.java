package ru.geekbrains.javacore.lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.javacore.lesson7.model.DailyForecast;
import ru.geekbrains.javacore.lesson7.model.WeatherResponse;

public class Main {

    public static void main(String... args) {
        String apiKey = "BGE4gagZP8l2mIMnezZq8J1sxnCukFvW";
        String locationId = "5-295212_1_AL";
        String city = "Санкт-Петербург";
        StringBuilder url = new StringBuilder()
                .append("http://dataservice.accuweather.com/forecasts/v1/daily/5day/")
                .append(locationId)
                .append("?apikey=").append(apiKey)
                .append("&language=ru-ru")
                .append("&metric=true");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url.toString())
                .build();

        try (Response response = client.newCall(request).execute()) {
            String res = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse obj = objectMapper.readValue(res, WeatherResponse.class);
            System.out.println("Погода в городе Санкт-Петербург" );
            for(DailyForecast df: obj.dailyForecasts){
                String row  = String.format("| В городе %s на дату %tF ожидается днем %s, ночью %s, температура %.1f / %.1f |", city, df.date, df.day.iconPhrase, df.night.iconPhrase, df.temperature.minimum.value, df.temperature.maximum.value);
                //String row = String.format("Дата %tF, температура %.1f / %.1f, днем %s, ночью %s", df.date, df.temperature.minimum.value, df.temperature.maximum.value, df.day.iconPhrase, df.night.iconPhrase);
                System.out.println(row);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
