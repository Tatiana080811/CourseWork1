import java.util.Objects;
public class Employee {
    private static int nextId = 1;

    private final int id;
    private String firstName;
    private String lastName;
    private int department;
    private double salary;

    public Employee(String firstName, String lastName, int department, double salary) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        setDepartment(department);
        setSalary(salary);
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отдел должен быть между 1 и 5");
        }
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата должна быть положительной величиной");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return id == other.id &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                department == other.department &&
                Double.compare(other.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, department, salary);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", ФИО: " + firstName + ' ' + lastName +
                ", Отдел: " + department +
                ", Зарплата: " + salary;
    }
}