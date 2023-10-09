package com.benfle.employeeservice.command.data;

import com.benfle.bookservice.command.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}

//tu day tao ra ca truy van
