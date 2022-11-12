package me.leandrochaves.my_device_manager_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyDeviceManagerApiApplicationTests {

	@Test
	void contextLoads() {
	}

	//  TEST TO VALID PARAMS OF CONTROLLERS
	// @Test
	// public void givenSaveBasicInfo_whenCorrectInput_thenSuccess() throws Exception {
	// 		this.mockMvc.perform(MockMvcRequestBuilders.post("/saveBasicInfo")
	// 			.accept(MediaType.TEXT_HTML)
	// 			.param("name", "test123")
	// 			.param("password", "pass"))
	// 			.andExpect(view().name("success"))
	// 			.andExpect(status().isOk())
	// 			.andDo(print());
	// }

}
