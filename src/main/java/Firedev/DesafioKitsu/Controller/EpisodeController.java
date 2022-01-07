package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Domain.Episode;
import Firedev.DesafioKitsu.Service.AnimeService;
import Firedev.DesafioKitsu.Service.EpisodeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "episode")
public class EpisodeController {

    private final EpisodeService episodeService;
    private final AnimeService animeService;

    @GetMapping(path = "/{id}")
    @Operation(summary = "Procura um episodio pelo seu ID", description = "Um id deve ser passado, entao " +
     "um episodio único será retonado", tags = {"Episodio"})
    public Episode getEpisodeById(@PathVariable Long id){
        return episodeService.getEpisodeByIdService(id);
    }

    @GetMapping("/of-byId")
    @Operation(summary = "Procura um episodio pelo ID do anime", description = "O ID do anime e o numero do episodio devera ser passado. " +
    "Um episodio único será retonado", tags = {"Episodio"})
    public Episode getEpisodeOfAnimeByID(@RequestParam String animeID, String episode){
        return episodeService.getEpisodeOfAnimeService(animeID, episode);
    }

    @GetMapping("/of-byName")
    @Operation(summary = "Procura um episodio pelo nome do anime", description = "O nome do anime e o numero do episodio devera ser passado. " +
    "Um episodio único será retonado", tags = {"Episodio"})
    public Episode getEpisodeOfAnimebyName(@RequestParam String animeName, String episode){

        String animeID = animeService.getAnimeByFilterService("slug", animeName).get(0).getId();

        return episodeService.getEpisodeOfAnimeService(animeID, episode);
    }


}
