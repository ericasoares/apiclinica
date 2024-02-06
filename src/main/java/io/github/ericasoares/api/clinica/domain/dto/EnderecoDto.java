package io.github.ericasoares.api.clinica.domain.dto;

import io.github.ericasoares.api.clinica.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDto(
        @NotBlank(message ="Logradouro não pode ser vazio ou nulo")
        String logradouro,
        @NotBlank(message ="Bairro não pode ser vazio ou nulo")
        String bairro,
        @NotBlank(message ="Cep não pode ser vazio ou nulo")
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank(message ="Cidade não pode ser vazio ou nula")
        String cidade,
        @NotBlank(message ="UF não pode ser vazio ou nulo")
        String uf,
        String complemento,
        String numero
) {
        public EnderecoDto(Endereco endereco){
               this(endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(),
                       endereco.getBairro(), endereco.getCidade(), endereco.getUf(),
                       endereco.getCep());
                }
}
