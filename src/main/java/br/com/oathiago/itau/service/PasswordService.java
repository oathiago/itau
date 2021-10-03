package br.com.oathiago.itau.service;

import br.com.oathiago.itau.dto.PasswordResponseDto;

public interface PasswordService {

    PasswordResponseDto validateKey(String key);
}
