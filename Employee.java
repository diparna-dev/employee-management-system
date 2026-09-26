public class Employee {

    int id;
    String name;
    double salary;
    String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public void displayEmployee() {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("SALARY: " + salary);
        System.out.println("DEPARTMENT: " + department);
    }

    public double calculateSalary() {
        return salary;
    }
}

