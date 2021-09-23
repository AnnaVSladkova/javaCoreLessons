package ru.geekbrains.javacore.lesson4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("красный");
        list.add("синий");
        list.add("зелёный");
        list.add("фиолетовый");
        list.add("жёлтый");
        list.add("белый");
        list.add("белый");
        list.add("голубой");
        list.add("оранжевый");
        list.add("красный");
        list.add("чёрный");
        list.add("синий");
        list.add("коричневый");
        list.add("розовый");
        list.add("белый");
        System.out.println("Полный массив: " + list);

        Set<String> set = new HashSet<>(list);
        System.out.println("Список уникальных значений: " + set);

        Map<String, Integer> yy = new HashMap<>();
        for (String x : list) {
            if (yy.containsKey(x)) {
                int y = yy.get(x);
                yy.replace(x, y + 1);
            } else {
                yy.put(x, 1);
            }
        }
        System.out.println("Статистика повторов: " + yy);

        PhoneBook pb= new PhoneBook();
        pb.add("7878","Igor");
        pb.add("7788","Elena");
        pb.add("7432","Pol");
        pb.add("7331","Fedya");
        pb.add("7090","Ulia");
        pb.add("7111","Vasya");
        pb.add("7211","Den");
        pb.add("7777","Vova");
        pb.add("7567","Igor");
        pb.add("7911","Elena");
        pb.add("7560","Sofia");
        System.out.println("Список телефонов Игоря " + pb.get("Igor"));
    }

}
