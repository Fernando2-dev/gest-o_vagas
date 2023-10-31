package br.com.fernando.gestao_vagas.modules.candidato.useCaser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.gestao_vagas.modules.Exceptions.UserFoundExcptions;
import br.com.fernando.gestao_vagas.modules.candidato.CandidatoEntity;
import br.com.fernando.gestao_vagas.modules.candidato.CandidatoRepository;

@Service
public class CreateCandidato {

    @Autowired
    private CandidatoRepository repository;

    public CandidatoEntity execute(CandidatoEntity candidato) {
        this.repository
                .findByUsernameOrEmail(candidato.getUsername(), candidato.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundExcptions("Usuário ja existe !");
                });

        return this.repository.save(candidato);
    }

}
