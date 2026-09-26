public class PartTimeEmployee extends Employee {

    int hoursWorked;
    double hourlyRate;

    public PartTimeEmployee(int id, String name, String department,
                            int hoursWorked, double hourlyRate) {

        super(id, name, 0, department);

        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void displayEmployee() {
        super.displayEmployee();

        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Net Salary: " + calculateSalary());
    }
}