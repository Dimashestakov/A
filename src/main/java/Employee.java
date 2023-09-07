public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Николай", "Врач", "11@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Петров Василий", "Пилот", "22@mailbox.com", "891212312", 40000, 45);
        employees[2] = new Employee("Сидоров Максим", "Программист", "33@mailbox.com", "893312312", 50000, 28);
        employees[3] = new Employee("Козлов Альберт", "Дизайнер", "44@mailbox.com", "894412312", 35000, 38);
        employees[4] = new Employee("Бурак Алексей", "Водитель", "55@mailbox.com", "895512312", 45000, 50);

        System.out.println("Информация о сотрудниках старше 40 лет:");
        for (Employee employee : employees) {
            if (employee.age > 40) {
                employee.printInfo();
            }
        }
    }
}

class Park {
    class Attraction {
        private String name;
        private String workingHours;
        private int cost;

        public Attraction(String name, String workingHours, int cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }
    }
}
