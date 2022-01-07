package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Domain.Episode;
import Firedev.DesafioKitsu.Service.AnimeService;
import Firedev.DesafioKitsu.Service.EpisodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "episode")
@AllArgsConstructor
public class EpisodeController {

    private final EpisodeService episodeService;
    private final AnimeService animeService;

    @GetMapping(path = "/{id}")
    public Episode getEpisodeById(@PathVariable Long id){
        return episodeService.getEpisodeByIdService(id);
    }

    @GetMapping("/of-byId")
    public Episode getEpisodeOfAnimeByID(@RequestParam String animeID, String episode){
        return episodeService.getEpisodeOfAnimeService(animeID, episode);
    }

    @GetMapping("/of-byName")
    public Episode getEpisodeOfAnimebyName(@RequestParam String animeName, String episode){

        String animeID = animeService.getAnimeByFilterService("slug", animeName).get(0).getId();

        return episodeService.getEpisodeOfAnimeService(animeID, episode);
    }


}
