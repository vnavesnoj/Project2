package last1k.entity.mapper;

import last1k.ReadDto.BooksReadDto;
import last1k.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateBooksMapper implements Mapper<BooksReadDto, Books> {
    @Override
    public Books map(BooksReadDto entity) {
        return Books.builder()
                .author(entity.getAuthor())
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
