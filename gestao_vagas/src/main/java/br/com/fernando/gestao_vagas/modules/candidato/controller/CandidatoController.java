package br.com.fernando.gestao_vagas.modules.candidato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.gestao_vagas.modules.candidato.CandidatoEntity;
import br.com.fernando.gestao_vagas.modules.candidato.useCaser.CreateCandidato;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

  @Autowired
  private CreateCandidato createCandidato;

  @PostMapping
  @Transactional
  public ResponseEntity<Object> create(@Valid @RequestBody CandidatoEntity canditado) {
    try {
      var result = this.createCandidato.execute(canditado);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

}
