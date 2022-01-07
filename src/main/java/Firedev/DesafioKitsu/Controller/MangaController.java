package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.Manga;
import Firedev.DesafioKitsu.Service.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/manga")
public class MangaController {

    private final MangaService mangaService;

    @GetMapping(path = "/{id}")
    public Manga getMangaById(@PathVariable Long id){
        return mangaService.getAnimeByIdService(id);
    }

    @GetMapping()
    public List<Manga> getMangaByFilter(@RequestParam String attribute, String value){
        return mangaService.getAnimeByFilterService(attribute, value);
    }

    @GetMapping("/trending")
    public List<Manga> getTrendingMangas(){
        return mangaService.getTrendingAnimesService();
    }
}
