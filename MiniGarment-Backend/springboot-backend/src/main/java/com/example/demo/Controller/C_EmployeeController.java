package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.C_Employee;
import com.example.demo.Repository.C_EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class C_EmployeeController {
	
	@Autowired
	private C_EmployeeRepository c_employeerepository;
	
	//get all employee
	
	@GetMapping("/employees")
	public List<C_Employee> getAllEmployees(){
		return c_employeerepository.findAll();
	}
	
	//create employee api
	@PostMapping("/employees")
	public C_Employee createEmployee(@RequestBody C_Employee c_employee) {
		return c_employeerepository.save(c_employee);
	}
	
	//get employee by Id api
	@GetMapping("/employees/{employeeid}")
	public ResponseEntity<C_Employee> getEmployeeByEmployeeid(@PathVariable String employeeid) {
		
		C_Employee c_employee = c_employeerepository.findById(employeeid)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with employee id :" + employeeid ));
		return ResponseEntity.ok(c_employee);
	}
	
	//update employee api
	@PutMapping("/employees/{employeeid}")
	public ResponseEntity<C_Employee> updateEmployee(@PathVariable String employeeid,@RequestBody C_Employee c_employeeemployeeDetails){
		C_Employee c_employee = c_employeerepository.findById(employeeid)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with employee id :" + employeeid ));
		
		c_employee.setEmployeeid(c_employeeemployeeDetails.getEmployeeid());
		c_employee.setEmployeename(c_employeeemployeeDetails.getEmployeename());
		c_employee.setNic(c_employeeemployeeDetails.getNic());
		c_employee.setGender(c_employeeemployeeDetails.getGender());
		c_employee.setOccupation(c_employeeemployeeDetails.getOccupation());
		c_employee.setPhonenumber(c_employeeemployeeDetails.getPhonenumber());
		c_employee.setEmail(c_employeeemployeeDetails.getEmail());
		c_employee.setAddress(c_employeeemployeeDetails.getAddress());
		c_employee.setBasicsallary(c_employeeemployeeDetails.getBasicsallary());
		
		C_Employee updatedEmployee = c_employeerepository.save(c_employee);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	//delete employee
		@DeleteMapping("/employees/{employeeid}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String employeeid){
			
			C_Employee c_employee = c_employeerepository.findById(employeeid)
					.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with employee id :" + employeeid ));
			
			c_employeerepository.delete(c_employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("delete", Boolean.TRUE);
			return ResponseEntity.ok(response);
	
		}
}
