/**
 * 
 */
package com.collabera;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.collabera.ems.model.Address;
//import com.collabera.ems.model.Employee;
//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author rutpatel
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EMSControllerTest {

//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	public void testGetEmpId() throws Exception {
//		Address a2 = new Address("109 Walgreen", "Sear", "New York", "USA", 35055);
//		Employee e2 = new Employee(2, "Brad Daniel", 22, 1, 1010101010, a2, a2, 222222222, "braddaniel@colla.com", 1, 1,
//				2222, 5, 0);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(get("/employee/get?empId=2")).andExpect(status().isOk())
//				.andExpect(content().json(objMapper.writeValueAsString(e2)));
//	}
//
//	@Test
//	public void testPostEmp() throws Exception {
//		Address a1 = new Address("30 FarView", "Vado", "New Jersey", "USA", 25219);
//		Employee e1 = new Employee(1, "Tom Wall", 18, 1, 1212121212, a1, a1, 111111111, "tomwall@colla.com", 1, 1, 1111,
//				4, 0);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(post("/employee/create").contentType(MediaType.APPLICATION_JSON)
//				.content(objMapper.writeValueAsString(e1))).andExpect(status().isOk())
//				.andExpect(content().json(objMapper.writeValueAsString(e1)));
//	}
//
//	@Test
//	public void testPutEmp() throws Exception {
//		Address a1 = new Address("30 FarView", "Vado", "New Jersey", "USA", 25219);
//		Employee e1 = new Employee(1, "Tom Wall", 18, 1, 1212121212, a1, a1, 111111111, "tomwall@colla.com", 1, 1, 1111,
//				4, 0);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(put("/employee/update?empId=1").contentType(MediaType.APPLICATION_JSON)
//				.content(objMapper.writeValueAsString(e1))).andExpect(status().isOk())
//				.andExpect(content().json(objMapper.writeValueAsString(e1)));
//	}
//
//	@Test
//	public void testDeleteEmpId() throws Exception {
//		mockMvc.perform(delete("/employee/delete?empId=1")).andExpect(status().isAccepted());
//	}
//
//	@Test
//	public void testGetManId() throws Exception {
//		Address a4 = new Address("33 Ema", "Auth St", "New Jersey", "USA", 72374);
//		Employee m1 = new Employee(4, "Jason Torres", 38, 1, 1818181818, a4, a4, 444444444, "jasontorres@colla.com", 2,
//				2, 1999, 0, 1);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(get("/manager/get?manId=4")).andExpect(status().isOk())
//				.andExpect(content().json(objMapper.writeValueAsString(m1)));
//	}
//
//	@Test
//	public void testPostMan() throws Exception {
//		Address a4 = new Address("33 Ema", "Auth St", "New Jersey", "USA", 72374);
//		Employee m1 = new Employee(4, "Jason Torres", 38, 1, 1818181818, a4, a4, 444444444, "jasontorres@colla.com", 2,
//				2, 1999, 0, 1);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(post("/manager/create").contentType(MediaType.APPLICATION_JSON)
//				.content(objMapper.writeValueAsString(m1))).andExpect(status().isOk())
//				.andExpect(content().json(objMapper.writeValueAsString(m1)));
//	}
//
//	@Test
//	public void testPutMan() throws Exception {
//		Address a4 = new Address("33 Ema", "Auth St", "New Jersey", "USA", 72374);
//		Employee m1 = new Employee(4, "Jason Torres", 38, 1, 1818181818, a4, a4, 444444444, "jasontorres@colla.com", 2,
//				2, 1999, 0, 1);
//		ObjectMapper objMapper = new ObjectMapper();
//
//		mockMvc.perform(put("/manager/update?manId=4").contentType(MediaType.APPLICATION_JSON)
//				.content(objMapper.writeValueAsString(m1))).andExpect(status().isOk())
//				.andExpect(content().json(objMapper.writeValueAsString(m1)));
//	}
//
//	@Test
//	public void testDeleteManId() throws Exception {
//		mockMvc.perform(delete("/manager/delete?manId=5")).andExpect(status().isAccepted());
//	}
}
