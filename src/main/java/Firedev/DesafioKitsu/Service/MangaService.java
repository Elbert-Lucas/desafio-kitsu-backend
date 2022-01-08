package Firedev.DesafioKitsu.Service;


import Firedev.DesafioKitsu.Client.MangaClient;
import Firedev.DesafioKitsu.Domain.Manga;
import Firedev.DesafioKitsu.Domain.PopularSearches;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import Firedev.DesafioKitsu.Util.CreateSearch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MangaService {

    private final PopularSearchService popularSearchService;
    private final MangaClient mangaClient;

    public Manga getAnimeByIdService(Long id){
        Manga manga = mangaClient.getMangaByIdClient(id);

        //Adicionar a pesquisa no banco de dados:
        PopularSearches searchToBeSaved = CreateSearch.createSearch(manga);
        popularSearchService.SaveOrIncrement(searchToBeSaved);

        return manga;
    }

    public List<Manga> getAnimeByFilterService(String attribute, String value){
        if (attribute.isEmpty() || value.isEmpty()){
            throw new BadRequestException("Alguns dos valores passados são invalidos");
        }
        return mangaClient.getMangaByFilterClient(attribute, value);
    }

    public List<Manga> getTrendingAnimesService(){
        return mangaClient.getTrendingMangasClient();
    }
}
