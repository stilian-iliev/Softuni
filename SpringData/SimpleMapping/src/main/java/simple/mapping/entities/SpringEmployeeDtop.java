package simple.mapping.entities;

import java.math.BigDecimal;

public class SpringEmployeeDtop {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String managerLastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public SpringEmployeeDtop(String firstName, String lastName, BigDecimal salary, String managerLastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerLastName = managerLastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f - Manager: %s", firstName, lastName, salary, managerLastName == null ? "[no manager]": managerLastName);
    }
}
