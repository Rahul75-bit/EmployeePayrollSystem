package employee;

public abstract class Employee
{
    protected int id;
    protected String name;
    protected double baseSalary;

    public Employee(int id, String name, double baseSalary)
    {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId()
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public abstract double calculateSalary();

    public abstract void generateSalarySlip();
}
