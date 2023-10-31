package br.com.fernando.gestao_vagas.modules.candidato;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<CandidatoEntity, UUID>{
 
    Optional<CandidatoEntity> findByUsernameOrEmail(String username, String email); 


}
