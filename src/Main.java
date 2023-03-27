import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws Exception {

        //fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();

        var response = client.send(request, BodyHandlers.ofString());
        var body = response.body();

        System.out.println(body);

        var parse = new JsonParse();

        List<Map<String, String>> listaFilmes = parse.parse(body);

        for (Map<String, String> filme :listaFilmes ) {
            System.out.println("---------------------------------------------------------");
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("year"));
            System.out.println("---------------------------------------------------------");
        }
    }
}