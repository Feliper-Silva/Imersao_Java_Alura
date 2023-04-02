package ExtratorConteudo.IExtrator;

import Conteudo.Conteudo;

import java.util.List;

public interface IExtrator {
    public List<Conteudo> ExtraiConteudos (String json);
}
