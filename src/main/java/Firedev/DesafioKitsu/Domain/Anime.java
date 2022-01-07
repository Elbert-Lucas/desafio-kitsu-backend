package Firedev.DesafioKitsu.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Anime{

    private String id;
    private String slug;
    private String type;
    private String description;
    private String poster;
    private String episodeCount; // o n° de episodios é uma string para não gerar exceçoes com valor null
}
