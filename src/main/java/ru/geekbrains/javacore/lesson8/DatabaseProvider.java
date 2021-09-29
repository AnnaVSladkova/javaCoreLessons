package ru.geekbrains.javacore.lesson8;

import ru.geekbrains.javacore.lesson8.entity.CurrentWeatherEntity;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProvider implements AutoCloseable {

    private final Connection connection;

    public DatabaseProvider() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
            this.initTableCurrentWeather();
        } catch (Exception ex) {
            throw new RuntimeException("Database init error", ex);
        }
    }

    private void initTableCurrentWeather() {
        String sql = "CREATE TABLE IF NOT EXISTS current_weather (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	localDate text NOT NULL,\n"
                + "	city text NOT NULL,\n"
                + "	weatherText text NOT NULL,\n"
                + "	temperature real\n"
                + ");";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    public void writeWeather(String city, String weatherText, Double temperature) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO current_weather(`localDate`, `city`, `weatherText`, `temperature`) " +
                        "VALUES(?, ?, ?, ?)")) {
            String localDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
            statement.setObject(1, localDate);
            statement.setObject(2, city);
            statement.setObject(3, weatherText);
            statement.setObject(4, temperature);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<CurrentWeatherEntity> readAllDataForCity(String city) {
        List<CurrentWeatherEntity> result = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM current_weather WHERE `city`=?")) {
            statement.setObject(1, city);
            // Выполняем запрос
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new CurrentWeatherEntity(resultSet.getInt("id"),
                        resultSet.getString("localDate"),
                        resultSet.getString("city"),
                        resultSet.getString("weatherText"),
                        resultSet.getDouble("temperature")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
}