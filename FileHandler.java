import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileHandler {

    public static void saveEmployee(Employee employee) {

        try {

            File file = new File("employees.txt");

            System.out.println("File location: " + file.getAbsolutePath());

            FileWriter writer = new FileWriter(file, true);
            if (employee instanceof FullTimeEmployee) {

                FullTimeEmployee fullTime = (FullTimeEmployee) employee;

                writer.write(
                        "FULLTIME," +
                                fullTime.id + "," +
                                fullTime.name + "," +
                                fullTime.department + "," +
                                fullTime.salary + "," +
                                fullTime.allowance +
                                "\n"
                );

            } else if (employee instanceof PartTimeEmployee) {

                PartTimeEmployee partTime = (PartTimeEmployee) employee;

                writer.write(
                        "PARTTIME," +
                                partTime.id + "," +
                                partTime.name + "," +
                                partTime.department + "," +
                                partTime.hoursWorked + "," +
                                partTime.hourlyRate +
                                "\n"
                );
            }


            writer.close();

            System.out.println("Employee saved to file!");

        } catch (IOException e) {

            System.out.println("Error saving employee.");
        }
    }

    public static void readEmployees(EmployeeManager manager) {

        try {

            File file = new File("employees.txt");

            if (!file.exists()) {
                System.out.println("No employee file found.");
                return;
            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals("FULLTIME")) {

                    int id = Integer.parseInt(data[1]);
                    String name = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    double allowance = Double.parseDouble(data[5]);

                    FullTimeEmployee employee =
                            new FullTimeEmployee(
                                    id,
                                    name,
                                    department,
                                    salary,
                                    allowance
                            );

                    manager.addEmployee(employee);

                } else if (data[0].equals("PARTTIME")) {

                    int id = Integer.parseInt(data[1]);
                    String name = data[2];
                    String department = data[3];
                    int hours = Integer.parseInt(data[4]);
                    double rate = Double.parseDouble(data[5]);

                    PartTimeEmployee employee =
                            new PartTimeEmployee(
                                    id,
                                    name,
                                    department,
                                    hours,
                                    rate
                            );

                    manager.addEmployee(employee);
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error reading employee file.");

        } catch (Exception e) {

            System.out.println("Invalid employee data in file.");
        }
    }
}