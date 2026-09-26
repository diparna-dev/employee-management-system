import java.util.ArrayList;

public class EmployeeManager {

    ArrayList<Employee> employees = new ArrayList<>();

    // Add employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    // View all employees
    public void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            employee.displayEmployee();
            System.out.println("----------------------");
        }

    }public void searchEmployee(int id) {

        for (Employee employee : employees) {

            if (employee.id == id) {
                System.out.println("Employee Found!");
                employee.displayEmployee();
                return;
            }
        }

        System.out.println("Employee not found.");
    }
    // Delete employee
    public void deleteEmployee(int id) {

        for (Employee employee : employees) {

            if (employee.id == id) {
                employees.remove(employee);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }
    // Update employee
    public void updateEmployee(int id, String newName, String newDepartment) {

        for (Employee employee : employees) {

            if (employee.id == id) {

                employee.name = newName;
                employee.department = newDepartment;

                System.out.println("Employee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}
