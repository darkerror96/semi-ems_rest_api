/**
 * 
 */
package com.collabera.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.collabera.ems.model.Department;
import com.collabera.ems.model.Employee;
import com.collabera.ems.model.Gender;
import com.collabera.ems.model.JobTitle;

/**
 * @author rutpatel
 *
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	ArrayList<Employee> findByName(String name);

	ArrayList<Employee> findBySsn(int ssn);

	ArrayList<Employee> findByAgeLessThan(int age);

	ArrayList<Employee> findByAgeGreaterThan(int age);

	ArrayList<Employee> findByNameContaining(String name);

	ArrayList<Employee> findByAgeGreaterThanAndGender(int age, Gender gen);

	ArrayList<Employee> findBySalaryGreaterThanOrderBySalaryAsc(double salary);

	ArrayList<Employee> findByReportToAndDeptAndJobTitle(int reportTo, Department dept, JobTitle jobTitle);

	@Query(value = "select e from Employee e where e.aHome.state = :state")
	ArrayList<Employee> searchByHomeState(String state);

}
