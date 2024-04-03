package last1k.entity.mapper;

import last1k.ReadDto.BooksReadDto;
import last1k.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class BooksEditMapper implements Mapper<BooksReadDto, BooksReadDto> {
    @Autowired
    private BooksReadDtoMapper booksReadDtoMapper;
    @Autowired
    private BooksRepository booksRepository;
    @Override
    public BooksReadDto map(BooksReadDto entity) {
        return Optional.of(entity)
                .map(updatedEntity -> booksRepository.findById(entity.getId()).get())
                .map(updatedEntity -> {
            updatedEntity.setName(entity.getName());
            updatedEntity.setYear(entity.getYear());
            updatedEntity.setAuthor(entity.getAuthor());
            return booksRepository.save(updatedEntity);
        }).map(booksReadDtoMapper::map).get();
    }
}
