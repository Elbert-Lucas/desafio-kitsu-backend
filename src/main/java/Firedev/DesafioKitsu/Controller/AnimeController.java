package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Client.AnimeClient;
import Firedev.DesafioKitsu.Domain.Anime;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping(path = "/anime")
public class AnimeController {

    AnimeClient animeClient;

    @GetMapping(path = "/{id}")
    public Anime getAnimeById(@PathVariable long id){
        return animeClient.getAnimeByIdClient(id);
    }
    @GetMapping()
    public List<Anime> getAnimeByFilter(@RequestParam String attribute, String value){
        return animeClient.getAnimeByFilterClient(attribute, value);
    }

    @GetMapping("/trending")
    public List<Anime> getTrendingAnimes(){
        return animeClient.getTrendingAnimes();
    }
}
