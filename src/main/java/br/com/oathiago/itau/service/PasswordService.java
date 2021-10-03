package br.com.oathiago.itau.service;

import br.com.oathiago.itau.dto.PasswordDto;

public interface PasswordService {

    Boolean validateKey(PasswordDto passwordDto);
}
