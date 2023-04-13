package br.edu.ifnmg.aluno.grnd.grupostrabalho;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gusta
 */
@Entity
public class Endereco
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private TipoLogradouro tipoLogradouro;

    @Column(length = 150)
    private String logradouro;

    private Integer numero;

    @Column(length = 25)
    private String bairro;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Endereco() {
    }

    public Endereco(TipoLogradouro tipoLogradouro, String logradouro, Integer numero, String bairro) {
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Hash/Equals/toString">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", tipoLogradouro=" + tipoLogradouro + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + '}';
    }
    //</editor-fold>

}
