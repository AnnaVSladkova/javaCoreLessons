package ru.geekbrains.javacore.lesson6;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.javacore.lesson6.model.DailyForecast;
import ru.geekbrains.javacore.lesson6.model.Root;

public class Main {

    public static void main(String... args) {
        String apiKey = "BGE4gagZP8l2mIMnezZq8J1sxnCukFvW";
        String locationId = "5-295212_1_AL";
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
            Root obj = objectMapper.readValue(res, Root.class);
            System.out.println("Погода в городе Санкт-Петербург" );
            for(DailyForecast df: obj.dailyForecasts){
                String row = String.format("Дата %tF, температура %.1f / %.1f, днем %s, ночью %s", df.date, df.temperature.minimum.value, df.temperature.maximum.value, df.day.iconPhrase, df.night.iconPhrase);
                System.out.println(row);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
