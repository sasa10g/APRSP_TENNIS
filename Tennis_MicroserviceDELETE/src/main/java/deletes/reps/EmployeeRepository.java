package deletes.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import deletes.jpa.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

