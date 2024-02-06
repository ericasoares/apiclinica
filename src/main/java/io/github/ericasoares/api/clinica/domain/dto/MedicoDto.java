package io.github.ericasoares.api.clinica.domain.dto;

import io.github.ericasoares.api.clinica.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDto(
        @NotBlank(message = "O nome do médico não pode ser vazio ou nulo")
        String nome,
        @NotBlank(message ="O email do médico não pode ser vazio ou nulo")
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank(message ="O registro CRM do médico não pode ser vazio ou nulo")
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull(message ="Especialidade do médico não pode ser nula")
        Especialidade especialidade,
        @NotNull(message ="Endereço do médico não pode ser nulo")
        @Valid
        EnderecoDto endereco
) {
}
