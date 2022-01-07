package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Client.AnimeClient;
import Firedev.DesafioKitsu.Client.MangaClient;
import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Domain.Manga;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping(path = "/manga")
public class MangaController {

    MangaClient mangaClient;

    @GetMapping(path = "/{id}")
    public Manga getMangaById(@PathVariable long id){
        return mangaClient.getMangaByIdClient(id);
    }

    @GetMapping()
    public List<Manga> getMangaByFilter(@RequestParam String attribute, String value){
        return mangaClient.getMangaByFilterClient(attribute, value);
    }

    @GetMapping("/trending")
    public List<Manga> getTrendingMangas(){
        return mangaClient.getTrendingMangas();
    }
}
