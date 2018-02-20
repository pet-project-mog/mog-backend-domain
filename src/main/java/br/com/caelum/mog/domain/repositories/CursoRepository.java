package br.com.caelum.mog.domain.repositories;

import br.com.caelum.mog.domain.models.Curso;

import java.util.Optional;

public interface CursoRepository {
    void save(Curso curso);
    Optional<Curso> findById(Long id);
}
