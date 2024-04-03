package last1k.entity.mapper;

import last1k.ReadDto.PeopleReadDto;
import last1k.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePeopleMapper implements Mapper<PeopleReadDto, People> {
    @Override
    public People map(PeopleReadDto entity) {
        return People.builder()
                .fullName(entity.getFullName())
                .id(entity.getId())
                .yearOfBirth(entity.getYearOfBirth())
                .build();
    }
}
