import java.util.Arrays;

public class Main {
    private static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        employees[0] = new Employee("Иван", "Иванов", "Иванович", 1, 50_000);
        employees[1] = new Employee("Мария", "Петрова", "Игоревна", 2, 70_000);
        employees[2] = new Employee("Сергей", "Сергеев", "Сергеевич", 3, 90_000);
        employees[3] = new Employee("Анна", "Смирнова", "Анатольевна", 4, 60_000);
        employees[4] = new Employee("Алексей", "Васильев", "Васильевич", 5, 100_000);

        printAllEmployees();
        System.out.println("Сумма зарплат: " + calculateTotalSalary());
        findMinSalaryEmployee();
        findMaxSalaryEmployee();
        System.out.println("Средняя зарплата: " + averageSalary());
        printFullNames();
    }

    public static void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public static double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static void findMinSalaryEmployee() {
        Employee minSalaryEmployee = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        if (minSalaryEmployee != null) {
            System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee.toString());
        } else {
            System.out.println("Сотрудники отсутствуют.");
        }
    }

    public static void findMaxSalaryEmployee() {
        Employee maxSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        if (maxSalaryEmployee != null) {
            System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee.toString());
        } else {
            System.out.println("Сотрудники отсутствуют.");
        }
    }

    public static double averageSalary() {
        double sumOfSalaries = calculateTotalSalary();
        int numberOfEmployees = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                numberOfEmployees++;
            }
        }
        return numberOfEmployees > 0 ? sumOfSalaries / numberOfEmployees : 0;
    }

    public static void printFullNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFirstName() + " " + employee.getName() + " " + employee.getFirstName());
            }
        }
    }
}
