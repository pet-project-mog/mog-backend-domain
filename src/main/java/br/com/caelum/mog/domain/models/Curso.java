package br.com.caelum.mog.domain.models;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Duration;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private Duration cargaHoraria;

    /**
     * @deprecated (frameworks only)
     */
    @Deprecated(since = "1.0.0")
    private Curso() { }

    public Curso(String nome, BigDecimal valor, Duration cargaHoraria) {

        Assert.hasText(nome, "Nome é obrigatório");
        Assert.notNull(valor, "Preço é obrigatório");
        Assert.isTrue(valor.compareTo(BigDecimal.ZERO) > 0, "Preço deve ser maior que zero");
        Assert.notNull(cargaHoraria, "Carga horária é obrigatória");
        Assert.isTrue(!cargaHoraria.isNegative(), "Carga horária não pode ser negativa");
        Assert.isTrue(!cargaHoraria.isZero(), "Carga horária não pode ser zero");

        this.nome = nome;
        this.valor = valor;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public BigDecimal getValor(){
        return valor;
    }

    public Duration getCargaHoraria(){
        return cargaHoraria;
    }
}
