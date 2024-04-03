package last1k.service;


import last1k.ReadDto.BooksReadDto;
import last1k.entity.mapper.BooksEditMapper;
import last1k.entity.mapper.BooksReadDtoMapper;
import last1k.entity.mapper.CreateBooksMapper;
import last1k.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    private BooksReadDtoMapper booksReadDtoMapper;
    @Autowired
    private CreateBooksMapper createBooksMapper;
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private BooksEditMapper booksEditMapper;
    public BooksReadDto findById(Integer id) {
        return booksRepository.findById(id)
                .map(booksReadDtoMapper::map)
                .get();
    }

    public List<BooksReadDto> findAll() {
        return booksRepository.findAll().stream()
                .map(booksReadDtoMapper::map)
                .toList();
    }

    public BooksReadDto createBook(BooksReadDto booksReadDto) {
        return Optional.of(booksReadDto)
                .map(createBooksMapper::map)
                .map(booksRepository::save)
                .map(booksReadDtoMapper::map)
                .get();
    }

    public BooksReadDto updateBook(BooksReadDto booksReadDto) {
        return booksEditMapper.map(booksReadDto);
    }
}
