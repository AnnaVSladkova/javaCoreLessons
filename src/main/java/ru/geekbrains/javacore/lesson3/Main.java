package ru.geekbrains.javacore.lesson3;

public class Main {
    public static void main(String... args){
        Box<Apple> boxApple = new Box<>();
        boxApple.put(new Apple(1.0f));
        boxApple.put(new Apple(1.0f));
        boxApple.put(new Apple(1.0f));

        Box<Orange> boxOrange = new Box<>();
        boxOrange.put(new Orange(1.5f));
        boxOrange.put(new Orange(1.5f));

        boolean compare = boxApple.compare(boxOrange);
        System.out.println("Вес коробок " + (compare ? "одинаковый" : "разный"));

        System.out.println("Содержимое первой коробки с яблоками до пересыпания: " + boxApple);
        Box<Apple> boxApple2 = new Box<>();
        boxApple.moveFruits(boxApple2);

        System.out.println("Содержимое первой коробки с яблоками: " + boxApple);
        System.out.println("Содержимое второй коробки с яблоками: " + boxApple2);
    }
}
