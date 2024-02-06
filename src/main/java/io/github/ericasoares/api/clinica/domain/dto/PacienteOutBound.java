package io.github.ericasoares.api.clinica.domain.dto;

import io.github.ericasoares.api.clinica.domain.Paciente;

public record PacienteOutBound(Long id, String cpf, String nome, String email) {

    public PacienteOutBound(Paciente paciente) {
        this(paciente.getId(), paciente.getCpf(), paciente.getNome(), paciente.getEmail());
    }

}
