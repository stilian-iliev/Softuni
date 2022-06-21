package bg.softuni.linkedout.services;

import bg.softuni.linkedout.models.Company;
import bg.softuni.linkedout.models.Employee;
import bg.softuni.linkedout.models.dtos.AddEmployeeDto;
import bg.softuni.linkedout.repositories.CompanyRepository;
import bg.softuni.linkedout.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    public void add(AddEmployeeDto addEmployeeDto) {
        Employee employee = mapper.map(addEmployeeDto, Employee.class);
        Optional<Company> company = companyRepository.findByName(addEmployeeDto.getCompany());
        if (company.isEmpty()) return;
        employee.setCompany(company.get());
        employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
