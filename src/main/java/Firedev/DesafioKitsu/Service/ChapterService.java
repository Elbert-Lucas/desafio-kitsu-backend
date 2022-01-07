package Firedev.DesafioKitsu.Service;

import Firedev.DesafioKitsu.Client.ChapterClient;
import Firedev.DesafioKitsu.Domain.Chapter;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ChapterService {

    private final ChapterClient chapterClient;

    public Chapter getChapterByIdService(Long id){
        return chapterClient.getEpisodeByIdClient(id);
    }

    public Chapter getChapterOfMangaService(String mangaID, String chapter){
        if (mangaID.isEmpty() || chapter.isEmpty()){
            throw new BadRequestException("Alguns dos valores passados são invalidos");
        }
        return chapterClient.getEpisodeOfAnimeClient(mangaID, chapter);
    }
}
