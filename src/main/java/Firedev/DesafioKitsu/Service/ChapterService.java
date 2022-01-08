package Firedev.DesafioKitsu.Service;

import Firedev.DesafioKitsu.Client.ChapterClient;
import Firedev.DesafioKitsu.Domain.Chapter;
import Firedev.DesafioKitsu.Domain.PopularSearches;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import Firedev.DesafioKitsu.Util.CreateSearch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ChapterService {
    private final PopularSearchService popularSearchService;
    private final ChapterClient chapterClient;

    public Chapter getChapterByIdService(Long id){
        Chapter chapter = chapterClient.getEpisodeByIdClient(id);

        //Adicionar a pesquisa no banco de dados:
        PopularSearches searchToBeSaved = CreateSearch.createSearch(chapter);
        popularSearchService.SaveOrIncrement(searchToBeSaved);

        return chapter;
    }

    public Chapter getChapterOfMangaService(String mangaID, String chapter){
        if (mangaID.isEmpty() || chapter.isEmpty()){
            throw new BadRequestException("Alguns dos valores passados são invalidos");
        }
        Chapter chapterOfManga = chapterClient.getEpisodeOfAnimeClient(mangaID, chapter);

        //Adicionar a pesquisa no banco de dados:
        PopularSearches searchToBeSaved = CreateSearch.createSearch(chapterOfManga);
        popularSearchService.SaveOrIncrement(searchToBeSaved);


        return chapterOfManga;
    }
}
