package Firedev.DesafioKitsu.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Episode{
    private String animeName;
    private String id;
    private String title;
    private String synopsis;
    private String number;
    private String airdate;
    private String seasonNumber;
    private String durationInMinutes;
}
