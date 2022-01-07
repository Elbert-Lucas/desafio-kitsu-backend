package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.Manga;
import Firedev.DesafioKitsu.Service.MangaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(path = "manga")
public class MangaController {

    private final MangaService mangaService;

    @GetMapping(path = "/{id}")
    @Operation(summary = "Procura um mangá pelo seu ID", description = "Um id deve ser passado, entao " +
    "um mangá único será retonado", tags = {"Manga"})
    public Manga getMangaById(@PathVariable Long id){
        return mangaService.getAnimeByIdService(id);
    }

    @GetMapping("/filter")
    @Operation(summary = "Procura um manga por um filtro", description = "Um tipo de atributo disponibilizado pela API deve ser passado, "
     + "e o valor para este atributo tambem deve ser passados. Multiplos mangas podem ser retornados. Ex: ?attribute=slug&value=one-piece",
    tags = {"Manga"})
    public List<Manga> getMangaByFilter(@RequestParam String attribute, String value){
        return mangaService.getAnimeByFilterService(attribute, value);
    }

    @GetMapping("/trending")
    @Operation(summary = "Retorna os manga mais populares", description = "Retorna os mangas mais populares," +
    " não necessita passar atributos.",
    tags = {"Manga"})
    public List<Manga> getTrendingMangas(){
        return mangaService.getTrendingAnimesService();
    }
}
