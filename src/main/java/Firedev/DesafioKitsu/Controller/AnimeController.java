package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Client.AnimeClient;
import Firedev.DesafioKitsu.Domain.Anime;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
}
