package Firedev.DesafioKitsu.Domain;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Manga{
    protected String id;
    protected String slug;
    protected String type;
    protected String description;
    private String chapterCount;
    private String volumeCount; // o n° de capitulos e volumes é uma string para não gerar exceçoes com valor null
    protected String poster;

}
