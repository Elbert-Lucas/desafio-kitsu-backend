package Firedev.DesafioKitsu.Service;

import Firedev.DesafioKitsu.Client.AnimeClient;
import Firedev.DesafioKitsu.Client.EpisodeClient;
import Firedev.DesafioKitsu.Domain.Anime;
import Firedev.DesafioKitsu.Domain.Episode;
import Firedev.DesafioKitsu.Util.Exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EpisodeService {

    private final EpisodeClient episodeClient;

    public Episode getEpisodeByIdService(Long id){
        return episodeClient.getEpisodeByIdClient(id);
    }

    public Episode getEpisodeOfAnimeService(String animeID, String episode){
        if (animeID.isEmpty() || episode.isEmpty()){
            throw new BadRequestException("Alguns dos valores passados são invalidos");
        }
        return episodeClient.getEpisodeOfAnimeClient(animeID, episode);
    }
}
