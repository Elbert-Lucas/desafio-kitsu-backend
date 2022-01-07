package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Service.AnimeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component
@RestController
@AllArgsConstructor
@RequestMapping(path = "anime")
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping(path = "/{id}")
    @Operation(summary = "Procura um anime pelo seu ID", description = "Um id deve ser passado, entao " +
    "um anime único será retonado", tags = {"Anime"})
    public Anime getAnimeById(@PathVariable Long id){
        return animeService.getAnimeByIdService(id);
    }


    @GetMapping("/filter")
    @Operation(summary = "Procura um anime por um filtro", description = "Um tipo de atributo disponibilizado pela API deve ser passado, "
    + "e o valor para este atributo tambem deve ser passados. Multiplos animes podem ser retornados. Ex: ?attribute=slug&value=one-piece",
    tags = {"Anime"})
    public List<Anime> getAnimeByFilter(@RequestParam String attribute, String value){
        return animeService.getAnimeByFilterService(attribute, value);
    }

    @GetMapping("/trending")
    @Operation(summary = "Retorna os animes mais populares", description = "Retorna os animes mais populares," +
     " não necessita passar atributos.",
    tags = {"Anime"})
    public List<Anime> getTrendingAnimes(){
        return animeService.getTrendingAnimesService();
    }

}
