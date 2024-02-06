package io.github.ericasoares.api.clinica.domain;

import io.github.ericasoares.api.clinica.domain.dto.EnderecoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "endereco")
@Entity(name = "Endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(EnderecoDto enderecoDto) {
        this.logradouro = enderecoDto.logradouro();
        this.numero = enderecoDto.numero();
        this.complemento = enderecoDto.complemento();
        this.bairro = enderecoDto.bairro();
        this.cidade = enderecoDto.cidade();
        this.uf = enderecoDto.uf();
        this.cep = enderecoDto.cep();
    }

    public void atualizarDados(Endereco endereco) {
        if(endereco.getLogradouro() != null){
            this.logradouro = endereco.getLogradouro();
        }
        if(endereco.getNumero() != null){
            this.numero = endereco.getNumero();
        }
        if(endereco.getComplemento() != null){
            this.complemento = endereco.getComplemento();
        }
        if(endereco.getBairro() != null){
            this.bairro = endereco.getBairro();
        }
        if(endereco.getCidade() != null){
            this.cidade = endereco.getCidade();
        }
        if(endereco.getUf() != null){
            this.uf = endereco.getUf();
        }
        if(endereco.getCep() != null){
            this.cep = endereco.getCep();
        }
    }
}
