package last1k.entity.mapper;

import last1k.ReadDto.BookReadDto;
import last1k.entity.Books;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BooksReadDtoMapper implements Mapper<Books, BookReadDto> {
    @Autowired
    private PeopleReadDtoMapper peopleReadDtoMapper;
    @Override
    public BookReadDto map(Books entity) {
        return BookReadDto.builder()
                .author(entity.getAuthor())
                .id(entity.getId())
                .name(entity.getName())
                .year(entity.getYear())
                .people(entity.getPeople().stream().map(peopleReadDtoMapper::map).toList())
                .build();
    }
}
