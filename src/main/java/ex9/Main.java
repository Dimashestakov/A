package main.java.ex9;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Задача 1: Определение количества четных чисел в случайно сгенерированном наборе чисел
        int[] numbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Генерируем числа от 0 до 99
        }

        int evenCount = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            }
        }

        System.out.println("Задача 1:");
        System.out.println("Сгенерированный набор чисел: " + Arrays.toString(numbers));
        System.out.println("Количество четных чисел: " + evenCount);

        // Задача 2: Манипуляции с коллекцией строк
        List<String> collection = new ArrayList<>();
        collection.add("Highload");
        collection.add("High");
        collection.add("Load");
        collection.add("Highload");

        int highCount = Collections.frequency(collection, "High"); // 2.1
        String firstElement = collection.isEmpty() ? "0" : collection.get(0); // 2.2
        String lastElement = collection.isEmpty() ? "0" : collection.get(collection.size() - 1); // 2.3

        System.out.println("\nЗадача 2:");
        System.out.println("Количество 'High' в коллекции: " + highCount);
        System.out.println("Первый элемент коллекции: " + firstElement);
        System.out.println("Последний элемент коллекции: " + lastElement);

        // Задача 3: Сортировка строк и добавление их в массив
        List<String> strings = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        strings.sort(String::compareTo); // Сортировка

        String[] sortedArray = strings.toArray(new String[0]); // Преобразование в массив

        System.out.println("\nЗадача 3:");
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));
    }
}
