package br.com.fernando.gestao_vagas.modules.empresa.dto;

import lombok.Data;

@Data
public class CreateJobDto {
    private String descricao;
    private String nivel;
    private String beneficios;
}
