package Firedev.DesafioKitsu.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chapter{
    private String mangaName;
    private String id;
    private String title;
    private String synopsis;
    private String number;
    private String publised;
    private String volumeNumber;
    private String pages;

}
