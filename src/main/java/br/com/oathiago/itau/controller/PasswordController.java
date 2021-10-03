package br.com.oathiago.itau.controller;

import br.com.oathiago.itau.dto.PasswordDto;
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
    public ResponseEntity<Boolean> validateKey(@RequestBody PasswordDto passwordDto) {
        return ResponseEntity.ok(passwordService.validateKey(passwordDto.getKey()));
    }

}
