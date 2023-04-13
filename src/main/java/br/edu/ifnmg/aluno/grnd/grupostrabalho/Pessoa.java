/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.aluno.grnd.grupostrabalho;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author gusta
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "Pessoa.findAll",
            query = "SELECT p FROM Pessoa p"),
    @NamedQuery(
            name = "Pessoa.findNome",
            query = "SELECT p.nome FROM Pessoa p"),
    @NamedQuery(
            name = "Pessoa.findNomeEndereco",
            query = "SELECT p.nome, p.endereco FROM Pessoa p"),
    @NamedQuery(
            name = "Pessoa.findPessoaInAvenida",
            query = "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1"),
    @NamedQuery(
            name = "Pessoa.findPessoaNotPraca",
            query = "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != 2"),
    @NamedQuery(
            name = "Pessoa.findPessoaNomeTelefone",
            query = "SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t")
})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65, nullable = false)
    private String nome;

    @Column(length = 250)
    private String email;

    private LocalDate nascimento;

    @Transient
    private Byte idade;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Atuacao> atuacoes;

    @OneToMany(mappedBy = "lider",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Grupo> liderGrupos;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Pessoa() {
        this.telefones = new ArrayList<>();
        this.atuacoes = new ArrayList<>();
    }

    public Pessoa(Long id, String nome, String email, LocalDate nascimento, Byte idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.idade = idade;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getteres/Setteres">
    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public List<Grupo> getLiderGrupos() {
        return liderGrupos;
    }

    public void setLiderGrupos(List<Grupo> liderGrupos) {
        this.liderGrupos = liderGrupos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        this.idade = (byte) nascimento.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public Byte getIdade() {
        return idade;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Hashcode/Equals/toString">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nome);
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
        return "Pessoa{" + "id=" + id
                + ", nome=" + nome
                + ", email=" + email
                + ", nascimento=" + nascimento
                + ", idade=" + idade
                + ", endereco=" + endereco
                + '}';
    }

    //</editor-fold>
}
