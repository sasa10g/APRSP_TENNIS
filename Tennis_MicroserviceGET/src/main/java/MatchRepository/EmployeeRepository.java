package MatchRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}