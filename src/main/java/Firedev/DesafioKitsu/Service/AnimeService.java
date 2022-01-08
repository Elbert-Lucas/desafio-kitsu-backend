package Firedev.DesafioKitsu.Service;

import Firedev.DesafioKitsu.Client.AnimeClient;
import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Domain.PopularSearches;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import Firedev.DesafioKitsu.Util.CreateSearch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimeService {
    private final PopularSearchService popularSearchService;
    private final AnimeClient animeClient;

    public Anime getAnimeByIdService(Long id){
        Anime anime = animeClient.getAnimeByIdClient(id);

        //Adicionar a pesquisa no banco de dados:
        PopularSearches searchToBeSaved = CreateSearch.createSearch(anime);
        popularSearchService.SaveOrIncrement(searchToBeSaved);

        return anime;
    }

    public List<Anime> getAnimeByFilterService(String attribute, String value){
        if (attribute.isEmpty() || value.isEmpty()){
            throw new BadRequestException("Alguns dos valores passados são invalidos");
        }
        List<Anime> animeList = animeClient.getAnimeByFilterClient(attribute, value);

        //Adicionar a pesquisa que estao na lista no banco de dados:
        animeList.
                forEach(anime -> popularSearchService.SaveOrIncrement(CreateSearch.createSearch(anime)));

        return animeList;
    }
    public List<Anime> getTrendingAnimesService(){
       return animeClient.getTrendingAnimesClient();
    }
}
