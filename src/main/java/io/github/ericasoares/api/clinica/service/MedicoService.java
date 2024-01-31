package io.github.ericasoares.api.clinica.service;

import io.github.ericasoares.api.clinica.domain.Medico;
import io.github.ericasoares.api.clinica.domain.dto.MedicoOutBound;
import io.github.ericasoares.api.clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository repository;


    @Transactional
    public ResponseEntity<Medico> cadastrar(Medico dados) {
        return new ResponseEntity<>(repository.save(dados), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<Medico> atualizar(Medico dados) {
        var medico = repository.getReferenceById(dados.getId());
        medico.atualizarDados(dados);

        return new ResponseEntity<>(repository.save(medico), HttpStatus.CREATED);
    }

    public Page listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(MedicoOutBound::new);
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<String> inativar(Long id) {
        try {
            var medico = repository.getReferenceById(id);
            medico.excluir();
            return ResponseEntity.ok("Medico id: "+id +" deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar medico: " + e.getMessage());
        }
    }


    public Page listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(MedicoOutBound::new);
    }

}
