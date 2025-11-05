package Laba10;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {

        if (name == null) {
            throw new NullPointerException("Название компании не может быть null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название компании не может быть пустым");
        }
        this.name = name.trim();
        this.departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null) {
            throw new NullPointerException("Название компании не может быть null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название компании не может быть пустым");
        }
        this.name = name.trim();
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }
}