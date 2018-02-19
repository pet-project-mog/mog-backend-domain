package br.com.caelum.mog.domain.models;

import java.math.BigDecimal;
import java.time.Period;
import java.util.List;

public interface Proposta {
    List<Curso> getCursos();

    Cliente getCliente();

    Period getPeriodo();

    default BigDecimal getTotal(){
        return getCursos().stream().map(Curso::getValor).reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
