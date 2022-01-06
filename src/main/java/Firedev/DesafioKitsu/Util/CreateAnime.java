package Firedev.DesafioKitsu.Util;

import Firedev.DesafioKitsu.Domain.Anime;
import org.json.JSONObject;

public class CreateAnime {
    public static Anime createAnimeWithJson(JSONObject data){
        JSONObject attributes = data.getJSONObject("attributes");
        JSONObject relationships = data.getJSONObject("relationships");


        return Anime.builder()
                    .id(data.getString("id"))
                    .type(data.getString("type"))
                    .slug(attributes.getString("slug"))
                    .description(attributes.getString("description"))
                    .build();
    }


}
