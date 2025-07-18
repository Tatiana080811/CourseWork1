import java.util.Arrays;

public class Main {
    private static Employee[] employees = new Employee[10];
    public static void printAllEmployees() {
        for (Employee emp : employees) {
            if (emp != null) System.out.println(emp.toString());
        }
    }
    public static double calculateTotalSalaries() {
        double total = 0;
        for (Employee emp : employees) {
            if (emp != null) total += emp.getSalary();
        }
        return total;
    }


    public static Employee findMinSalaryEmployee() {
        Employee minEmp = null;
        for (Employee emp : employees) {
            if (emp != null && (minEmp == null || emp.getSalary() < minEmp.getSalary())) {
                minEmp = emp;
            }
        }
        return minEmp;
    }
    public static Employee findMaxSalaryEmployee() {
        Employee maxEmp = null;
        for (Employee emp : employees) {
            if (emp != null && (maxEmp == null || emp.getSalary() > maxEmp.getSalary())) {
                maxEmp = emp;
            }
        }
        return maxEmp;
    }
    public static double averageSalary() {
        double sum = calculateTotalSalaries(); // Используем ранее созданный метод
        long count = Arrays.stream(employees).filter(e -> e != null).count();

        return count > 0 ? sum / count : 0;
    }
    public static void printFullNames() {
        for (Employee emp : employees) {
            if (emp != null) System.out.println(emp.getFirstName() + " " + emp.getLastName());
        }
    }

    public static void main(String[] args) {
        employees[0] = new Employee("Иван", "Иванов", 1, 80_000);
        employees[1] = new Employee("Сергей", "Сергеев", 2, 90_000);
        employees[2] = new Employee("Алексей", "Алексеев", 3, 100_000);
        employees[3] = new Employee("Дмитрий", "Дмитриев", 4, 70_000);
        employees[4] = new Employee("Михаил", "Михайлов", 5, 110_000);

        System.out.println("\nСписок всех сотрудников:");
        printAllEmployees();

        System.out.println("\nСумма расходов на зарплаты: " + calculateTotalSalaries());

        Employee minSalaryEmp = findMinSalaryEmployee();
        if (minSalaryEmp != null) {
            System.out.println("\nМинимальная зарплата у сотрудника: " + minSalaryEmp.getFirstName() + " " + minSalaryEmp.getLastName());
        }

        Employee maxSalaryEmp = findMaxSalaryEmployee();
        if (maxSalaryEmp != null) {
            System.out.println("\nМаксимальная зарплата у сотрудника: " + maxSalaryEmp.getFirstName() + " " + maxSalaryEmp.getLastName());
        }

        System.out.println("\nСредняя зарплата: " + averageSalary());

        System.out.println("\nФИО всех сотрудников:");
        printFullNames();
    }
}


