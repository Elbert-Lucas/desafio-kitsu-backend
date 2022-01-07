package Firedev.DesafioKitsu.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Manga{
    private String id;
    private String slug;
    private String type;
    private String description;
    private String poster;
    private String chapterCount;
    private String volumeCount; // o n° de capitulos e volumes é uma string para não gerar exceçoes com valor null
}
