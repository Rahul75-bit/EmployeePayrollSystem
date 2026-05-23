package employee;

public class ContractEmployee extends Employee {

    private int workingHours;
    private double hourlyRate;

    public ContractEmployee(int id,
                            String name,
                            int workingHours,
                            double hourlyRate) {

        super(id, name, 0);

        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {

        return workingHours * hourlyRate;
    }

    @Override
    public void generateSalarySlip() {

        double salary = calculateSalary();

        System.out.println("\n===== SALARY SLIP =====");
        System.out.println("Employee Type : Contract");
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Working Hours : " + workingHours);
        System.out.println("Hourly Rate   : " + hourlyRate);
        System.out.println("Final Salary  : " + salary);
    }

    @Override
    public String toString() {

        return "Contract," + id + "," + name + ","
                + workingHours + "," + hourlyRate;
    }
}
