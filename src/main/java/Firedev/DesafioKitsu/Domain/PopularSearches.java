package Firedev.DesafioKitsu.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PopularSearches {
    @Id
    private Long id;

    @Column (nullable = false)
    private String type;

    @Column (nullable = false)
    private String name;

    @Column(nullable = false)
    private long searchCount;

    @Column(nullable = false)
    private String parent;
}
