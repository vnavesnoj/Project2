package last1k.entity.mapper;

import last1k.ReadDto.PersonReadDto;
import last1k.entity.People;
import org.springframework.stereotype.Component;

@Component
public class PeopleReadDtoMapper implements Mapper<People, PersonReadDto> {
    @Override
    public PersonReadDto map(People entity) {
        return PersonReadDto.builder()
                .fullName(entity.getFullName())
                .yearOfBirth(entity.getYearOfBirth())
                .id(entity.getId())
                .build();
    }
}
