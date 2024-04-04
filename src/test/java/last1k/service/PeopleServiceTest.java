package last1k.service;

import last1k.ReadDto.PersonReadDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Rollback
//@Transactional
public class PeopleServiceTest {
    @Autowired
    private PeopleService peopleService;
    PersonReadDto personDto = PersonReadDto.builder()
            .fullName("Test2")
            .id(1)
            .yearOfBirth(210)
            .build();

    @Test
    void createAccount() {
        assertThat(peopleService.createPerson(personDto)).isEqualTo(personDto);
    }
    @Test
    void findByFullName() {
        assertThat(peopleService.findByFullname("Test")).isEqualTo(personDto);
    }
    @Test
    void findAll() {
        assertThat(peopleService.findAll()).isNotNull();
    }
    @Test
    void update() {
        assertThat(peopleService.updatePerson(personDto)).isEqualTo(personDto);
    }

}
