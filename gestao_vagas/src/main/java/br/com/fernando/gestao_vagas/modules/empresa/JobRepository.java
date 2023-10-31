package br.com.fernando.gestao_vagas.modules.empresa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fernando.gestao_vagas.modules.empresa.entidades.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID>{
    
}
