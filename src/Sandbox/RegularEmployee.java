package Sandbox;

class RegularEmployee extends Employee {

    protected long salary;
    protected String hireDate;

    public RegularEmployee() {
        super();
    }

    public RegularEmployee(String name, String birthDate, long salary, String hireDate) {
        //this.name = name;
        super(name, birthDate);
        this.salary = salary;
        this.hireDate = hireDate;
    }
}
