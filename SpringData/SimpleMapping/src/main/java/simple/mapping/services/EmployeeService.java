package simple.mapping.services;

import simple.mapping.entities.Employee;

public interface EmployeeService {
    void save(Employee employee);

    void printEmployeesDto();
}
