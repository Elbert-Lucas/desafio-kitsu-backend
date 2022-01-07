package Firedev.DesafioKitsu.Client;

import Firedev.DesafioKitsu.Domain.Manga;
import Firedev.DesafioKitsu.Util.CreateManga;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MangaClient {

    public Manga getMangaByIdClient(Long id) {
        //Busca um manga pelo ID

    /*
        Este método segue a mesma lógica do metodo getAnimeByIdClient.
        Retorna o Json obtido pela API como uma string que será tratada e transformada em um objeto
     */

        String mangaStr = new RestTemplate().getForObject("https://kitsu.io/api/edge/manga/{id}",
                          String.class, id);

        JSONObject mangaJson = new JSONObject(mangaStr);


        return CreateManga.createMangaWithJson(mangaJson);

    }


    public List<Manga> getMangaByFilterClient(String attribute, String value) {
        //Busca um manga usando qualquer filtro disponibilizado pela API

        String mangaStr = new RestTemplate()
                        .getForObject("https://kitsu.io/api/edge/manga?filter[{attribute}]={value}",
                        String.class, attribute, value);

        JSONObject mangaJson = new JSONObject(mangaStr);

        return CreateManga.createMangasWithJson(mangaJson);
    }

    public List<Manga> getTrendingMangasClient() {
        //Retorna os mangas mais famosos

        String mangaStr = new RestTemplate()
                        .getForObject("https://kitsu.io/api/edge/trending/manga",
                        String.class);

        JSONObject mangaJson = new JSONObject(mangaStr);

        return CreateManga.createMangasWithJson(mangaJson);
    }
}
