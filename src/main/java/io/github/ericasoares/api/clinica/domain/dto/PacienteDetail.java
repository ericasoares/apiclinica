package io.github.ericasoares.api.clinica.domain.dto;

import io.github.ericasoares.api.clinica.domain.Paciente;
import jakarta.validation.constraints.NotNull;

public record PacienteDetail(@NotNull Long id,
                             String cpf,
                             String nome,
                             String email,
                             String telefone,
                             EnderecoDto endereco) {

    public PacienteDetail(Paciente paciente) {
        this(paciente.getId(), paciente.getCpf(),
                paciente.getNome(), paciente.getEmail(),
                paciente.getTelefone(),
        new EnderecoDto(paciente.getEndereco()));
    }

}
