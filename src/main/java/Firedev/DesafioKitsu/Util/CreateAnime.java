package Firedev.DesafioKitsu.Util;

import Firedev.DesafioKitsu.Domain.Anime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CreateAnime{
    public static Anime createAnimeWithJson(JSONObject animeJson) {
        // Este metodo deve ser usado em ocasiões onde apenas 1 anime sera encontrado, ex: busca por id

        JSONObject data = animeJson.getJSONObject("data");
        JSONObject attributes = data.getJSONObject("attributes");
        JSONObject relationships = data.getJSONObject("relationships");
        JSONObject posterImage = attributes.getJSONObject("posterImage");

        return Anime.builder()
                .id(data.getString("id"))
                .type(data.getString("type"))
                .slug(attributes.getString("slug"))
                .description(attributes.getString("description"))
                .episodeCount(String.valueOf(attributes.get("episodeCount")))
                .poster(posterImage.getString("medium"))
                .build();
    }


    public static List<Anime> createAnimesWithJson(JSONObject animeJson) {
        // Este metodo deve ser usado em ocasiões onde diversos animes serao encontrados, ex: busca nome incompleto

        JSONArray datas = animeJson.getJSONArray("data");
        JSONObject attributes;
        JSONObject relationships;
        JSONObject posterImage;

        List<Anime> animes = new ArrayList<>();

        //Loop iterando sobre todas as chaves "data" da API, que representam animes
        for (int p = 0; p < datas.length(); p++) {
            JSONObject data = (JSONObject) datas.get(p);
            attributes = data.getJSONObject("attributes");
            relationships = data.getJSONObject("relationships");
            posterImage = attributes.getJSONObject("posterImage");

            animes.add(Anime.builder()
                    .id(data.getString("id"))
                    .type(data.getString("type"))
                    .slug(attributes.getString("slug"))
                    .description(attributes.getString("description"))
                    .episodeCount(String.valueOf(attributes.get("episodeCount")))
                    .poster(posterImage.getString("medium"))
                    .build());
        }

        return animes;
    }
}
