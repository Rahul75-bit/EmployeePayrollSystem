package employee;

public class PermanentEmployee extends Employee
{
    private double bonus;
    public PermanentEmployee(int id, String name,double baseSalary,double bonus) 
    {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary()
    {
        double tax = baseSalary * 0.10;
        return baseSalary + bonus - tax;
    }

    @Override
    public void generateSalarySlip() 
    {
        double salary = calculateSalary();

        System.out.println("\n===== SALARY SLIP =====");
        System.out.println("Employee Type : Permanent");
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Base Salary   : " + baseSalary);
        System.out.println("Bonus         : " + bonus);
        System.out.println("Final Salary  : " + salary);
    }

    @Override
    public String toString() 
    {
        return "Permanent," + id + "," + name + "," + baseSalary + "," + bonus;
    }
}
