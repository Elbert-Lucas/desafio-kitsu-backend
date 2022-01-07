package Firedev.DesafioKitsu.Service;

import Firedev.DesafioKitsu.Client.AnimeClient;
import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimeService {

    private final AnimeClient animeClient;

    public Anime getAnimeByIdService(Long id){
        return animeClient.getAnimeByIdClient(id);
    }

    public List<Anime> getAnimeByFilterService(String attribute, String value){
        if (attribute.isEmpty() || value.isEmpty()){
            throw new BadRequestException("Alguns dos valores passados são invalidos");
        }
        return animeClient.getAnimeByFilterClient(attribute, value);
    }
    public List<Anime> getTrendingAnimesService(){
       return animeClient.getTrendingAnimesClient();
    }
}
