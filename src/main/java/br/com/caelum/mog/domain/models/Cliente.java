package br.com.caelum.mog.domain.models;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;


    /**
     * @deprecated (frameworks only)
     */
    @Deprecated(since = "1.0.0")
    private Cliente() {}

    public Cliente(String nomeFantasia, String razaoSocial, String cnpj) {

        Assert.hasText(nomeFantasia, "Nome fantasia é obrigatório");
        Assert.hasText(razaoSocial, "Razão social é obrigatória.");
        Assert.hasText(cnpj,"CNPJ é obrigatório.");

        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public Long getId(){
        return id;
    }

    public String getNomeFantasia(){
        return nomeFantasia;
    }

    public String getRazaoSocial(){
        return razaoSocial;
    }

    public String getCnpj(){
        return cnpj;
    }
}
