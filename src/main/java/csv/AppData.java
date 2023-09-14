package main.java.csv;
import java.io.*;
import java.util.*;

public class AppData {

    private String[] header;
    private List<int[]> data;

    public AppData(String[] header) {
        this.header = header;
        this.data = new ArrayList<>();
    }

    public String[] getHeader() {
        return header;
    }

    public List<int[]> getData() {
        return data;
    }

    public void addRow(int[] row) {
        data.add(row);
    }

    public void save(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Записываем заголовок
            writer.println(String.join(";", header));

            // Записываем данные
            for (int[] rowData : data) {
                String[] rowStrings = Arrays.stream(rowData)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new);
                writer.println(String.join(";", rowStrings));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String headerLine = reader.readLine();
            header = headerLine.split(";");
            data.clear();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowStrings = line.split(";");
                int[] rowData = new int[header.length];
                for (int i = 0; i < header.length; i++) {
                    rowData[i] = Integer.parseInt(rowStrings[i].trim());
                }
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Пример использования
        String[] headers = {"Value 1", "Value 2", "Value 3"};
        AppData appData = new AppData(headers);

        // Добавляем данные
        appData.addRow(new int[]{100, 200, 123});
        appData.addRow(new int[]{300, 400, 500});

        // Сохраняем данные в файл
        appData.save("data.csv");

        // Загружаем данные из файла
        appData.load("data.csv");

        // Вывод заголовков
        System.out.println("Headers: " + Arrays.toString(appData.getHeader()));

        // Вывод данных
        System.out.println("Data:");
        for (int[] row : appData.getData()) {
            System.out.println(Arrays.toString(row));
        }
    }
}
