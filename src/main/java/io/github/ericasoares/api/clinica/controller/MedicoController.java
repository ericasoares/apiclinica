package io.github.ericasoares.api.clinica.controller;

import io.github.ericasoares.api.clinica.domain.Medico;
import io.github.ericasoares.api.clinica.domain.dto.MedicoDto;
import io.github.ericasoares.api.clinica.domain.dto.MedicoOutBound;
import io.github.ericasoares.api.clinica.domain.dto.MedicoUpdate;
import io.github.ericasoares.api.clinica.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;


    @PostMapping
    public void cadastrar(@RequestBody @Valid MedicoDto medicoDto){
        Medico medico = new Medico(medicoDto);
        service.cadastrar(medico);
    }

    @GetMapping
    public Page<MedicoOutBound> listar(Pageable paginacao) {
        return service.listar(paginacao);
    }

    @PutMapping
    public ResponseEntity<Medico> atualizar(@RequestBody @Valid MedicoUpdate medicoDto) {
        Medico medico = new Medico(medicoDto);
        return service.atualizar(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> inativar(@PathVariable Long id){
        ResponseEntity<String> responseEntity = service.inativar(id);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(responseEntity.getBody());
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
        }
    }

    @GetMapping("/listarTodos")
    public Page<MedicoOutBound> listarTodos(Pageable paginacao) {
        return service.listarTodos(paginacao);
    }

}
