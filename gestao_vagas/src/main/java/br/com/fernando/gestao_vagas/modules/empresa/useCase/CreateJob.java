package br.com.fernando.gestao_vagas.modules.empresa.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.gestao_vagas.modules.empresa.JobRepository;
import br.com.fernando.gestao_vagas.modules.empresa.entidades.JobEntity;

@Service
public class CreateJob {
    
    @Autowired
    private JobRepository JobRepository;

  public JobEntity execute(JobEntity jobEntity){
     return this.JobRepository.save(jobEntity);
  }

}
