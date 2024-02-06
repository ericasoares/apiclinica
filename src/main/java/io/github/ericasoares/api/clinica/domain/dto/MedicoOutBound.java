package io.github.ericasoares.api.clinica.domain.dto;

import io.github.ericasoares.api.clinica.domain.Medico;
import io.github.ericasoares.api.clinica.enums.Especialidade;

public record MedicoOutBound(
    Long id,
    String nome,
    String email,
    String crm,
    Especialidade especialidade
) {

    public MedicoOutBound(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
