package service;

import model.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee searchById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee ID not found.");
    }
    // Display all employees in the list
    public void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
    public List<Employee> searchByName(String name) {
        return employees.stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
    public List<Employee> searchByDept(String dept) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(dept))
                .toList();
    }

    public void updateEmployee(int id, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, updatedEmployee);
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee ID not found.");
    }

    // Save all employees to a CSV file
    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            // Write CSV header
            writer.write("ID,Name,Department,Salary\n");

            for (Employee emp : employees) {
                writer.write(emp.getId() + ","
                        + emp.getName() + ","
                        + emp.getDepartment() + ","
                        + emp.getSalary() + "\n");
            }

            System.out.println("Employees saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
