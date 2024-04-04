package last1k.entity.mapper;

import last1k.ReadDto.PersonReadDto;
import last1k.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class PeopleEditMapper implements Mapper<PersonReadDto, PersonReadDto> {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private PeopleReadDtoMapper peopleReadDtoMapper;
    @Override
    public PersonReadDto map(PersonReadDto personReadDto) {
        return Optional.of(personReadDto)
                .map(updatedEntity -> peopleRepository.findById(personReadDto.getId()).get())
                .map(updatedEntity -> {
                    updatedEntity.setId(personReadDto.getId());
                    updatedEntity.setFullName(personReadDto.getFullName());
                    updatedEntity.setYearOfBirth(personReadDto.getYearOfBirth());
                    return peopleRepository.save(updatedEntity);
                }).map(peopleReadDtoMapper::map).get();
    }
}
