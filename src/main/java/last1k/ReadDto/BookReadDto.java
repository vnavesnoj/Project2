package last1k.ReadDto;

import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
@Value
@Builder
public class BookReadDto {
    private Integer id;
    private String author;
    private String name;
    private Integer year;
    @Builder.Default
    private List<PersonReadDto> people = new ArrayList<>();
//
}
