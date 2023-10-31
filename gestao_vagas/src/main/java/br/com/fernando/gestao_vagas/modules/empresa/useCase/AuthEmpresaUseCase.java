package br.com.fernando.gestao_vagas.modules.empresa.useCase;

import java.time.Duration;
import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fernando.gestao_vagas.modules.empresa.EmpresaRepository;
import br.com.fernando.gestao_vagas.modules.empresa.dto.AuthEmpresaDto;

@Service
public class AuthEmpresaUseCase {
    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthEmpresaDto authEmpresaDto) throws AuthenticationException {
        var empresa = this.empresaRepository.findByUsername(authEmpresaDto.getUsername())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("user not found");
                });
        // verificar se as senhas são iguais !
        var password = this.passwordEncoder.matches(authEmpresaDto.getPassword(), empresa.getSenha());
        // lançar uma exception caso a senha seja diferente !
        if (!password) {
            throw new AuthenticationException();
        }
        // caso esteja tudo ok, lançar o token de autenticação do usuário !
        Algorithm algoritimo = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("javagas")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(empresa.getId().toString())
                .sign(algoritimo);

        return token;
    }

}
