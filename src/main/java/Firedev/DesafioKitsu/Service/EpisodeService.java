package Firedev.DesafioKitsu.Service;

import Firedev.DesafioKitsu.Client.EpisodeClient;
import Firedev.DesafioKitsu.Domain.Episode;
import Firedev.DesafioKitsu.Domain.PopularSearches;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import Firedev.DesafioKitsu.Util.CreateSearch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EpisodeService {
    private final PopularSearchService popularSearchService;
    private final EpisodeClient episodeClient;

    public Episode getEpisodeByIdService(Long id){
        Episode episode = episodeClient.getEpisodeByIdClient(id);

        //Adicionar a pesquisa no banco de dados:
        PopularSearches searchToBeSaved = CreateSearch.createSearch(episode);
        popularSearchService.SaveOrIncrement(searchToBeSaved);

        return episode;
    }

    public Episode getEpisodeOfAnimeService(String animeID, String episode){
        if (animeID.isEmpty() || episode.isEmpty()){
            throw new BadRequestException("Alguns dos valores passados são invalidos");
        }
        Episode episodeOfAnime = episodeClient.getEpisodeOfAnimeClient(animeID, episode);

        //Adicionar a pesquisa no banco de dados:
        PopularSearches searchToBeSaved = CreateSearch.createSearch(episodeOfAnime);
        popularSearchService.SaveOrIncrement(searchToBeSaved);

        return episodeOfAnime;
    }
}
