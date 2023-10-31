package br.com.fernando.gestao_vagas.modules.empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthEmpresaDto {
    private String password;
    private String username;
}
