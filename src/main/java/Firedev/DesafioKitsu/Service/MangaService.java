package Firedev.DesafioKitsu.Service;


import Firedev.DesafioKitsu.Client.MangaClient;
import Firedev.DesafioKitsu.Domain.Manga;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MangaService {
    MangaClient mangaClient;

    public Manga getAnimeByIdService(Long id){
        return mangaClient.getMangaByIdClient(id);
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
