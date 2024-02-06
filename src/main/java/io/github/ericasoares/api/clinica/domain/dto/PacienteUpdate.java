package io.github.ericasoares.api.clinica.domain.dto;

import jakarta.validation.constraints.NotNull;

public record PacienteUpdate(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDto endereco) {
}
