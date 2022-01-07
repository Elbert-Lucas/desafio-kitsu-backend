package Firedev.DesafioKitsu.Client;

import Firedev.DesafioKitsu.Domain.Chapter;
import Firedev.DesafioKitsu.Domain.Episode;
import Firedev.DesafioKitsu.Util.CreateChapter;
import Firedev.DesafioKitsu.Util.CreateEpisode;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@AllArgsConstructor
public class ChapterClient {

    public Chapter getEpisodeByIdClient(Long id) {
        //Busca um manga pelo ID

    /*
        Este método segue a mesma lógica do metodo getAnimeByIdClient.
        Retorna o Json obtido pela API como uma string que será tratada e transformada em um objeto
     */

        String chapterStr = new RestTemplate().getForObject("https://kitsu.io/api/edge/chapters/{id}",
                            String.class, id);

        JSONObject chapterJson = new JSONObject(chapterStr);


        return CreateChapter.createEpisodeWithJson(chapterJson);

    }


    public Chapter getEpisodeOfAnimeClient(String mangaID, String chapter) {
        //Busca um capitulo especifico de um manga

        String mangaStr = new RestTemplate()
                .getForObject("https://kitsu.io/api/edge/manga/{mangaID}/chapters?filter[number]={chapter}",
                        String.class, mangaID, chapter);

        JSONObject chapterJson = new JSONObject(mangaStr);

        return CreateChapter.createEpisodeWithJson(chapterJson);

    }
}
