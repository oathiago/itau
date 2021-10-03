package br.com.oathiago.itau.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PasswordServiceImplTest {

    @Spy
    @InjectMocks
    private PasswordServiceImpl passwordService;

    @Test
    public void givenEmptyLetters_validateFalseResponseToSize() {
        Assertions.assertFalse(passwordService.validateSize(""));
    }

    @Test
    public void givenNineLetters_validateTrueResponseToSize() {
        Assertions.assertTrue(passwordService.validateSize("123456789"));
    }

    @Test
    public void givenJustNumber_validateFalseResponseNumbersAndLetters() {
        Assertions.assertFalse(passwordService.validateAlphabeticAndNumericLetters("123456789"));
    }

    @Test
    public void givenNumberAndLetters_validateTrueResponseNumbersAndLetters() {
        Assertions.assertTrue(passwordService.validateAlphabeticAndNumericLetters("A1S2D3F4G"));
    }

    @Test
    public void givenUpperCaseLetters_validateFalseResponseUpperAndLowerCase() {
        Assertions.assertFalse(passwordService.validateLowerAndUpperCase("ASDFGHJKL"));
    }

    @Test
    public void givenUpperAndLowerCaseLetters_validateTrueResponseUpperAndLowerCase() {
        Assertions.assertTrue(passwordService.validateLowerAndUpperCase("ASDFghjkl"));
    }

    @Test
    public void givenLettersWithoutSpecialCharacter_validateFalseResponseSpecialCharacters() {
        Assertions.assertFalse(passwordService.validateSpecialCharacters("HJKDASJK8799"));
    }

    @Test
    public void givenLettersWithSpecialCharacter_validateTrueResponseSpecialCharacters() {
        Assertions.assertTrue(passwordService.validateSpecialCharacters("HJKD!ASJ%K879*9"));
    }

    @Test
    public void givenRepeatedLetters_validateFalseResponseRepeatedLetters() {
        Assertions.assertFalse(passwordService.validateRepeatedCharacter("ASDFGHJKLgtya"));
    }

    @Test
    public void givenNonRepeatedLetters_validateTrueResponseRepeatedLetters() {
        Assertions.assertTrue(passwordService.validateSpecialCharacters("ASDFG34567vbnm*#$"));
    }


    @Test
    public void givenTwoLetters_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("ab"));
    }

    @Test
    public void givenTwoLettersRepeated_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("aa"));
    }

    @Test
    public void givenLettersWithoutNumbers_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("AAAbbbCc"));
    }

    @Test
    public void givenFullLettersRepeated_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("AbTp9!foA"));
    }

    @Test
    public void givenLettersWithoutSpecialCharacters_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("AbTp9 fok"));
    }

    @Test
    public void givenCorrectCharacters_validateTrueResponse() {
        Assertions.assertTrue(passwordService.validateKey("AbTp9!fok"));
    }

}
