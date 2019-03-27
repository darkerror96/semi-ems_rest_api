/**
 * 
 */
package com.collabera.ems.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.ems.exception.EmployeeNotFoundException;
import com.collabera.ems.model.Employee;
import com.collabera.repo.EmployeeRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author rutpatel
 *
 */
@RestController
@Api(tags = "Employee", description = "Operations about Employee")
public class EmployeeController {

	@Autowired
	EmployeeRepo empRepo;

//	---------------------- Terms of Service ----------------------

	@GetMapping("/termsofservice")
	private ResponseEntity<String> termsOfService() {
		return ResponseEntity.ok().body("Everybody knows nobody reads the Terms of Service. So...");
	}

//	---------------------- EMPLOYEE REST API Working ----------------------

	@ApiResponses({
			@ApiResponse(code = 404, message = "Employee not found", response = EmployeeNotFoundException.class) })
	@ApiOperation(value = "Get All Employees Details", notes = "To Get All Employees Details")
	@GetMapping(path = "/employee/getAll")
	private ResponseEntity<ArrayList<Employee>> getAllEmp() throws ParseException {
		ArrayList<Employee> empList = (ArrayList<Employee>) empRepo.findAll();
		if (empList.size() > 0) {
			return ResponseEntity.ok(empList);
		}
		throw new EmployeeNotFoundException("Employee not found...");
	}

	@ApiResponses({
			@ApiResponse(code = 404, message = "Employee not found", response = EmployeeNotFoundException.class) })
	@ApiOperation(value = "Get specific Employee Details by EmpId", notes = "To Get specific Employee Details by passing EmpId")
	@GetMapping("/employee/getId")
	private ResponseEntity<Optional<Employee>> getEmpId(@RequestParam(name = "empId", required = true) int empId) {
		Optional<Employee> emp = empRepo.findById(empId);
		if (!emp.isEmpty()) {
			return ResponseEntity.ok(emp);
		}
		throw new EmployeeNotFoundException("Employee not found...");
	}

	@ApiOperation(value = "Create New Employee", notes = "To Create New Employee by passing Employee Details")
	@PostMapping("/employee/create")
	private ResponseEntity<String> createEmp(@Valid @RequestBody Employee emp) throws URISyntaxException {
		empRepo.saveAndFlush(emp);
		return ResponseEntity.created(new URI("localhost:8080/employee/getId?empId=" + emp.geteId()))
				.body("[" + emp.getName() + "] Employee Created...");
	}

	@ApiResponses({
			@ApiResponse(code = 404, message = "Employee not found", response = EmployeeNotFoundException.class) })
	@ApiOperation(value = "Update specific Employee Details by EmpId", notes = "To Update specific Employee Details by passing EmpId and Employee Details")
	@PutMapping("/employee/update")
	private ResponseEntity<String> updateEmpId(@RequestParam(name = "empId", required = true) int empId,
			@Valid @RequestBody Employee empNew) {
		Optional<Employee> empOpt = empRepo.findById(empId);
		if (empOpt.isPresent()) {
			Employee emp = empOpt.get();
			emp.seteId(empNew.geteId());
			emp.setName(empNew.getName());
			emp.setAge(empNew.getAge());
			emp.setGender(empNew.getGender());
			emp.setContactNo(empNew.getContactNo());
			emp.setaHome(empNew.getaHome());
			emp.setaWork(empNew.getaWork());
			emp.setSsn(empNew.getSsn());
			emp.setEmail(empNew.getEmail());
			emp.setJobTitle(empNew.getJobTitle());
			emp.setDept(empNew.getDept());
			emp.setSalary(empNew.getSalary());
			emp.setReportTo(empNew.getReportTo());
			emp.setIsManager(empNew.getIsManager());
			empRepo.save(emp);
			return ResponseEntity.accepted().body("[" + emp.getName() + "] Employee Updated...");
		}
		throw new EmployeeNotFoundException("Employee not found...");
	}

	@ApiResponses({
			@ApiResponse(code = 404, message = "Employee not found", response = EmployeeNotFoundException.class) })
	@ApiOperation(value = "Delete specific Employee by EmpId", notes = "To Delete specific Employee by passing EmpId")
	@DeleteMapping("/employee/delete")
	private boolean deleteEmpId(@RequestParam(name = "empId", required = true) int empId) {
		if (!empRepo.findById(empId).isEmpty()) {
			empRepo.deleteById(empId);
			return true;
		}
		throw new EmployeeNotFoundException("Employee not found...");
	}

//	---------------------- EMPLOYEE MANAGER SEARCH REST API ----------------------

	@ApiResponses({
			@ApiResponse(code = 404, message = "Employee not found", response = EmployeeNotFoundException.class) })
	@ApiOperation(value = "Get specific Employee Details by Employee Name", notes = "To Get specific Employee Details by passing Employee Name")
	@GetMapping("/employee/searchByName")
	private ResponseEntity<ArrayList<Employee>> searchByName(
			@RequestParam(name = "name", required = true) String name) {
		ArrayList<Employee> empList = empRepo.findByName(name);
		if (empList.size() > 0) {
			return ResponseEntity.ok(empList);
		}
		throw new EmployeeNotFoundException("Employee not found...");
	}

	@ApiResponses({
			@ApiResponse(code = 404, message = "Employee not found", response = EmployeeNotFoundException.class) })
	@ApiOperation(value = "Get specific Employee Details by Employee SSN", notes = "To Get specific Employee Details by passing Employee SSN")
	@GetMapping("/employee/searchBySsn")
	private ResponseEntity<ArrayList<Employee>> getEmpName(@RequestParam(name = "ssn", required = true) int ssn) {
		ArrayList<Employee> empList = empRepo.findBySsn(ssn);
		if (empList.size() > 0) {
			return ResponseEntity.ok(empList);
		}
		throw new EmployeeNotFoundException("Employee not found...");
	}

	@ApiResponses({
			@ApiResponse(code = 404, message = "Employee not found", response = EmployeeNotFoundException.class) })
	@ApiOperation(value = "Get Employees Details by specific Home State", notes = "To Get Employees Details by passing specific Home State")
	@GetMapping("/employee/searchByHomeState")
	private ResponseEntity<ArrayList<Employee>> searchByHomeState(
			@RequestParam(name = "state", required = true) String state) {
		ArrayList<Employee> empList = empRepo.searchByHomeState(state);
		if (empList.size() > 0) {
			return ResponseEntity.ok(empList);
		}
		throw new EmployeeNotFoundException("Employee not found...");
	}

}
