import java.util.Objects;

public class Employee {

    private String name;
    private String firstName;
    private String sureName;
    private int department;
    private double salary;
    private int id;

    private static int counter = 1;
    public String Employee(String name, String firstName, String sureName, int department, double salary) {
        this.name = name;
        this.firstName = firstName;
        this.sureName = sureName;
        if (department < 1 || department > 5)
            throw new IllegalArgumentException("Отдел должен быть числом от 1 до 5");
        this.department = department;
        this.salary = salary;
        this.id = counter++;
        return name;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getName() {
        return name;
    }
    public String getSureName() {
        return sureName;
    }
    public double getSalary() {
        return salary;
    }
    public int getDepartment() {
        return department;
    }
    public int getId() {
        return id;
    }

    public void setSalary (int department) {
        if (department < 1 || department > 5)
            throw new IllegalArgumentException("Отдел должен быть числом от 1 до 5");
        this.department = department;
    }
    public void setSalary(double salary) {
        if (salary <= 0)
            throw new IllegalArgumentException("Зарплата должна быть положительным числом");
        this.salary = salary;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return Objects.equals(firstName, other.firstName) &&
                Objects.equals(name, other.name) &&
                Objects.equals(sureName, other.sureName) &&
                department == other.department &&
                Double.compare(salary, other.salary) == 0;
    }
    public int hashCode() {
        return Objects.hash(firstName, name, sureName, department, salary);
    }

    public String toString() {
        return "ID: " + id + ", ФИО: " + firstName + ' ' + name + sureName + ", отдел: " + department +
                ", зарплата: " + salary;
    }
}





