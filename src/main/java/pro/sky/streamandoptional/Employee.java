package pro.sky.streamandoptional;

import java.util.Objects;

public class Employee {

    private static int count;
    private final String surname;
    private final String name;

    private int departmentId;

    private int salary;

    public String getFullName() {
        return name + " " + surname;
    }


    public Employee(String surname, String name, int departmentId, int salary) {
        this.surname = surname;
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }


    public static int getCount() {
        return count;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник " + " - " +
                "Фамилия: " + surname +
                " Имя: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(surname, employee.surname) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }


    private String validateSurname(String surname) {
        return surname == null ? "WithoutSurname" : surname;
    }

    private String validateName(String name) {
        return name == null ? "WithoutName" : name;
    }

}
