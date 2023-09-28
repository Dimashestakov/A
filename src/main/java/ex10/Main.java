package main.java.ex10;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    public Apple() {
        super(1.0f);
    }
}

class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }
}

class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

    public void transferFruitsTo(Box<T> otherBox) {
        if (this == otherBox) {
            return; // Нельзя пересыпать фрукты из коробки в саму себя
        }
        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками 1: " + appleBox1.getWeight());
        System.out.println("Вес коробки с яблоками 2: " + appleBox2.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("Сравнение коробок с яблоками 1 и 2: " + appleBox1.compare(appleBox2));
        System.out.println("Сравнение коробок с яблоками 1 и апельсинами: " + appleBox1.compare(orangeBox));

        appleBox1.transferFruitsTo(appleBox2);

        System.out.println("Вес коробки с яблоками 1 после пересыпки: " + appleBox1.getWeight());
        System.out.println("Вес коробки с яблоками 2 после пересыпки: " + appleBox2.getWeight());
    }
}
