package last1k.ReadDto;

import last1k.entity.Books;
import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class PeopleReadDto {
    private Integer id;
    private String fullName;
    private Integer yearOfBirth;
    @Builder.Default
    private List<BooksReadDto> books = new ArrayList<>();
}
