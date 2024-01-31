package io.github.ericasoares.api.clinica.domain;

import io.github.ericasoares.api.clinica.domain.dto.MedicoDto;
import io.github.ericasoares.api.clinica.domain.dto.MedicoUpdate;
import io.github.ericasoares.api.clinica.enums.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medico")
@Entity(name = "medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Medico(MedicoDto medicoDto) {
        this.ativo = true;
        this.nome = medicoDto.nome();
        this.email = medicoDto.email();
        this.telefone = medicoDto.telefone();
        this.crm = medicoDto.crm();
        this.especialidade = medicoDto.especialidade();
        this.endereco = new Endereco(medicoDto.enderecoDto());
    }
    public Medico(MedicoUpdate medicoDto) {
        this.Id = medicoDto.id();
        this.nome = medicoDto.nome();
        this.telefone = medicoDto.telefone();
        if(medicoDto.enderecoDto() != null) {
            this.endereco = new Endereco(medicoDto.enderecoDto());
        }
    }

    public void atualizarDados(Medico medico) {
        if(medico.getNome() != null) {
            this.nome = medico.getNome();
        }
        if(medico.getTelefone() != null){
            this.telefone = medico.getTelefone();
        }
        if (medico.getEndereco() != null){
            this.endereco.atualizarDados(medico.getEndereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
