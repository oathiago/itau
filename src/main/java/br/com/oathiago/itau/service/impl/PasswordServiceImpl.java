package br.com.oathiago.itau.service.impl;

import br.com.oathiago.itau.dto.PasswordDto;
import br.com.oathiago.itau.service.PasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PasswordServiceImpl implements PasswordService {

    @Override
    public Boolean validateKey(PasswordDto passwordDto) {
        if (!validateSize(passwordDto.getKey())) {
            return Boolean.FALSE;
        }
        if (!validateAlphabeticAndNumericLetters(passwordDto.getKey())) {
            return Boolean.FALSE;
        }
        if (!validateLowerAndUpperCase(passwordDto.getKey())) {
            return Boolean.FALSE;
        }
        if (!validateSpecialCharacters(passwordDto.getKey())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
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
        return Boolean.TRUE;
    }
}
