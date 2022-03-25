package simple.mapping.entities;

import java.math.BigDecimal;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private EmployeeDTO manager;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String firstName, String lastName, BigDecimal salary, EmployeeDTO manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.manager = manager;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public EmployeeDTO getManager() {
        return manager;
    }

    public void setManager(EmployeeDTO manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f - Manager: %s", getFirstName(), getLastName(), getSalary(), getManager() == null ? "[no manager]": getManager().getLastName());
    }
}
