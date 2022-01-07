package Firedev.DesafioKitsu.Controller;

import Firedev.DesafioKitsu.Domain.Chapter;
import Firedev.DesafioKitsu.Service.ChapterService;
import Firedev.DesafioKitsu.Service.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "chapter")
@AllArgsConstructor
public class ChapterController {
    private final ChapterService episodeService;
    private final MangaService mangaService;

    @GetMapping(path = "/{id}")
    public Chapter getChapterById(@PathVariable Long id){
        return episodeService.getChapterByIdService(id);
    }

    @GetMapping("/of-byId")
    public Chapter getChapterOfAnimeByID(@RequestParam String mangaID, String chapter){
        return episodeService.getChapterOfMangaService(mangaID, chapter);
    }

    @GetMapping("/of-byName")
    public Chapter getChapterOfAnimebyName(@RequestParam String mangaName, String chapter){

        String mangaID = mangaService.getAnimeByFilterService("slug", mangaName).get(0).getId();

        return episodeService.getChapterOfMangaService(mangaID, chapter);
    }


}
