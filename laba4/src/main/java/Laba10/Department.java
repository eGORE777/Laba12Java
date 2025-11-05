package Laba10;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private int employeeCount;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.employeeCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employeeCount = employees.size();
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employeeCount = employees.size();
    }
}