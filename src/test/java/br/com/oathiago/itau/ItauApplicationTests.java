package br.com.oathiago.itau;

import br.com.oathiago.itau.controller.PasswordController;
import br.com.oathiago.itau.dto.PasswordRequestDto;
import br.com.oathiago.itau.dto.PasswordResponseDto;
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
		PasswordRequestDto passwordRequestDto = PasswordRequestDto.builder().key("AFbTp9!faok").build();
		ResponseEntity<PasswordResponseDto> response = passwordController.validateKey(passwordRequestDto);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertNotNull(response.getBody());
		Assertions.assertFalse(response.getBody().getValidate());
	}

	@Test
	void givenCompletedLetters_validateTrueResponse() {
		PasswordRequestDto passwordRequestDto = PasswordRequestDto.builder().key("AbTp9!fok").build();
		ResponseEntity<PasswordResponseDto> response = passwordController.validateKey(passwordRequestDto);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertNotNull(response.getBody());
		Assertions.assertTrue(response.getBody().getValidate());
	}



}
