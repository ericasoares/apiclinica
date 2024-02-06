package io.github.ericasoares.api.clinica.domain;

import io.github.ericasoares.api.clinica.domain.dto.PacienteDto;
import io.github.ericasoares.api.clinica.domain.dto.PacienteUpdate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "paciente")
@Entity(name = "Paciente")

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private Boolean ativo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Paciente(PacienteDto pacienteDto) {
        this.ativo = true;
        this.nome = pacienteDto.nome();
        this.email = pacienteDto.email();
        this.telefone = pacienteDto.telefone();
        this.cpf = pacienteDto.cpf();
        this.endereco = new Endereco(pacienteDto.endereco());
    }

    public Paciente(PacienteUpdate pacienteDto) {
        this.ativo = true;
        this.nome = pacienteDto.nome();
        this.telefone = pacienteDto.telefone();
        this.endereco = new Endereco(pacienteDto.endereco());
    }

    public void atualizarDados(Paciente paciente) {
        if (paciente.getNome() != null) {
            this.nome = paciente.getNome();
        }
        if (paciente.getTelefone() != null) {
            this.telefone = paciente.getTelefone();
        }
        if (paciente.getEndereco() != null) {
            this.endereco.atualizarDados(paciente.getEndereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
