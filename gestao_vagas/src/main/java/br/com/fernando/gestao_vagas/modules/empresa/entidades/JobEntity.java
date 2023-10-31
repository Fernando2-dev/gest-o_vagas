package br.com.fernando.gestao_vagas.modules.empresa.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name ="job")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private String beneficio;

    @NotBlank(message = "esse campo é obrigatório")
    private String nivel;
    
    @ManyToOne()
    @JoinColumn(name = "empresa_id", insertable = false, updatable = false)
    private EmpresaEntity empresaEntity;

    @Column(name = "empresa_id")
    private UUID empresaId;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

}
