/**
 * 
 */
package com.collabera.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.ems.model.Employee;

/**
 * @author rutpatel
 *
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	ArrayList<Employee> findByName(String name);

}
