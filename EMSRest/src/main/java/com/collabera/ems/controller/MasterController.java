/**
 * 
 */
package com.collabera.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.ems.model.Department;
import com.collabera.ems.model.Gender;
import com.collabera.ems.model.JobTitle;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author rutpatel
 *
 */
@RestController
@Api(tags = "General Info", description = "Get General Info")
public class MasterController {

//	---------------------- Terms of Service ----------------------
	@ApiOperation(value = "Terms of Service", notes = "Get Terms of Service")
	@GetMapping("/termsofservice")
	private ResponseEntity<String> termsOfService() {
		return ResponseEntity.ok().body("Nobody got time for that. So, I just assumed you agreed on Terms of Service...");
	}

//	---------------------- GENDER REST API ----------------------

	@ApiOperation(value = "Get Genders", notes = "To Get Genders")
	@GetMapping(path = "/general/getGenders")
	private ResponseEntity<Gender[]> getGenders() {
		return ResponseEntity.ok(Gender.values());
	}

//	---------------------- DEPARTMENT REST API ----------------------

	@ApiOperation(value = "Get Departments", notes = "To Get available Departments")
	@GetMapping("/general/getDepartments")
	private ResponseEntity<Department[]> getDepts() {
		return ResponseEntity.ok(Department.values());
	}

//	---------------------- JOBTITLE REST API ----------------------

	@ApiOperation(value = "Get Job Titles", notes = "To Get available Job Titles")
	@GetMapping("/general/getJobTitles")
	private ResponseEntity<JobTitle[]> getJobTitles() {
		return ResponseEntity.ok(JobTitle.values());
	}

}
