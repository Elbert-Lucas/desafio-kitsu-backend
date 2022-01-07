package Firedev.DesafioKitsu.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@JsonAutoDetect
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
