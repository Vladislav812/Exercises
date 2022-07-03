package Sandbox;

class ContractEmployee extends Employee {

    protected long payPerHour;
    protected String contractPeriod;

    public ContractEmployee(String name, String birthDate, long payPerHour, String contractPeriod) {
        this.name = name;
        this.payPerHour = payPerHour;
        this.contractPeriod = contractPeriod;
    }
}
