package last1k.entity.mapper;

import last1k.ReadDto.PersonReadDto;
import last1k.entity.People;
import org.springframework.stereotype.Component;

@Component
public class CreatePeopleMapper implements Mapper<PersonReadDto, People> {
    @Override
    public People map(PersonReadDto entity) {
        return People.builder()
                .fullName(entity.getFullName())
                .id(entity.getId())
                .yearOfBirth(entity.getYearOfBirth())
                .build();
    }
}
