package last1k.ReadDto;

import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class PersonReadDto {
    private Integer id;
    private String fullName;
    private Integer yearOfBirth;
//    @Builder.Default
//    private List<BookReadDto> books = new ArrayList<>();
}
