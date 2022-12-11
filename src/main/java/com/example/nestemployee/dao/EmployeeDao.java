package com.example.nestemployee.dao;

import com.example.nestemployee.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
