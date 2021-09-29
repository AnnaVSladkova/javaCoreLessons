package ru.geekbrains.javacore.lesson2;
public class Method {

        public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
                int count = 0;
                if (arr.length != 4) {
                        throw new MyArraySizeException();
                }
                for (int i = 0; i < arr.length; i++) {
                        if (arr[i].length != 4) {
                                throw new MyArraySizeException();
                        }
                }
                // второе задание
                int summ=0;
                for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[i].length; j++) {
                                try {
                                        summ += Integer.parseInt(arr[i][j]);
                                } catch (NumberFormatException e) {
                                        String message = "В ячейке "+i+","+j+" элемент массива преобразовать в целое число не удалось";
                                        throw new MyArrayDataException(message);
                                }
                        }
                }

                return summ;

        }
}
