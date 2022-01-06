package Firedev.DesafioKitsu.Client;

import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Util.CreateAnime;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import java.util.List;

@Service
@Log4j2
public class AnimeClient {

    public  Anime getAnimeByIdClient(long id) {

    /*
        Tentar requisitar os dados da API diretamente para o objeto Anime gera um erro Htpp 406,
        Isso pois o JSON esta aninhado.
        É possivel contornar isso criando diversos objetos referentes à essas chaves aninhadas,
        Porém eu imaginei que isto poderia gerar muitas classes desnecessarias com apenas 1 ou 2 atributos.
        E isso também dificultaria o crescimento do software.

        Decidi entao tratar este erro transformando o JSON em uma string e tratando-o com a biblioteca org.JSON.
        Caso isso prejudique a perfomance eu irei reverter e usar a orientação a objetos.
     */

    String animeStr = new RestTemplate().getForObject("https://kitsu.io/api/edge/anime/{id}",
                      String.class, id);

    JSONObject animeJson = new JSONObject(animeStr);

    return CreateAnime.createAnimeWithJson(animeJson);
    }


    public List<Anime> getAnimeByFilterClient(String attribute, String value) {

        String animeStr = new RestTemplate()
                .getForObject("https://kitsu.io/api/edge/anime?filter[{attribute}]={value}",
                String.class, attribute, value);

        JSONObject animeJson = new JSONObject(animeStr);

        return CreateAnime.createAnimesWithJson(animeJson);
    }
}
