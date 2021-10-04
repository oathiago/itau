package br.com.oathiago.itau.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PasswordServiceImplTest {

    @Spy
    @InjectMocks
    private PasswordServiceImpl passwordService;

    @Test
    void givenEmptyLetters_validateFalseResponseToSize() {
        Assertions.assertFalse(passwordService.validateSize(""));
    }

    @Test
    void givenNineLetters_validateTrueResponseToSize() {
        Assertions.assertTrue(passwordService.validateSize("123456789"));
    }

    @Test
    void givenJustNumber_validateFalseResponseNumbersAndLetters() {
        Assertions.assertFalse(passwordService.validateAlphabeticAndNumericLetters("123456789"));
    }

    @Test
    void givenNumberAndLetters_validateTrueResponseNumbersAndLetters() {
        Assertions.assertTrue(passwordService.validateAlphabeticAndNumericLetters("A1S2D3F4G"));
    }

    @Test
    void givenUpperCaseLetters_validateFalseResponseUpperAndLowerCase() {
        Assertions.assertFalse(passwordService.validateLowerAndUpperCase("ASDFGHJKL"));
    }

    @Test
    void givenUpperAndLowerCaseLetters_validateTrueResponseUpperAndLowerCase() {
        Assertions.assertTrue(passwordService.validateLowerAndUpperCase("ASDFghjkl"));
    }

    @Test
    void givenLettersWithoutSpecialCharacter_validateFalseResponseSpecialCharacters() {
        Assertions.assertFalse(passwordService.validateSpecialCharacters("HJKDASJK8799"));
    }

    @Test
    void givenLettersWithSpecialCharacter_validateTrueResponseSpecialCharacters() {
        Assertions.assertTrue(passwordService.validateSpecialCharacters("HJKD!ASJ%K879*9"));
    }

    @Test
    void givenRepeatedLetters_validateFalseResponseRepeatedLetters() {
        Assertions.assertFalse(passwordService.validateRepeatedCharacter("ASDFGHJKLgtya"));
    }

    @Test
    void givenNonRepeatedLetters_validateTrueResponseRepeatedLetters() {
        Assertions.assertTrue(passwordService.validateSpecialCharacters("ASDFG34567vbnm*#$"));
    }


    @Test
    void givenTwoLetters_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("ab").getValidate());
    }

    @Test
    void givenTwoLettersRepeated_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("aa").getValidate());
    }

    @Test
    void givenLettersWithoutNumbers_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("AAAbbbCc").getValidate());
    }

    @Test
    void givenFullLettersRepeated_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("AbTp9!foA").getValidate());
    }

    @Test
    void givenLettersWithoutSpecialCharacters_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey("AbTp9 fok").getValidate());
    }

    @Test
    void givenCorrectCharacters_validateTrueResponse() {
        Assertions.assertTrue(passwordService.validateKey("AbTp9!fok").getValidate());
    }

    @Test
    void givenNullCharacters_validateFalseResponse() {
        Assertions.assertFalse(passwordService.validateKey(null).getValidate());
    }

}
