package br.com.fernando.gestao_vagas.modules.empresa.useCase;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fernando.gestao_vagas.modules.Exceptions.UserFoundExcptions;
import br.com.fernando.gestao_vagas.modules.empresa.EmpresaRepository;
import br.com.fernando.gestao_vagas.modules.empresa.entidades.EmpresaEntity;

@Service
public class CreateEmpresa {

    @Autowired
    private EmpresaRepository EmpresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmpresaEntity execute(EmpresaEntity empresa) {
        this.EmpresaRepository
                .findByUsernameOrEmail(empresa.getUsername(), empresa.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundExcptions("Empresa já existente");
                });

        var password = passwordEncoder.encode(empresa.getSenha());
        empresa.setSenha(password);        
        
        return this.EmpresaRepository.save(empresa);
    }
}
