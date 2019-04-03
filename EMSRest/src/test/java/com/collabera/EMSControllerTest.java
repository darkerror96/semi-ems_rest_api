/**
 * 
 */
package com.collabera;

import org.junit.Test;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;

//import com.collabera.ems.model.Address;
//import com.collabera.ems.model.Department;
//import com.collabera.ems.model.Employee;
//import com.collabera.ems.model.Gender;
//import com.collabera.ems.model.JobTitle;
//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author rutpatel
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvc
public class EMSControllerTest {

	
	@Test
	public void contextLoads() {
	}
	
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	public void testGetEmpId() throws Exception {
//		mockMvc.perform(get("/employee/getId?empId=2")).andExpect(status().isNotFound());
//	}
//
//	@Test
//	public void testPostEmp() throws Exception {
//		Address a1 = new Address("30 FarView", "Vado", "New Jersey", "USA", 25219);
//		Employee e1 = new Employee("Tom Wall", 18, Gender.MALE, 1212121212, a1, a1, 111111111, "tomwall@colla.com",
//				JobTitle.JAVA_DEVELOPER, Department.DEVELOPER, 1111, 4, 0);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(post("/employee/create").contentType(MediaType.APPLICATION_JSON)
//				.content(objMapper.writeValueAsString(e1))).andExpect(status().isCreated());
//	}
//
//	@Test
//	public void testPutEmp() throws Exception {
//		Address a1 = new Address("30 FarView", "Vado", "New Jersey", "USA", 25219);
//		Employee e1 = new Employee("Tom Wall", 18, Gender.MALE, 1212121212, a1, a1, 111111111, "tomwall@colla.com",
//				JobTitle.JAVA_DEVELOPER, Department.DEVELOPER, 1111, 4, 0);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(put("/employee/update?empId=23").contentType(MediaType.APPLICATION_JSON)
//				.content(objMapper.writeValueAsString(e1))).andExpect(status().isBadRequest());
//	}
//
//	@Test
//	public void testDeleteEmpId() throws Exception {
//		mockMvc.perform(delete("/employee/delete?empId=1")).andExpect(status().isNotFound());
//	}
//
//	@Test
//	public void testGetManId() throws Exception {
//		mockMvc.perform(get("/manager/getId?manId=4")).andExpect(status().isNotFound());
//	}
//
//	@Test
//	public void testPostMan() throws Exception {
//		Address a4 = new Address("33 Ema", "Auth St", "New Jersey", "USA", 72374);
//		Employee m1 = new Employee("Jason Torres", 38, Gender.MALE, 1818181818, a4, a4, 444444444,
//				"jasontorres@colla.com", JobTitle.FULL_STACK_DEVELOPER, Department.HR, 1999, 0, 1);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(post("/manager/create").contentType(MediaType.APPLICATION_JSON)
//				.content(objMapper.writeValueAsString(m1))).andExpect(status().isCreated());
//	}
//
//	@Test
//	public void testPutMan() throws Exception {
//		Address a4 = new Address("33 Ema", "Auth St", "New Jersey", "USA", 72374);
//		Employee m1 = new Employee("Jason Torres", 38, Gender.MALE, 1818181818, a4, a4, 444444444,
//				"jasontorres@colla.com", JobTitle.FULL_STACK_DEVELOPER, Department.HR, 1999, 0, 1);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(put("/manager/update?manId=4").contentType(MediaType.APPLICATION_JSON)
//				.content(objMapper.writeValueAsString(m1))).andExpect(status().isBadRequest());
//	}
//
//	@Test
//	public void testDeleteManId() throws Exception {
//		mockMvc.perform(delete("/manager/delete?manId=54")).andExpect(status().isNotFound());
//	}
}
