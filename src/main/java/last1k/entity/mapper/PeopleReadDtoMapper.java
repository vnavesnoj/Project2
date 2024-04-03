package last1k.entity.mapper;

import last1k.ReadDto.PeopleReadDto;
import last1k.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeopleReadDtoMapper implements Mapper<People, PeopleReadDto> {
    @Override
    public PeopleReadDto map(People entity) {
        return PeopleReadDto.builder()
                .fullName(entity.getFullName())
                .yearOfBirth(entity.getYearOfBirth())
                .id(entity.getId())
                .build();
    }
}
