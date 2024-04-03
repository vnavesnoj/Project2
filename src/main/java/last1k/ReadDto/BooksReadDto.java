package last1k.ReadDto;

import jakarta.persistence.ManyToMany;
import last1k.entity.People;
import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
@Value
@Builder
public class BooksReadDto {
    private Integer id;
    private String author;
    private String name;
    private Integer year;

    @Builder.Default
    private List<PeopleReadDto> people = new ArrayList<>();
}
