package ExtratorConteudo.Imdb;

import Conteudo.Conteudo;
import ExtratorConteudo.IExtrator.IExtrator;
import JsonParse.JsonParse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorImdb implements IExtrator {
    public List<Conteudo> ExtraiConteudos (String json) {

        var parser = new JsonParse();

        List<Map<String, String>> listaAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaAtributos) {
            String title = atributos.get("title");
            String urlImagem = atributos.get("image");

            var conteudo = new Conteudo(title,urlImagem);

            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
