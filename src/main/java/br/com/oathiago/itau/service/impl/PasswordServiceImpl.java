package br.com.oathiago.itau.service.impl;

import br.com.oathiago.itau.dto.PasswordDto;
import br.com.oathiago.itau.service.PasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
public class PasswordServiceImpl implements PasswordService {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

    @Override
    public Boolean validateKey(PasswordDto passwordDto) {
        return validateSize(passwordDto.getKey())
                && validateAlphabeticAndNumericLetters(passwordDto.getKey())
                && validateLowerAndUpperCase(passwordDto.getKey())
                && validateSpecialCharacters(passwordDto.getKey())
                && validateRepeatedCharacter(passwordDto.getKey());
    }

    private Boolean validateSize(String key) {
        return key.length() >= 9;
    }

    private Boolean validateAlphabeticAndNumericLetters(String key) {
        return key.chars().anyMatch(Character::isLetter) && key.chars().anyMatch(Character::isDigit);
    }

    private Boolean validateLowerAndUpperCase(String key) {
        return key.chars().anyMatch(Character::isUpperCase) && key.chars().anyMatch(Character::isLowerCase);
    }

    private Boolean validateSpecialCharacters(String key) {
        char[] array = key.toUpperCase(Locale.ROOT).toCharArray();
        int countSpecialCharacters = 0;
        for (char value: array) {
            countSpecialCharacters += (int) SPECIAL_CHARACTERS.toUpperCase(Locale.ROOT).chars().filter(ch -> ch == value).count();
        }
        return countSpecialCharacters > 0;
    }

    private Boolean validateRepeatedCharacter(String key) {
        char[] array = key.toUpperCase(Locale.ROOT).toCharArray();
        for (char value: array) {
            if (key.toUpperCase(Locale.ROOT).chars().filter(ch -> ch == value).count() > 1) {
                log.info(value+"");
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
