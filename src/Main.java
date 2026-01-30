import model.Employee;
import service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        service.addEmployee(new Employee(101, "Drishya Anil", "drishya@company.com", "Engineering", 85000));
        service.addEmployee(new Employee(102, "Rahul Sharma", "rahul@company.com", "HR", 65000));
        service.addEmployee(new Employee(103, "Priya Singh", "priya@company.com", "Finance", 75000));

        service.displayAll();
    }
}
