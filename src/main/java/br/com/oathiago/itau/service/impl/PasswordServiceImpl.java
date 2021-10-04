package br.com.oathiago.itau.service.impl;

import br.com.oathiago.itau.dto.PasswordResponseDto;
import br.com.oathiago.itau.service.PasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
public class PasswordServiceImpl implements PasswordService {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

    @Override
    public PasswordResponseDto validateKey(String key) {
        return PasswordResponseDto.builder()
                .validate(validateSize(key)
                        && validateAlphabeticAndNumericLetters(key)
                        && validateLowerAndUpperCase(key)
                        && validateSpecialCharacters(key)
                        && validateRepeatedCharacter(key))
                .build();
    }

    public Boolean validateSize(String key) {
        return key != null && key.length() >= 9;
    }

    public Boolean validateAlphabeticAndNumericLetters(String key) {
        return key.chars().anyMatch(Character::isLetter) && key.chars().anyMatch(Character::isDigit);
    }

    public Boolean validateLowerAndUpperCase(String key) {
        return key.chars().anyMatch(Character::isUpperCase) && key.chars().anyMatch(Character::isLowerCase);
    }

    public Boolean validateSpecialCharacters(String key) {
        char[] array = key.toUpperCase(Locale.ROOT).toCharArray();
        int countSpecialCharacters = 0;
        for (char value : array) {
            countSpecialCharacters += (int) SPECIAL_CHARACTERS.toUpperCase(Locale.ROOT).chars().filter(ch -> ch == value).count();
        }
        return countSpecialCharacters > 0;
    }

    public Boolean validateRepeatedCharacter(String key) {
        char[] array = key.toUpperCase(Locale.ROOT).toCharArray();
        for (char value : array) {
            if (key.toUpperCase(Locale.ROOT).chars().filter(ch -> ch == value).count() > 1) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
