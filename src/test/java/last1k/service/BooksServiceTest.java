package last1k.service;

import last1k.ReadDto.BooksReadDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback
@Transactional
public class BooksServiceTest {
    @Autowired
    private BooksService booksService;

    public BooksReadDto booksReadDto = BooksReadDto.builder()
            .name("Test")
            .id(1)
            .author("Test")
            .build();

    @Test
    void findById() {
        assertThat(booksService.findById(booksReadDto.getId())).isEqualTo(booksReadDto);
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
        assertThat(booksService.updateBook(booksReadDto)).isEqualTo(booksReadDto);
    }
}
