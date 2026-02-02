import model.Employee;
import service.EmployeeService;

public class Main {

    public static void main(String[] args) {

        // Initialize service
        EmployeeService service = new EmployeeService();
        String fileName = "employees.csv";

        // Add employees
        service.addEmployee(new Employee(101, "Drishya Anil", "drishya@company.com", "Engineering", 85000));
        service.addEmployee(new Employee(102, "Rahul Sharma", "rahul@company.com", "HR", 65000));
        service.addEmployee(new Employee(103, "Priya Singh", "priya@company.com", "Finance", 75000));

        // 2. Display
        System.out.println("\n--- Initial Employee List ---");
        service.displayAll();

        // 3. Save to file
        service.saveToFile(fileName);

        // 4. Create NEW service to prove persistence
        EmployeeService loadedService = new EmployeeService();
        loadedService.loadFromFile(fileName);

        // 5. Display loaded data
        System.out.println("\n--- Loaded From File ---");
        loadedService.displayAll();

        // 6. Search test
        System.out.println("\n--- Search by Name: Anil ---");
        loadedService.searchByName("Anil").forEach(System.out::println);

        // 7. Update test
        loadedService.updateEmployee(
                101,
                new Employee(101, "Drishya Anil Updated", "newemail@company.com", "Engineering", 95000)
        );

        // 8. Delete test
        loadedService.deleteEmployee(103);

        // 9. Final state
        System.out.println("\n--- Final Employee List ---");
        loadedService.displayAll();
    }
}