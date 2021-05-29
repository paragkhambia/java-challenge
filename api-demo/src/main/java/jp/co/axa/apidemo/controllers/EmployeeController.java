package jp.co.axa.apidemo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Fetch all Employees list from Database
	 * 
	 * @return List<Employee>
	 */
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeService.retrieveEmployees();
		return employees;
	}

	/**
	 * Fetch Employee by employeeId from Database
	 * 
	 * @return Employee
	 * @param employeeId
	 */
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		
		if (employee == null) {
			employee = new Employee();
			employee.setId(new Long(0));
			employee.setDepartment("Data Not Found");
			employee.setName("Data Not Found");
			employee.setSalary(0);
		}
		return employee;

	}

	/**
	 * Save new Employee to Database
	 * 
	 * @param Employee
	 */
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(Employee employee) {
		if(employee == null)
		{
			return ResponseEntity.noContent().build();
		}
		employeeService.saveEmployee(employee);
		logger.info("Employee Saved Successfully");
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	/**
	 * Delete Employee by employeeId from Database
	 * 
	 * @param employeeId
	 */
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		try {
			employeeService.deleteEmployee(employeeId);
		} catch (EmptyResultDataAccessException noResult) {
			logger.debug("Employee with EmployeeID " + employeeId + "is not available in Employee Table");
		}
		logger.info("Employee Deleted Successfully for " + employeeId);
	}

	/**
	 * Update Employee by employeeId in Database
	 * 
	 * @param employeeId
	 */
	@PutMapping("/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(employee);
			logger.info("Employee Updated Successfully for " + employeeId);
		}
		else {
			logger.debug("Employee with EmployeeID " + employeeId + "is not available in Employee Table");
		}
	}

}
