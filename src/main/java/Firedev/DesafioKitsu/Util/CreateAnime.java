package Firedev.DesafioKitsu.Util;

import Firedev.DesafioKitsu.Domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Log4j2

public class CreateAnime {

    public static Anime createAnimeWithJson(JSONObject animeJson){
        JSONObject data = animeJson.getJSONObject("data");
        JSONObject attributes = data.getJSONObject("attributes");
        JSONObject relationships = data.getJSONObject("relationships");

        return Anime.builder()
                .id(data.getString("id"))
                .type(data.getString("type"))
                .slug(attributes.getString("slug"))
                .description(attributes.getString("description"))
                .build();
    }

    public static List<Anime> createAnimesWithJson(JSONObject animeJson){
        JSONArray datas = animeJson.getJSONArray("data");
        JSONObject attributes;
        JSONObject relationships;

        List<Anime> animes = new ArrayList<>();

        for (int p = 0; p<datas.length(); p++){
            JSONObject data = (JSONObject) datas.get(p);
            attributes = data.getJSONObject("attributes");
            relationships =  data.getJSONObject("relationships");

            animes.add(Anime.builder()
                    .id(data.getString("id"))
                    .type(data.getString("type"))
                    .slug(attributes.getString("slug"))
                    .description(attributes.getString("description"))
                    .build());
        }

        return animes;
    }


}
