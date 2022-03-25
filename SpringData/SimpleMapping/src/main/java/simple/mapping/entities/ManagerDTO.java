package simple.mapping.entities;

import java.util.Set;
import java.util.stream.Collectors;

public class ManagerDTO {
    private String firstName;
    private String lastName;
    private Set<EmployeeDTO> workers;

    public ManagerDTO() {
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

    public Set<EmployeeDTO> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<EmployeeDTO> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Employees: %d%n%s",
                getFirstName(), getLastName(), getWorkers().size(),
                getWorkers().stream().map(w -> String.format("    -%s %s %.2f", w.getFirstName(), w.getLastName(), w.getSalary())).collect(Collectors.joining("\n")));
    }
}
