/*package org.basma.store;

import org.basma.store.services.UserService;
import org.basma.store.shared.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BasmaOnlineStoreApplicationTests {

	@Autowired
	private UserService userService;
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void testaddUser() {
		
		UserDto userDto = new UserDto("test", "test", "test@email.com", "test", "Admin");
		userService.createUser(userDto);
		System.out.print(userDto.toString());
	}
	
}*/
