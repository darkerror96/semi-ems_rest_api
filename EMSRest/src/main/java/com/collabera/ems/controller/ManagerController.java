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

import com.collabera.ems.exception.ManagerNotFoundException;
import com.collabera.ems.model.Manager;
import com.collabera.repo.ManagerRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author rutpatel
 *
 */
@RestController
@Api(tags = "Manager", description = "Operations about Manager")
public class ManagerController {

	@Autowired
	ManagerRepo manRepo;

//	---------------------- MANAGER REST API ----------------------

	@ApiResponses({
			@ApiResponse(code = 404, message = "Manager not found", response = ManagerNotFoundException.class) })
	@ApiOperation(value = "Get All Managers Details", notes = "To Get All Managers Details")
	@GetMapping(path = "/manager/getAll")
	private ResponseEntity<ArrayList<Manager>> getAllMan() throws ParseException {
		ArrayList<Manager> manList = (ArrayList<Manager>) manRepo.findAll();
		if (manList.size() > 0) {
			return ResponseEntity.ok(manList);
		}
		throw new ManagerNotFoundException("Manager not found...");
	}

	@ApiResponses({
			@ApiResponse(code = 404, message = "Manager not found", response = ManagerNotFoundException.class) })
	@ApiOperation(value = "Get specific Manager Details by ManId", notes = "To Get specific Manager Details by passing ManId")
	@GetMapping("/manager/getId")
	private ResponseEntity<Optional<Manager>> getManId(@RequestParam(name = "manId", required = true) int manId) {
		Optional<Manager> man = manRepo.findById(manId);
		if (!man.isEmpty()) {
			return ResponseEntity.ok(man);
		}
		throw new ManagerNotFoundException("Manager not found...");
	}

	@ApiOperation(value = "Create New Manager", notes = "To Create New Manager by passing Manager Details")
	@PostMapping("/manager/create")
	private ResponseEntity<String> createMan(@Valid @RequestBody Manager man) throws URISyntaxException {
		manRepo.saveAndFlush(man);
		return ResponseEntity.created(new URI("localhost:8080/Manager/getId?manId=" + man.geteId()))
				.body("[" + man.getName() + "] Manager Created...");
	}

	@ApiResponses({
			@ApiResponse(code = 404, message = "Manager not found", response = ManagerNotFoundException.class) })
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

	@ApiResponses({
			@ApiResponse(code = 404, message = "Manager not found", response = ManagerNotFoundException.class) })
	@ApiOperation(value = "Delete specific Manager by ManId", notes = "To Delete specific Manager by passing ManId")
	@DeleteMapping("/manager/delete")
	private boolean deleteManId(@RequestParam(name = "manId", required = true) int manId) {
		if (!manRepo.findById(manId).isEmpty()) {
			manRepo.deleteById(manId);
			return true;
		}
		throw new ManagerNotFoundException("Manager not found...");
	}

}
