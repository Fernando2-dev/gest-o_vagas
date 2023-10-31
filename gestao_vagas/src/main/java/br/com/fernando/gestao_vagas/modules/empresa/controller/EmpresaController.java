package br.com.fernando.gestao_vagas.modules.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.gestao_vagas.modules.empresa.entidades.EmpresaEntity;
import br.com.fernando.gestao_vagas.modules.empresa.useCase.CreateEmpresa;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private CreateEmpresa createEmpresa;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> create(@RequestBody @Valid EmpresaEntity empresaEntity) {
        try {
            var empresa = this.createEmpresa.execute(empresaEntity);
            return ResponseEntity.ok().body(empresa);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
