package main.java.shape;

// Интерфейс для фигур
interface Shape {
    double getPerimeter();
    double getArea();
    void setFillColor(String color);
    void setBorderColor(String color);
}

// Класс для круга
class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void setFillColor(String color) {
        fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        borderColor = color;
    }

    public String toString() {
        return "Фигура: Круг\n" +
                "Периметр: " + getPerimeter() + "\n" +
                "Площадь: " + getArea() + "\n" +
                "Цвет фона: " + fillColor + "\n" +
                "Цвет границы: " + borderColor;
    }
}

// Класс для прямоугольника
class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void setFillColor(String color) {
        fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        borderColor = color;
    }

    public String toString() {
        return "Фигура: Прямоугольник\n" +
                "Периметр: " + getPerimeter() + "\n" +
                "Площадь: " + getArea() + "\n" +
                "Цвет фона: " + fillColor + "\n" +
                "Цвет границы: " + borderColor;
    }
}

// Класс для треугольника
class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public void setFillColor(String color) {
        fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        borderColor = color;
    }

    public String toString() {
        return "Фигура: Треугольник\n" +
                "Периметр: " + getPerimeter() + "\n" +
                "Площадь: " + getArea() + "\n" +
                "Цвет фона: " + fillColor + "\n" +
                "Цвет границы: " + borderColor;
    }
}

public class Main {
    public static void main(String[] args) {
        // Пример использования
        Circle circle = new Circle(5);
        circle.setFillColor("Красный");
        circle.setBorderColor("Черный");
        System.out.println(circle.toString());

        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.setFillColor("Синий");
        rectangle.setBorderColor("Зеленый");
        System.out.println(rectangle.toString());

        Triangle triangle = new Triangle(3, 4, 5);
        triangle.setFillColor("Желтый");
        triangle.setBorderColor("Фиолетовый");
        System.out.println(triangle.toString());
    }
}
