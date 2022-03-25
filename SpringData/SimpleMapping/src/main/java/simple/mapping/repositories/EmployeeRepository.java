package simple.mapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import simple.mapping.entities.Employee;
import simple.mapping.entities.EmployeeDTO;
import simple.mapping.entities.SpringEmployeeDtop;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<SpringEmployeeDtop> findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate before);
}
