package main.java.sumArrayElements;

public class Main {

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArrayElements(validArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных в ячейке: " + e.getMessage());
        }
    }

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер массива
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }

        int sum = 0;

        // Проходим по элементам массива и суммируем их
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    // В случае ошибки преобразования, бросаем исключение MyArrayDataException
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] неверные данные");
                }
            }
        }

        return sum;
    }
}

// Исключение для неправильного размера массива
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

// Исключение для неверных данных в массиве
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}
