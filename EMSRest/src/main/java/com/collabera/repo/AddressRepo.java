/**
 * 
 */
package com.collabera.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.ems.model.Address;

/**
 * @author rutpatel
 *
 */
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
