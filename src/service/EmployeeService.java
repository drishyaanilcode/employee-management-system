package service;

import model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    public void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n=== Employee List ===");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
