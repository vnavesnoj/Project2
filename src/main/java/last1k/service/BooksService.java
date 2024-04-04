package last1k.service;


import last1k.ReadDto.BookReadDto;
import last1k.ReadDto.PersonReadDto;
import last1k.entity.People;
import last1k.entity.mapper.*;
import last1k.repository.BooksRepository;
import last1k.repository.PeopleRepository;
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
    @Autowired
    private CreatePeopleMapper createPeopleMapper;
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private PeopleReadDtoMapper peopleReadDtoMapper;
    public BookReadDto findByName(String name) {
        return booksRepository.findByName(name)
                .map(booksReadDtoMapper::map)
                .get();
    }

    public List<BookReadDto> findAll() {
        return booksRepository.findAll().stream()
                .map(booksReadDtoMapper::map)
                .toList();
    }

    public BookReadDto createBook(BookReadDto bookReadDto) {
        return Optional.of(bookReadDto)
                .map(createBooksMapper::map)
                .map(booksRepository::save)
                .map(booksReadDtoMapper::map)
                .get();
    }

    public BookReadDto updateBook(BookReadDto bookReadDto) {
        return booksEditMapper.map(bookReadDto);
    }


    public BookReadDto findByPerson(PersonReadDto personReadDto) {
         return Optional.ofNullable(personReadDto)
                .map(createPeopleMapper::map)
                .map(booksRepository::findByPeople)
                .get()
                 .map(booksReadDtoMapper::map)
                .get();

    }

    public PersonReadDto takeBook(String fullName, BookReadDto bookReadDto) {
        People person =  Optional.of(fullName).map(peopleRepository::findByFullName).get().get();
        Optional.of(bookReadDto).map(createBooksMapper::map).map(book -> {
            book.getPeople().add(person);
            return booksRepository.save(book);
        });
        return Optional.of(person).map(peopleReadDtoMapper::map).get();
    }
}
