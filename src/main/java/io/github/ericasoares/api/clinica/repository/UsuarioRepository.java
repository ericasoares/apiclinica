package io.github.ericasoares.api.clinica.repository;

import io.github.ericasoares.api.clinica.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Page<Usuario> findAllByAtivoTrue(Pageable paginacao);

    UserDetails findByLogin(String login);
}
