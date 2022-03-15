package com.anhduc.hello.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anhduc.hello.model.Employee;

@Repository

public interface EmployeeReponsitory extends JpaRepository<Employee	, Long> {

}
