/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package br.edu.ifnmg.aluno.grnd.grupostrabalho;

import javax.ejb.Local;

/**
 *
 * @author Gustavo Rafael Nunes Durães &lt;grnd at aluno.ifnmg.edu.br&gt;
 */
@Local
public interface PessoaServiceLocal {

    /**
     *
     * @param pessoa
     */
    public void save(Pessoa pessoa);

}
