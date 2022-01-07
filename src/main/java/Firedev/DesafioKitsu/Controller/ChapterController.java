package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.Chapter;
import Firedev.DesafioKitsu.Service.ChapterService;
import Firedev.DesafioKitsu.Service.MangaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "chapter")
public class ChapterController {
    private final ChapterService episodeService;
    private final MangaService mangaService;

    @GetMapping(path = "/{id}")
    @Operation(summary = "Procura um capitulo pelo seu ID", description = "Um id deve ser passado, entao " +
            "um capitulo único será retonado", tags = {"Capitulo"})
    public Chapter getChapterById(@PathVariable Long id){
        return episodeService.getChapterByIdService(id);
    }

    @GetMapping("/of-byId")
    @Operation(summary = "Procura um capitulo pelo ID do manga", description = "O ID do manga e o numero do capitulo devera ser passado. " +
    "Um capitulo único será retonado", tags = {"Capitulo"})
    public Chapter getChapterOfAnimeByID(@RequestParam String mangaID, String chapter){
        return episodeService.getChapterOfMangaService(mangaID, chapter);
    }

    @GetMapping("/of-byName")
    @Operation(summary = "Procura um capitulo pelo nome do manga", description = "O nome do manga e o numero do capitulo devera ser passado. " +
    "Um capitulo único será retonado", tags = {"Capitulo"})
    public Chapter getChapterOfAnimebyName(@RequestParam String mangaName, String chapter){

        String mangaID = mangaService.getAnimeByFilterService("slug", mangaName).get(0).getId();

        return episodeService.getChapterOfMangaService(mangaID, chapter);
    }


}
