/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package br.edu.ifnmg.aluno.grnd.grupostrabalho;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author gusta
 */
@Transactional
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
public class RelatoriosServlet extends HttpServlet {

    @Inject
    private PessoaServiceLocal pessoaBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RelatoriosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Consultas</h1>");

            
            //<editor-fold defaultstate="collapsed" desc="Questao 1">
            List<Pessoa> pessoasTodasQuery = pessoaBean.findAllPessoaQuery();
            out.println(Json.printJson("1-a) Quais as pessoas cadastradas?", pessoasTodasQuery));

            List<Pessoa> pessoasTodasTyped = pessoaBean.findAllPessoaTyped();
            out.println(Json.printJson("1-b) Quais as pessoas cadastradas?", pessoasTodasTyped));

            List<Pessoa> pessoasTodasNamed = pessoaBean.findAllPessoaNamed();
            out.println(Json.printJson("1-c) Quais as pessoas cadastradas?", pessoasTodasNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 2">
            List<String> nomesPessoasQuery = pessoaBean.findNomePessoaQuery();
            out.println(Json.printJson("2-a) Quais os nomes das pessoas?", nomesPessoasQuery));

            List<String> nomesPessoasTyped = pessoaBean.findNomePessoaTyped();
            out.println(Json.printJson("2-b) Quais os nomes das pessoas?", nomesPessoasTyped));

            List<String> nomesPessoasNamed = pessoaBean.findNomePessoaNamed();
            out.println(Json.printJson("2-c) Quais os nomes das pessoas?", nomesPessoasNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 3">
            List<Pessoa> pessoasNomeEnderecoQuery = pessoaBean.findNomeEnderecoQuery();
            out.println(Json.printJson("3-a) Quais as pessoas e seus respectivos endereços?", pessoasNomeEnderecoQuery));

            List<Pessoa> pessoasNomeEnderecoTyped = pessoaBean.findNomeEnderecoTyped();
            out.println(Json.printJson("3-b) Quais as pessoas e seus respectivos endereços?", pessoasNomeEnderecoTyped));

            List<Object[]> pessoasNomeEnderecoNamed = pessoaBean.findNomeEnderecoNamed();
            out.println(Json.printJson("3-c) Quais as pessoas e seus respectivos endereços ?", pessoasNomeEnderecoNamed));
//            
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 4">
            List<Pessoa> pessoasInAvendaQuery = pessoaBean.findPessoaInAvenidaQuery();
            out.println(Json.printJson("4-a) Quais pessoas moram em avenidas?", pessoasInAvendaQuery));

            List<Pessoa> pessoasInAvendaTyped = pessoaBean.findPessoaInAvenidaTyped();
            out.println(Json.printJson("4-b) Quais as pessoas cadastradas?", pessoasInAvendaTyped));

            List<Pessoa> pessoasInAvendaNamed = pessoaBean.findPessoaInAvenidaNamed();
            out.println(Json.printJson("4-c) Quais as pessoas cadastradas?", pessoasInAvendaNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 5">
            List<Pessoa> pessoasNotPracaQuery = pessoaBean.findPessoaNotPracaQuery();
            out.println(Json.printJson("5-a) Quais pessoas não moram em praças?", pessoasNotPracaQuery));

            List<Pessoa> pessoasNotPracaTyped = pessoaBean.findPessoaNotPracaTyped();
            out.println(Json.printJson("5-b) Quais as pessoas cadastradas?", pessoasNotPracaTyped));

            List<Pessoa> pessoasNotPracaNamed = pessoaBean.findPessoaNotPracaNamed();
            out.println(Json.printJson("5-c) Quais as pessoas cadastradas?", pessoasNotPracaNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 6">
            List<Object[]> pessoaNomeTelefoneQuery = pessoaBean.findPessoaNomeTelefoneQuery();
            out.println(Json.printJson("6-a) Quais pessoas e seus respectivos telefones?", pessoaNomeTelefoneQuery));

            List<Object[]> pessoaNomeTelefoneTyped = pessoaBean.findPessoaNomeTelefoneTyped();
            out.println(Json.printJson("6-b) Quais pessoas e seus respectivos telefones?", pessoaNomeTelefoneTyped));

            List<Object[]> pessoaNomeTelefoneNamed = pessoaBean.findPessoaNomeTelefoneNamed();
            out.println(Json.printJson("6-c) Quais pessoas e seus respectivos telefones?", pessoaNomeTelefoneNamed));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 7">
            List<Pessoa> pessoasPorData = pessoaBean.findPessoaByDate(
                    LocalDate.of(2001, Month.APRIL, 1),
                    LocalDate.of(2004, Month.APRIL, 30));

            out.println(Json.printJson("7) Quais as pessoas que nasceram entre abril de 2001 e abril de 2004?",
                    pessoasPorData));

//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 8">
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 9">
            List<Pessoa> pessoasTelefoneVazio = pessoaBean.findPessoaTelefoneVazio();

            out.println(Json.printJson("9) Quais pessoas não possuem telefone?",
                    pessoasTelefoneVazio));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 10">
            List<String> telefonesPorPessoa = pessoaBean.findQuantidadeTelefonesPorPessoa();

            out.println(Json.printJson("10) Quantos telefones cada pessoa tem?",
                    telefonesPorPessoa));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 11">
            List<Grupo> gruposInativos = pessoaBean.findGruposInativos();

            out.println(Json.printJson("11) Quais grupos não estão ativos?",
                    gruposInativos));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 12">
            List<String[]> lideresGrupos = pessoaBean.findLideresGrupos();

            out.println(Json.printJson("12) Quais são os líderes dos grupos?",
                    lideresGrupos));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 13">
            List<String> membrosGrupo = pessoaBean.findMembrosGrupo("Estudo IV");

            out.println(Json.printJson("13) Quais são os membros do grupo com nome “Estudo IV” com ordenação alfabética inversa?",
                    membrosGrupo));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 14">
            List<Grupo> gruposBeatriz = pessoaBean.findGruposPorLider("Beatriz Yana");

            out.println(Json.printJson("14) Quais são os grupos liderados por “Beatriz Yana”?",
                    gruposBeatriz));
//</editor-fold> 

            //<editor-fold defaultstate="collapsed" desc="Questao 15">
            List<Object[]> atuacaoGrupos = pessoaBean.findDatasAtuacaoGrupo("Cecília Xerxes");

            out.println(Json.printJson("15) Quais são as datas de início e de término da atuação e os grupos nos quais “Cecília Xerxes” é membro?",
                    atuacaoGrupos));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 16">
            List<Grupo> grupoPorNome = pessoaBean.findGrupoByNome("II");

            out.println(Json.printJson("16) Quais são os grupos que contêm “II” em seus nomes?",
                    grupoPorNome));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 17">
            List<Object[]> nomeGrupoQuantidadeMembros = pessoaBean.findNomeGrupoQuantidadeMembros();

            out.println(Json.printJson("17) Quais são os grupos e os respectivos totais de membros distintos já alocados?",
                    nomeGrupoQuantidadeMembros));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 18">
            List<Object[]> nomeGrupoTotalAtuacoes = pessoaBean.findNomeGrupoPorTotalAtuacoes(3L);

            out.println(Json.printJson("18) Quais grupos têm 3 ou mais atuações de membros e quanto são esses totais de atuações?",
                    nomeGrupoTotalAtuacoes));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 19">
            List<String> nomePessoaPorDataEntradaEmGrupo = pessoaBean.findNomePessoaPorDataEntradaEmGrupo(1L, LocalDate.of(2012, Month.JANUARY, 1));

            out.println(Json.printJson("19) Quais membros entraram a partir de 2012 no primeiro grupo?",
                    nomePessoaPorDataEntradaEmGrupo));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 20">
            List<MembroDto> membrosDto = pessoaBean.findMembroDto(LocalDate.of(2012, Month.JANUARY, 1));

            out.println(Json.printJson("20) Quais os grupos, membros e as respectivas datas de entrada daqueles que entraram a partir de 2012 em qualquer grupo?",
                    membrosDto));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 21">
            List<String[]> gruposEPessoaSemDataTermino = pessoaBean.findGruposEPessoaSemDataTermino();

            out.println(Json.printJson("21) Quais os grupos e respectivos membros  que não possuem data de término de atuação em seus grupos?",
                    gruposEPessoaSemDataTermino));
//</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Questao 22">
            List<String[]> liderMembrosGrupos = pessoaBean.findLiderMembrosGrupos();

            out.println(Json.printJson("22) Quais são os grupos  e líderes  com respectivos membros?",
                    liderMembrosGrupos));
//</editor-fold>
                
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
