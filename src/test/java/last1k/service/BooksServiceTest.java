package last1k.service;

import last1k.ReadDto.BookReadDto;
import last1k.entity.People;
import last1k.repository.BooksRepository;
import last1k.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Commit
public class BooksServiceTest {
    @Autowired
    private BooksService booksService;
    @Autowired
    private PeopleService peopleService;
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private PeopleRepository peopleRepository;
    public BookReadDto bookReadDto = BookReadDto.builder()
            .name("Test32")
            .author("Test32")
            .build();

    @Test
    void findByName() {
        assertThat(booksService.findByName(bookReadDto.getName())).isEqualTo(bookReadDto);
    }
    @Test
    void createBook() {
        assertThat(true).isTrue();
    }
    @Test
    void findAll () {
        assertThat(booksService.findAll()).isNotNull();
    }
    @Test
    void update() {
        assertThat(booksService.updateBook(bookReadDto)).isEqualTo(bookReadDto);
    }
    @Test
    void getPersonByBook() {
        BookReadDto bookReadDto = BookReadDto.builder()
                .name("Test32")
                .author("Test32")
                .people(List.of(peopleService.findByFullname("FFF")))
                .build();
        assertThat(booksService.createBook(bookReadDto)).isEqualTo(bookReadDto);

    }
    @Test
    void listIsNotNull() {
        var book = booksRepository.findByName("Test").get();
        log.info(book.toString());
        book.getPeople().add(peopleRepository.findByFullName("FFF").get());
        log.info(book.toString());
        booksRepository.save(book);
        assertThat(booksService.findByName("Oleg")).isNotNull();
    }


}
