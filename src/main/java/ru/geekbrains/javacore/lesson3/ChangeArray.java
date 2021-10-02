package ru.geekbrains.javacore.lesson3;

public class ChangeArray {
    private static Object String;

    public static void main(String[] args) {
        String[] Cat = {"кот Пират", "кот Бегемот", "кот Филипп Бедросович", "кот Фандорин"};
        System.out.println("Список котов:");
        for (String a : Cat) {
            System.out.println(a);
        }

        String Cat1 = Cat[1];
        Cat[1] = Cat[3];
        Cat[3] = Cat1;
        System.out.println("Коты поменялись местами:");
        for (String a : Cat) {
            System.out.println(a);
        }
    }
}
