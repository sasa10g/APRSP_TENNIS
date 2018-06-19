package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Collection<Employee> findByEmployeelastnameContainingIgnoreCase (String employeelastname);
}