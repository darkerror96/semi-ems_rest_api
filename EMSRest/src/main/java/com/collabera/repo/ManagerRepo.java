/**
 * 
 */
package com.collabera.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.ems.model.Manager;

/**
 * @author rutpatel
 *
 */
public interface ManagerRepo extends JpaRepository<Manager, Integer> {

	ArrayList<Manager> findByName(String name);

}
