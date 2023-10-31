package br.com.fernando.gestao_vagas.modules.empresa.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "empresa")
@Data
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode ter espaços")
    private String username;

    @Email(message = "O campo deve conter um email válido !")
    private String email;

    @Length(min = 10, max = 100, message = "a senha deve conter entre 10 e 100 caracteres !")
    private String senha;
    private String website;
    private String nome;
    private String descricao;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
