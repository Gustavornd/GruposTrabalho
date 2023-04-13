/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.aluno.grnd.grupostrabalho;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author gusta
 */
@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65)
    private String nome;

    private Boolean ativo = Boolean.TRUE;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "grupo")
    private List<Atuacao> atuacao;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "lider_id")
    @JsonbTransient
    private Pessoa lider;


    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    public List<Atuacao> getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(List<Atuacao> atuacao) {
        this.atuacao = atuacao;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Hash/Equals/toString">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        return "Grupo{" + "id=" + id
                + ", nome=" + nome
                + ", ativo=" + ativo
                + ", atuacao=" + atuacao
                + ", lider=" + lider + '}';
    }

    //</editor-fold>
}
