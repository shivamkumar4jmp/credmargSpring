package com.credmarg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credmarg.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
