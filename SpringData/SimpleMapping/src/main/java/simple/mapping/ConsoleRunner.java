package simple.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import simple.mapping.services.EmployeeService;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
//        Employee manager = new Employee("manager", "last", BigDecimal.ONE, LocalDate.now(), "address", false, null, new HashSet<>());
//        Employee  employee = new Employee("employee", "last", BigDecimal.ONE, LocalDate.now(), "address", false, manager, new HashSet<>());
//
//        manager.getWorkers().add(employee);
//
//        employeeService.save(manager);
//        employeeService.save(employee);

        employeeService.printEmployeesDto();
    }
}
