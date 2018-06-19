package put.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import put.jpa.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

