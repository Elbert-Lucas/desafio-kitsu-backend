package Firedev.DesafioKitsu.Util;

import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Domain.Manga;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateManga {
    public static Manga createMangaWithJson(JSONObject animeJson) {
        // Este metodo deve ser usado em ocasiões onde apenas 1 anime sera encontrado, ex: busca por id

        JSONObject data = animeJson.getJSONObject("data");
        JSONObject attributes = data.getJSONObject("attributes");
        JSONObject relationships = data.getJSONObject("relationships");
        JSONObject posterImage = attributes.getJSONObject("posterImage");

        return Manga.builder()
                .id(data.getString("id"))
                .type(data.getString("type"))
                .slug(attributes.getString("slug"))
                .description(attributes.getString("description"))
                .chapterCount(String.valueOf(attributes.get("chapterCount")))
                .volumeCount(String.valueOf(attributes.get("volumeCount")))
                .poster(posterImage.getString("medium"))
                .build();
    }


    public static List<Manga> createMangasWithJson(JSONObject mangaJson) {
        // Este metodo deve ser usado em ocasiões onde diversos manga serao encontrados, ex: busca nome incompleto

        JSONArray datas = mangaJson.getJSONArray("data");
        JSONObject attributes;
        JSONObject relationships;
        JSONObject posterImage;

        List<Manga> mangas = new ArrayList<>();

        //Loop iterando sobre todas as chaves "data" da API, que representam animes
        for (int p = 0; p < datas.length(); p++) {
            JSONObject data = (JSONObject) datas.get(p);
            attributes = data.getJSONObject("attributes");
            relationships = data.getJSONObject("relationships");
            posterImage = attributes.getJSONObject("posterImage");

            mangas.add(Manga.builder()
                    .id(data.getString("id"))
                    .type(data.getString("type"))
                    .slug(attributes.getString("slug"))
                    .description(attributes.getString("description"))
                    .chapterCount(String.valueOf(attributes.get("chapterCount")))
                    .volumeCount(String.valueOf(attributes.get("volumeCount")))
                    .poster(posterImage.getString("medium"))
                    .build());
        }

        return mangas;
    }
}
