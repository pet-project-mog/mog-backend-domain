package br.com.caelum.mog.domain.repositories;

import br.com.caelum.mog.domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

    void save(Cliente cliente);
    Optional<Cliente> findById(Long id);

}
