package br.com.fernando.gestao_vagas.modules.empresa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.gestao_vagas.modules.empresa.dto.AuthEmpresaDto;
import br.com.fernando.gestao_vagas.modules.empresa.useCase.AuthEmpresaUseCase;

@RestController
@RequestMapping("/auth")
public class AuthEmpresaController {

    @Autowired
    private AuthEmpresaUseCase authEmpresaUseCase;

    @PostMapping("/empresa")
    public ResponseEntity<Object> create(@RequestBody AuthEmpresaDto authEmpresaDto) {
        try {
            var sucesso = this.authEmpresaUseCase.execute(authEmpresaDto);
            return ResponseEntity.ok().body(sucesso);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }
}
