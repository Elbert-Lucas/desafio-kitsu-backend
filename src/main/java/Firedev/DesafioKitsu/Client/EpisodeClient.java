package Firedev.DesafioKitsu.Client;

import Firedev.DesafioKitsu.Domain.Episode;
import Firedev.DesafioKitsu.Util.CreateEpisode;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
@AllArgsConstructor
public class EpisodeClient {


    public Episode getEpisodeByIdClient(Long id) {
    //Busca um episodio pelo ID

    /*
        Este método segue a mesma lógica do metodo getAnimeByIdClient.
        Retorna o Json obtido pela API como uma string que será tratada e transformada em um objeto
     */

        String episodeStr = new RestTemplate().getForObject("https://kitsu.io/api/edge/episodes/{id}",
                String.class, id);

        JSONObject episodeJson = new JSONObject(episodeStr);


        return CreateEpisode.createEpisodeWithJson(episodeJson);

    }


    public Episode getEpisodeOfAnimeClient(String animeID, String episode) {
        //Busca um episodio especifico de um anime

        String episodeStr = new RestTemplate()
                        .getForObject("https://kitsu.io/api/edge/anime/{animeID}/episodes?filter[number]={episode}",
                        String.class, animeID, episode);

        JSONObject episodeJson = new JSONObject(episodeStr);

        return CreateEpisode.createEpisodeWithJson(episodeJson);

    }


}
