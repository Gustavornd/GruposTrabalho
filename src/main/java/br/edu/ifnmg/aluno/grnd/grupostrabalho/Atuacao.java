/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.aluno.grnd.grupostrabalho;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gustavo Rafael Nunes Durães &lt;grnd at aluno.ifnmg.edu.br&gt;
 */
@Entity
public class Atuacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private LocalDate inicio;
    private LocalDate termino;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    @JsonbTransient
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grupo_id")
    @JsonbTransient
    private Grupo grupo;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    

    
    public Atuacao() {
    }

    public Atuacao(LocalDate inicio, LocalDate termino, Grupo grupo,Pessoa pessoa) {
        this.inicio = inicio;
        this.termino = termino;
        this.grupo = grupo;
        this.pessoa = pessoa;
    }

    public Atuacao(LocalDate inicio, Grupo grupo, Pessoa pessoa) {
        this.inicio = inicio;
        this.grupo = grupo;
        this.pessoa = pessoa;
    }
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Get/Set">
    

    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    
    
    

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Hash/Equals/toString">
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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

    //</editor-fold>
    

    @Override
    public String toString() {
        return "br.edu.ifnmg.aluno.grnd.grupostrabalho.Atuacao[ id=" + id + " ]";
    }
    
}
