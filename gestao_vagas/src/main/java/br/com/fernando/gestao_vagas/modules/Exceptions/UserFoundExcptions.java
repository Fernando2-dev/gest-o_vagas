package br.com.fernando.gestao_vagas.modules.Exceptions;

public class UserFoundExcptions extends RuntimeException {
    public UserFoundExcptions(String mensagem){
        super(mensagem);
    }
}
