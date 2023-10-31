package br.com.fernando.gestao_vagas.modules.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private String mensagem;
    private String campo;
}
