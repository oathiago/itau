package br.com.oathiago.itau.controller;

import br.com.oathiago.itau.dto.PasswordRequestDto;
import br.com.oathiago.itau.dto.PasswordResponseDto;
import br.com.oathiago.itau.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/password")
@RequiredArgsConstructor
public class PasswordController {

    private final PasswordService passwordService;

    @PostMapping(path = "/validate/key", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PasswordResponseDto> validateKey(@RequestBody PasswordRequestDto passwordRequestDto) {
        return ResponseEntity.ok(passwordService.validateKey(passwordRequestDto.getKey()));
    }

}
