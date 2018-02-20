package br.com.caelum.mog.domain.repositories;

import br.com.caelum.mog.domain.models.Proposta;

import java.util.Optional;

public interface PropostaRepository {
    void save(Proposta proposta);
    Optional<Proposta> findById(Long id);
}
