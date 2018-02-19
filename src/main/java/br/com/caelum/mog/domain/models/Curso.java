package br.com.caelum.mog.domain.models;

import java.math.BigDecimal;
import java.time.Duration;

public interface Curso {
    String getNome();

    BigDecimal getValor();

    Duration getCargaHoraria();
}
