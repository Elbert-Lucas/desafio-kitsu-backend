package Firedev.DesafioKitsu.Util;

import Firedev.DesafioKitsu.Domain.Chapter;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class CreateChapter{

        public static Chapter createEpisodeWithJson(JSONObject chapterObject){

            JSONObject data = chapterObject.getJSONArray("data").getJSONObject(0);
            JSONObject attributes = data.getJSONObject("attributes");
            JSONObject relationships = data.getJSONObject("relationships");

            String mangaName = getMangaName(relationships);

            return  Chapter.builder()
                    .mangaName(mangaName)
                    .id(data.getString("id"))
                    .synopsis(String.valueOf(attributes.get("synopsis")))
                    .title(String.valueOf(attributes.get("canonicalTitle")))
                    .publised(String.valueOf(attributes.get("published")))
                    .pages(String.valueOf(attributes.get("length")))
                    .volumeNumber(String.valueOf(attributes.get("volumeNumber")))
                    .number(String.valueOf(attributes.get("number")))
                    .build();
        }

        private static String getMangaName(JSONObject relationships){
            String link = relationships.getJSONObject("manga").getJSONObject("links").getString("related");

            String chapterStr = new RestTemplate().getForObject(link, String.class);
            JSONObject mangaJson = new JSONObject(chapterStr);
            return CreateManga.createMangaWithJson(mangaJson).getSlug();

        }
   }

