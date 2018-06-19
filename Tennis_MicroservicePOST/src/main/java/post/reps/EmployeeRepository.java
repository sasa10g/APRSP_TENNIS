package post.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

