package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.C_Employee;
@Repository
public interface C_EmployeeRepository extends JpaRepository<C_Employee, String>{}