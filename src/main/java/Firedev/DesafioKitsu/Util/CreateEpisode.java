package Firedev.DesafioKitsu.Util;

import Firedev.DesafioKitsu.Domain.Episode;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class CreateEpisode {

    public static Episode createEpisodeWithJson(JSONObject episodeObject){

        JSONObject data = episodeObject.getJSONArray("data").getJSONObject(0);
        JSONObject attributes = data.getJSONObject("attributes");
        JSONObject relationships = data.getJSONObject("relationships");

        String animeName = getAnimeName(relationships);

        return  Episode.builder()
                .animeName(animeName)
                .id(data.getString("id"))
                .synopsis(String.valueOf(attributes.get("synopsis")))
                .title(String.valueOf(attributes.get("canonicalTitle")))
                .airdate(String.valueOf(attributes.get("airdate")))
                .durationInMinutes(String.valueOf(attributes.get("length")))
                .seasonNumber(String.valueOf(attributes.get("seasonNumber")))
                .number(String.valueOf(attributes.get("number")))
                .build();
        }

    private static String getAnimeName(JSONObject relationships){
        String link = relationships.getJSONObject("media").getJSONObject("links").getString("related");

        String animeStr = new RestTemplate().getForObject(link, String.class);
        JSONObject animeJson = new JSONObject(animeStr);

        return CreateAnime.createAnimeWithJson(animeJson).getSlug();

    }
}
