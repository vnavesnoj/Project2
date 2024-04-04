package last1k.entity.mapper;

import last1k.ReadDto.BookReadDto;
import last1k.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateBooksMapper implements Mapper<BookReadDto, Books> {
    @Autowired
    private CreatePeopleMapper createPeopleMapper;
    @Override
    public Books map(BookReadDto entity) {
        if (entity.getPeople() != null) {
            return Books.builder()
                    .author(entity.getAuthor())
                    .id(entity.getId())
                    .name(entity.getName())
                    .year(entity.getYear())
                    .people(entity.getPeople().stream().map(createPeopleMapper::map).toList())
                    .build();
        } else {
            return Books.builder()
                    .author(entity.getAuthor())
                    .id(entity.getId())
                    .name(entity.getName())
                    .year(entity.getYear())
                    .build();
        }

    }
}
