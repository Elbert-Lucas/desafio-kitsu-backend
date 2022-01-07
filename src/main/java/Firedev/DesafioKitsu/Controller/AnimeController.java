package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/anime")
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping(path = "/{id}")
    public Anime getAnimeById(@PathVariable Long id){
        return animeService.getAnimeByIdService(id);
    }
    @GetMapping()
    public List<Anime> getAnimeByFilter(@RequestParam String attribute, String value){
        return animeService.getAnimeByFilterService(attribute, value);
    }

    @GetMapping("/trending")
    public List<Anime> getTrendingAnimes(){
        return animeService.getTrendingAnimesService();
    }

}
