package main.java.PhoneBook;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Создаем массив с набором слов
        String[] wordsArray = {
                "apple", "banana", "cherry", "apple", "banana",
                "date", "fig", "cherry", "grape", "apple",
                "grape", "kiwi", "mango", "kiwi", "orange"
        };

        // Находим уникальные слова и их частоту
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : wordsArray) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова:");
        for (String word : wordFrequency.keySet()) {
            System.out.println(word + ": " + wordFrequency.get(word) + " раз");
        }

        // Создаем Телефонный Справочник
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        phoneBook.add("Иванов", "123-456-789");
        phoneBook.add("Петров", "987-654-321");
        phoneBook.add("Сидоров", "555-555-555");
        phoneBook.add("Иванов", "111-222-333");

        // Поиск номеров по фамилии
        System.out.println("\nТелефонный справочник:");
        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров"));
    }
}

class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(lastName, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneBook.put(lastName, numbers);
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }
}
