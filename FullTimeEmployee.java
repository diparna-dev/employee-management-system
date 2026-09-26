public class FullTimeEmployee extends Employee {

    double allowance;

    public FullTimeEmployee(int id, String name, String department,
                            double salary, double allowance) {

        super(id, name, salary, department);

        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return salary + allowance;
    }

    @Override
    public void displayEmployee() {
        super.displayEmployee();

        System.out.println("Allowance: " + allowance);
        System.out.println("Net Salary: " + calculateSalary());
    }
}
