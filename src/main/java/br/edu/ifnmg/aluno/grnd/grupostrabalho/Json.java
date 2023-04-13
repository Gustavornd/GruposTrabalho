/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.aluno.grnd.grupostrabalho;

import java.util.Locale;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyOrderStrategy;

/**
 *
 * @author gusta
 */
public class Json {
     public static String toJson(Object object) {
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                // [ hh:mm:mm] é opcional para os casos de LocalDate
                .withDateFormat("dd/MM/yyyy[ hh:mm:ss]",
                        Locale.forLanguageTag("pt_BR")
                //                        null
                )
                .withPropertyOrderStrategy(
                        PropertyOrderStrategy.LEXICOGRAPHICAL);
        return JsonbBuilder.create(config).toJson(object);
    }
    
    public static String printJson(String titulo,Object object){
        String texto;
        texto = "<h2>" + titulo + "</h2>" +
        "<details style=\"cursor: pointer;\"> "+
        "<summary>Resposta</summary> "+
        "<p><pre>"+toJson(object)+"</p></pre></details>";
        return texto;
    }
}
