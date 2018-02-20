package br.com.caelum.mog.domain.models;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Curso> cursos = new ArrayList<>();

    @ManyToOne
    private Cliente cliente;
    private Period periodo;


    /**
     * @deprecated (frameworks only)
     */
    @Deprecated(since = "1.0.0")
    private Proposta() {
    }

    public Proposta(Cliente cliente, Period periodo, Curso... cursos) {
        Assert.notNull(cliente, "Cliente é obrigatório");
        Assert.notNull(periodo, "Período é obrigatório");
        Assert.isTrue(!periodo.isNegative(), "Período não pode ser negativo");
        Assert.isTrue(!periodo.isZero(), "Período não pode ser zero");
        Assert.notEmpty(cursos, "Deve ter pelo menos um curso");


        this.cursos = List.of(cursos);
        this.cliente = cliente;
        this.periodo = periodo;
    }

    public Long getId(){
        return id;
    }

    public List<Curso> getCursos(){
        return cursos;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Period getPeriodo(){
        return periodo;
    }

    public BigDecimal getTotal(){
        return cursos.stream()
                    .map(Curso::getValor)
                    .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
