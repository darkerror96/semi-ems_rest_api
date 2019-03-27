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
import com.collabera.ems.exception.ManagerNotFoundException;
import com.collabera.ems.model.Employee;
import com.collabera.ems.model.Manager;
import com.collabera.repo.EmployeeRepo;
import com.collabera.repo.ManagerRepo;

import io.swagger.annotations.ApiOperation;

/**
 * @author rutpatel
 *
 */
@RestController
public class EMSController {

	@Autowired
	EmployeeRepo empRepo;

	@Autowired
	ManagerRepo manRepo;

//	---------------------- EMPLOYEE REST API ----------------------

	@ApiOperation(value = "Get All Employees Details", notes = "To Get All Employees Details")
	@GetMapping(path = "/employee/getAll")
	private ResponseEntity<ArrayList<Employee>> getAllEmp() throws ParseException {
		ArrayList<Employee> empList = (ArrayList<Employee>) empRepo.findAll();
		if (empList.size() > 0) {
			return ResponseEntity.ok(empList);
		}
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Get specific Employee Details by EmpId", notes = "To Get specific Employee Details by passing EmpId")
	@GetMapping("/employee/getId")
	private ResponseEntity<Optional<Employee>> getEmpId(@RequestParam(name = "empId", required = true) int empId) {
		Optional<Employee> emp = empRepo.findById(empId);
		if (!emp.isEmpty()) {
			return ResponseEntity.ok(emp);
		}
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Get specific Employee Details by Employee Name", notes = "To Get specific Employee Details by passing Employee Name")
	@GetMapping("/employee/getName")
	private ResponseEntity<ArrayList<Employee>> getEmpName(@RequestParam(name = "name", required = true) String name) {
		ArrayList<Employee> empList = empRepo.findByName(name);
		if (empList.size() > 0) {
			return ResponseEntity.ok(empList);
		}
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Create New Employee", notes = "To Create New Employee by passing Employee Details")
	@PostMapping("/employee/create")
	private ResponseEntity<String> createEmp(@Valid @RequestBody Employee emp) throws URISyntaxException {
		empRepo.saveAndFlush(emp);
		return ResponseEntity.created(new URI("localhost:8080/employee/getId?empId=" + emp.geteId()))
				.body("[" + emp.getName() + "] Employee Created...");
	}

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

	@ApiOperation(value = "Delete specific Employee by EmpId", notes = "To Delete specific Employee by passing EmpId")
	@DeleteMapping("/employee/delete")
	private boolean deleteEmpId(@RequestParam(name = "empId", required = true) int empId) {
		if (!empRepo.findById(empId).isEmpty()) {
			empRepo.deleteById(empId);
			return true;
		}
		return false;
	}

//	---------------------- MANAGER REST API ----------------------

	@ApiOperation(value = "Get All Managers Details", notes = "To Get All Managers Details")
	@GetMapping(path = "/manager/getAll")
	private ResponseEntity<ArrayList<Manager>> getAllMan() throws ParseException {
		ArrayList<Manager> manList = (ArrayList<Manager>) manRepo.findAll();
		if (manList.size() > 0) {
			return ResponseEntity.ok(manList);
		}
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Get specific Manager Details by ManId", notes = "To Get specific Manager Details by passing ManId")
	@GetMapping("/manager/getId")
	private ResponseEntity<Optional<Manager>> getManId(@RequestParam(name = "manId", required = true) int manId) {
		Optional<Manager> man = manRepo.findById(manId);
		if (!man.isEmpty()) {
			return ResponseEntity.ok(man);
		}
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Create New Manager", notes = "To Create New Manager by passing Manager Details")
	@PostMapping("/manager/create")
	private ResponseEntity<String> createMan(@Valid @RequestBody Manager man) throws URISyntaxException {
		manRepo.saveAndFlush(man);
		return ResponseEntity.created(new URI("localhost:8080/Manager/getId?manId=" + man.geteId()))
				.body("[" + man.getName() + "] Manager Created...");

	}

	@ApiOperation(value = "Update specific Manager Details by ManId", notes = "To Update specific Manager Details by passing ManId and Manager Details")
	@PutMapping("/manager/update")
	private ResponseEntity<String> updateManId(@RequestParam(name = "manId", required = true) int manId,
			@Valid @RequestBody Manager manNew) {
		Optional<Manager> manOpt = manRepo.findById(manId);
		if (manOpt.isPresent()) {
			Manager man = manOpt.get();
			man.seteId(manNew.geteId());
			man.setName(manNew.getName());
			man.setAge(manNew.getAge());
			man.setGender(manNew.getGender());
			man.setContactNo(manNew.getContactNo());
			man.setaHome(manNew.getaHome());
			man.setaWork(manNew.getaWork());
			man.setSsn(manNew.getSsn());
			man.setEmail(manNew.getEmail());
			man.setJobTitle(manNew.getJobTitle());
			man.setDept(manNew.getDept());
			man.setSalary(manNew.getSalary());
			man.setReportTo(manNew.getReportTo());
			man.setIsManager(manNew.getIsManager());
			manRepo.save(man);
			return ResponseEntity.accepted().body("[" + man.getName() + "] Manager Updated...");
		}
		throw new ManagerNotFoundException("Manager not found...");
	}

	@ApiOperation(value = "Delete specific Manager by ManId", notes = "To Delete specific Manager by passing ManId")
	@DeleteMapping("/manager/delete")
	private boolean deleteManId(@RequestParam(name = "manId", required = true) int manId) {
		if (!manRepo.findById(manId).isEmpty()) {
			manRepo.deleteById(manId);
			return true;
		}
		return false;
	}
}
