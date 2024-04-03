package last1k.service;

import last1k.ReadDto.PeopleReadDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Rollback
//@Transactional
public class PeopleServiceTest {
    @Autowired
    private PeopleService peopleService;
    PeopleReadDto personDto = PeopleReadDto.builder()
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
