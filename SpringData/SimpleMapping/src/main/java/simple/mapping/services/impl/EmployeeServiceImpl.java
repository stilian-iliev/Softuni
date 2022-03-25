package simple.mapping.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.mapping.entities.Employee;
import simple.mapping.entities.EmployeeDTO;
import simple.mapping.entities.SpringEmployeeDtop;
import simple.mapping.repositories.EmployeeRepository;
import simple.mapping.services.EmployeeService;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void printEmployeesDto() {
        List<SpringEmployeeDtop> employees = employeeRepository.findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate.of(1900, 1, 1));
        employees.forEach(System.out::println);

        //        ModelMapper mm = new ModelMapper();

//        employees.stream().map(e -> mm.map(e, SpringEmployeeDtop.class)).forEach(System.out::println);
    }
}
