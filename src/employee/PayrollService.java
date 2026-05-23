package employee;

import java.io.*;
import java.util.*;

public class PayrollService {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {

        employees.add(employee);

        System.out.println("Employee Added Successfully");
    }

    public void showAllEmployees() {

        if(employees.isEmpty()) {

            System.out.println("No Employees Found");
            return;
        }

        for(Employee employee : employees) {

            employee.generateSalarySlip();
        }
    }

    public void searchEmployee(int id) {

        for(Employee employee : employees) {

            if(employee.getId() == id) {

                employee.generateSalarySlip();
                return;
            }
        }

        System.out.println("Employee Not Found");
    }

    public void saveToFile() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("employees.txt"));

            for(Employee employee : employees) {

                writer.write(employee.toString());
                writer.newLine();
            }

            writer.close();

            System.out.println("Data Saved Successfully");

        } catch(IOException e) {

            System.out.println("Error Saving File");
        }
    }

    public void loadFromFile() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("employees.txt"));

            String line;

            while((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if(data[0].equals("Permanent")) {

                    PermanentEmployee employee =
                            new PermanentEmployee(
                                    Integer.parseInt(data[1]),
                                    data[2],
                                    Double.parseDouble(data[3]),
                                    Double.parseDouble(data[4])
                            );

                    employees.add(employee);

                } else if(data[0].equals("Contract")) {

                    ContractEmployee employee =
                            new ContractEmployee(
                                    Integer.parseInt(data[1]),
                                    data[2],
                                    Integer.parseInt(data[3]),
                                    Double.parseDouble(data[4])
                            );

                    employees.add(employee);
                }
            }

            reader.close();

        } catch(IOException e) {

            System.out.println("No Previous Data Found");
        }
    }
}
