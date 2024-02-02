package io.github.ericasoares.api.clinica.service;

import io.github.ericasoares.api.clinica.domain.Paciente;
import io.github.ericasoares.api.clinica.domain.dto.PacienteDetail;
import io.github.ericasoares.api.clinica.domain.dto.PacienteOutBound;
import io.github.ericasoares.api.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;


    @Transactional
    public ResponseEntity<Paciente> cadastrar(Paciente dados) {
        return new ResponseEntity<>(repository.save(dados), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<Paciente> atualizar(Paciente dados) {
        var paciente = repository.getReferenceById(dados.getId());
        paciente.atualizarDados(dados);

        return new ResponseEntity<>(repository.save(paciente), HttpStatus.OK);
    }

    public Page listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(PacienteOutBound::new);
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<String> inativar(Long id) {
        try {
            var paciente = repository.getReferenceById(id);
            paciente.excluir();
            return ResponseEntity.ok("Paciente id: "+id +" deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar paciente: " + e.getMessage());
        }
    }

    public Page listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(PacienteOutBound::new);
    }

    public ResponseEntity<PacienteDetail> detalhar(Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new PacienteDetail(paciente));
    }

}
