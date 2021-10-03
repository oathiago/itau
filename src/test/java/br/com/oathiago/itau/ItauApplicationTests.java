package br.com.oathiago.itau;

import br.com.oathiago.itau.controller.PasswordController;
import br.com.oathiago.itau.dto.PasswordDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ItauApplicationTests {

	@Autowired
	private PasswordController passwordController;

	@Test
	void givenRepeatedLetters_validateFalseResponse() {
		PasswordDto passwordDto = PasswordDto.builder().key("AFbTp9!faok").build();
		ResponseEntity<Boolean> response = passwordController.validatePassword(passwordDto);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertNotNull(response.getBody());
		Assertions.assertFalse(response.getBody());
	}

	@Test
	void givenCompletedLetters_validateTrueResponse() {
		PasswordDto passwordDto = PasswordDto.builder().key("AbTp9!fok").build();
		ResponseEntity<Boolean> response = passwordController.validatePassword(passwordDto);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertNotNull(response.getBody());
		Assertions.assertTrue(response.getBody());
	}



}
