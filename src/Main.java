import model.Employee;
import service.EmployeeService;

public class Main {

    public static void main(String[] args) {

        // Initialize service
        EmployeeService service = new EmployeeService();

        // Add employees
        service.addEmployee(new Employee(101, "Drishya Anil", "drishya@company.com", "Engineering", 85000));
        service.addEmployee(new Employee(102, "Rahul Sharma", "rahul@company.com", "HR", 65000));
        service.addEmployee(new Employee(103, "Priya Singh", "priya@company.com", "Finance", 75000));

        // Display all employees
        service.displayAll();

        // Update employee
        service.updateEmployee(101, new Employee(101, "Drishya Anil Updated", "newemail@company.com", "Engineering", 95000));

        // Display after update
        service.displayAll();

        // Search by ID
        Employee found = service.searchById(102);
        if (found != null) {
            System.out.println("Found: " + found);
        }

        // Delete employee
        service.deleteEmployee(103);

        // Display after deletion
        service.displayAll();
    }
}
