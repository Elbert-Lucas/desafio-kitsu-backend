package Firedev.DesafioKitsu.Util;

import Firedev.DesafioKitsu.Domain.*;

public class CreateSearch {
    public static PopularSearches createSearch(Anime anime){
        return  PopularSearches.builder()
                .type("Anime")
                .name(anime.getSlug())
                .id(Long.valueOf(anime.getId()))
                .parent(anime.getSlug())
                .build();
    }
    public static PopularSearches createSearch(Manga manga){
        return  PopularSearches.builder()
                .type("Manga")
                .name(manga.getSlug())
                .id(Long.valueOf(manga.getId()))
                .parent(manga.getSlug())
                .build();
    }
    public static PopularSearches createSearch(Episode episode){
        return  PopularSearches.builder()
                .type("Episode")
                .name(episode.getTitle())
                .id(Long.valueOf(episode.getId()))
                .parent(episode.getAnimeName())
                .build();
    }
    public static PopularSearches createSearch(Chapter chapter){
        return  PopularSearches.builder()
                .type("Chapter")
                .name(chapter.getTitle())
                .id(Long.valueOf(chapter.getId()))
                .parent(chapter.getMangaName())
                .build();
    }


}
