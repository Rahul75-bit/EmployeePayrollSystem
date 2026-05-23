package employee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PayrollService payroll = new PayrollService();
        payroll.loadFromFile();

        while(true)
        {
            System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");

            System.out.println("1. Add Permanent Employee");
            System.out.println("2. Add Contract Employee");
            System.out.println("3. Show All Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Save & Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Base Salary: ");
                    double salary = sc.nextDouble();

                    System.out.print("Enter Bonus: ");
                    double bonus = sc.nextDouble();

                    PermanentEmployee permanentEmployee =new PermanentEmployee(id,name,salary,bonus);

                    payroll.addEmployee(permanentEmployee);

                    break;

                case 2:

                    System.out.print("Enter Employee ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Working Hours: ");
                    int hours = sc.nextInt();

                    System.out.print("Enter Hourly Rate: ");
                    double rate = sc.nextDouble();

                    ContractEmployee contractEmployee =new ContractEmployee(id,name,hours,rate);
                    payroll.addEmployee(contractEmployee);
                    break;

                case 3:
                    payroll.showAllEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    id = sc.nextInt();
                    payroll.searchEmployee(id);
                    break;

                case 5:
                    payroll.saveToFile();
                    System.out.println("Thank You!");
                    System.exit(0);
                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}
