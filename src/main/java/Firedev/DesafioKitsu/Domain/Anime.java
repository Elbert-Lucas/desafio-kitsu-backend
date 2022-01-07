package Firedev.DesafioKitsu.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Data
@Builder
public class Anime {

    /*
        A API fornece milhares de informaçoes, acho que é um despedicio nao incluir todas,
        porem criar milhares de variaveis no objeto é idiota.

        NOTA: como utilizar todas informaçoes que a API fornece sem precisar criar um objeto com milhares de atributos
        IDEIA: quando o usuario escolhe um anime, o codigo envia a string JSon para o front-end para ser tratada e visualizada,
        porém as informaçoes ali nao estarão guardadas no objeto ou no banco de dados
     */
    private String id;
    private String slug;
    private String type;
    private String description;
    private String poster;
    private String episodeCount; // o n° de episodios é uma string para não gerar exceçoes com valor null
}
