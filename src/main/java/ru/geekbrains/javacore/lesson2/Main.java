package ru.geekbrains.javacore.lesson2;

public class Main {

    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "k"}};
        try {
            int result = Method.method(arr);
            System.out.println(result);
        } catch (MyArraySizeException e) {
            System.out.println("Неправильный размер массива!");
        } catch (MyArrayDataException e) {
           System.out.println(e.getMessage());
        }


    }
}
