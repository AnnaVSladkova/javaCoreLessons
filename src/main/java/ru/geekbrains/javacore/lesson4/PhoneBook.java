package ru.geekbrains.javacore.lesson4;

import java.util.*;

public class PhoneBook {
    private Map<String, String> phones = new HashMap<>();

    public void add(String phoneNumb, String name) {
        phones.put(phoneNumb, name);
    }

    public List<String> get(String name) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            if (entry.getValue() == name) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
