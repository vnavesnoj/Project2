package last1k.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Books {
    @Id
    private Integer id;
    private String author;
    private String name;
    private Integer year;

    @ManyToMany
    @Builder.Default
    private List<People> people = new ArrayList<>();
}
