package io.github.ericasoares.api.clinica.controller;

import io.github.ericasoares.api.clinica.domain.Paciente;
import io.github.ericasoares.api.clinica.domain.dto.PacienteDetail;
import io.github.ericasoares.api.clinica.domain.dto.PacienteDto;
import io.github.ericasoares.api.clinica.domain.dto.PacienteOutBound;
import io.github.ericasoares.api.clinica.domain.dto.PacienteUpdate;
import io.github.ericasoares.api.clinica.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;


    @Transactional
    @PostMapping
    public ResponseEntity<Paciente> cadastrar(@RequestBody @Valid PacienteDto dados) {
        return service.cadastrar(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteOutBound> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return service.listar(paginacao);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<Paciente> atualizar(@RequestBody @Valid PacienteUpdate dados) {
        return service.atualizar(new Paciente(dados));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> inativar(@PathVariable Long id){
        ResponseEntity<String> responseEntity = service.inativar(id);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(responseEntity.getBody());
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDetail> detalhar(@PathVariable Long id){
        //ResponseEntity<Medico> responseEntity = service.detalhar(id);
        return service.detalhar(id);
    }

}
