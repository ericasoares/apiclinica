package io.github.ericasoares.api.clinica.domain.dto;

import io.github.ericasoares.api.clinica.domain.Medico;
import io.github.ericasoares.api.clinica.enums.Especialidade;
import jakarta.validation.constraints.NotNull;

public record MedicoDetail(
    @NotNull
    Long id,
    String nome,
    String email,
    String crm,
    String telefone,
    Especialidade especialidade,
    EnderecoDto endereco
) {
    public MedicoDetail(Medico medico) {
        this(medico.getId(), medico.getNome(),
             medico.getEmail(), medico.getCrm(),
             medico.getTelefone(), medico.getEspecialidade(),
             new EnderecoDto(medico.getEndereco())
        );
    }
}
