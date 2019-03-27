/**
 * 
 */
package com.collabera.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.collabera.ems.model.Employee;

/**
 * @author rutpatel
 *
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	ArrayList<Employee> findByName(String name);
	
	ArrayList<Employee> findBySsn(int ssn);
	
	@Query(value="select e from Employee e where e.aHome.state = :state")
	ArrayList<Employee> searchByHomeState(String state);

}
