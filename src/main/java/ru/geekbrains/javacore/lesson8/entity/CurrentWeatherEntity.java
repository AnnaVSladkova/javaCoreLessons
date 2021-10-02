package ru.geekbrains.javacore.lesson8.entity;

public class CurrentWeatherEntity {
    public Integer id;
    public String localDate;
    public String city;
    public String weather;
    public Double temperature;

    public CurrentWeatherEntity(Integer id, String localDate, String city, String weather, Double temperature) {
        this.id = id;
        this.localDate = localDate;
        this.city = city;
        this.weather = weather;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Дата='" + localDate + '\'' +
                ", Город='" + city + '\'' +
                ", Погода='" + weather + '\'' +
                ", Температура=" + temperature;
    }
}
