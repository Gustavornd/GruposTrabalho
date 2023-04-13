/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.aluno.grnd.grupostrabalho;

import java.time.LocalDate;

/**
 *
 * @author gusta
 */
public class MembroDto {
    
    private String grupo;
    private String nome;
    private LocalDate inicio;

    public MembroDto() {
    }
    
    

    public MembroDto(String nomeGrupo, LocalDate dataInicio, String nomeMembro) {
        this.grupo = nomeGrupo;
        this.inicio = dataInicio;
        this.nome = nomeMembro;
    }

    public MembroDto(String grupo, String nome) {
        this.grupo = grupo;
        this.nome = nome;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
//</editor-fold>
}
