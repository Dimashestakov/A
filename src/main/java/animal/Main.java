class Animal {
    private static int count = 0;
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        count++;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}

class Cat extends Animal {
    private static int count = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        count++;
        satiety = false;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            satiety = true;
            System.out.println(getName() + " поел.");
        } else {
            System.out.println(getName() + " не смог поесть.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCount() {
        return count;
    }
}

class Dog extends Animal {
    private static int count = 0;

    public Dog(String name) {
        super(name, 500, 10);
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = Math.max(0, foodAmount);
    }

    public void addFood(int food) {
        if (food > 0) {
            foodAmount += food;
            System.out.println("Добавили в миску " + food + " еды.");
        }
    }

    public boolean decreaseFood(int food) {
        if (foodAmount >= food) {
            foodAmount -= food;
            return true;
        } else {
            System.out.println("В миске недостаточно еды.");
            return false;
        }
    }

    public void info() {
        System.out.println("В миске осталось " + foodAmount + " еды.");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat[] cats = { new Cat("Barsik"), new Cat("Murzik"), new Cat("Whiskas") };
        Bowl bowl = new Bowl(20);

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
            System.out.println(cat.getName() + " сыт: " + cat.isSatiety());
        }

        bowl.info();
        System.out.println("Создано кошек: " + Cat.getCount());
        System.out.println("Создано собак: " + Dog.getCount());
        System.out.println("Создано животных: " + Animal.getCount());
    }
}
