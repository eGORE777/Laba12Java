package com.example.domain;

public class Employee {
    private int empId;
    private String name;
    private String ssn;
    private double salary;
    private String Familiya;

    public String getFamiliya() {return Familiya; }

    public String setFamiliya(String Familiya) {this.Familiya = Familiya; return Familiya; }

    public Employee() {}


    public Employee(int empId, String name, String ssn, double salary, String Familiya) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
        this.Familiya = Familiya;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
