
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        FileHandler.readEmployees(manager);

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Update Employee");
            System.out.println("6. Delete Employee");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    System.out.print("Enter Allowance: ");
                    double allowance = sc.nextDouble();

                    FullTimeEmployee fullTimeEmployee =
                            new FullTimeEmployee(
                                    id,
                                    name,
                                    department,
                                    salary,
                                    allowance
                            );

                    manager.addEmployee(fullTimeEmployee);
                    FileHandler.saveEmployee(fullTimeEmployee);

                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int partId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String partName = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String partDepartment = sc.nextLine();

                    System.out.print("Enter Hours Worked: ");
                    int hours = sc.nextInt();

                    System.out.print("Enter Hourly Rate: ");
                    double rate = sc.nextDouble();

                    PartTimeEmployee partTimeEmployee =
                            new PartTimeEmployee(
                                    partId,
                                    partName,
                                    partDepartment,
                                    hours,
                                    rate
                            );

                    manager.addEmployee(partTimeEmployee);
                    FileHandler.saveEmployee(partTimeEmployee);


                    break;

                case 3:
                    manager.viewEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();

                    manager.searchEmployee(searchId);
                    break;

                case 5:
                    System.out.print("Enter Employee ID: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    manager.updateEmployee(
                            updateId,
                            newName,
                            newDepartment
                    );

                    break;

                case 6:
                    System.out.print("Enter Employee ID: ");
                    int deleteId = sc.nextInt();

                    manager.deleteEmployee(deleteId);
                    break;

                case 7:
                    System.out.println("Thank you for using Employee Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}