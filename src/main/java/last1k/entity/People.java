package last1k.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.experimental.theories.DataPoints;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class People {
    @Id
    private Integer id;
    private String fullName;
    private Integer yearOfBirth;

    @ManyToMany
    @Builder.Default
    @JoinTable(name = "library",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "people_id"))
    private List<Books> books = new ArrayList<>();
}
