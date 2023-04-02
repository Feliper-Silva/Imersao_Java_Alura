import Cliente.ClienteHttp;
import ExtratorConteudo.IExtrator.IExtrator;
import ExtratorConteudo.Imdb.*;
import ExtratorConteudo.Nasa.*;
import Conteudo.Conteudo;

import java.io.InputStream;
import java.net.URL;
import java.util.*;



public class Main {
    public static void main(String[] args) throws Exception {

        /* URL ALURA FILMES*/
        //https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json
        //https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json
        /* URL NASA ALURA */
        //https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json
        /*URL API NASA*/
        //https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";

        var http = new ClienteHttp();
        String json = http.getDados(url);

        IExtrator extratorNasa = new ExtratorNasa();
        List<Conteudo> conteudos = extratorNasa.ExtraiConteudos(json);
        var gerador = new GeradorFigurinhas();
        var numeroRandom = new Random();
        for ( int i = 0; i < conteudos.size(); i++){
            Conteudo conteudo = conteudos.get(i);
            System.out.println(conteudo.getTitle());
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "figurinha"+conteudo.getTitle()+numeroRandom.nextInt()+".png";

            gerador.CriarFigurinha(inputStream,nomeArquivo);
            System.out.println(conteudo.getTitle());
        }
    }
}