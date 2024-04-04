package last1k.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@NamedEntityGraph(
        name = "entityGraph",
        attributeNodes = @NamedAttributeNode("people")
)
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String name;
    private Integer year;

    @ManyToMany(mappedBy = "books")
    @Builder.Default
    private List<People> people = new ArrayList<>();
}
