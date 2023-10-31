package br.com.fernando.gestao_vagas.modules.empresa.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.gestao_vagas.modules.empresa.dto.CreateJobDto;
import br.com.fernando.gestao_vagas.modules.empresa.entidades.JobEntity;
import br.com.fernando.gestao_vagas.modules.empresa.useCase.CreateJob;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("empresa/job")
public class JobController {

  private CreateJob createJob;

  @PostMapping
  @Transactional
  public JobEntity create(@RequestBody @Valid CreateJobDto createJobDto, HttpServletRequest http) {
    var empresa = http.getAttribute("empresa");

   var jobEntity = JobEntity.builder()
        .beneficio(createJobDto.getBeneficios())
        .empresaId(UUID.fromString(empresa.toString()))
        .descricao(createJobDto.getDescricao())
        .nivel(createJobDto.getNivel())
        .build();

    return this.createJob.execute(jobEntity);
  }
}
