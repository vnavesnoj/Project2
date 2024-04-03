package last1k.entity.mapper;

import last1k.ReadDto.PeopleReadDto;
import last1k.entity.People;
import last1k.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class PeopleEditMapper implements Mapper<PeopleReadDto, PeopleReadDto> {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private PeopleReadDtoMapper peopleReadDtoMapper;
    @Override
    public PeopleReadDto map(PeopleReadDto peopleReadDto) {
        return Optional.of(peopleReadDto)
                .map(updatedEntity -> peopleRepository.findById(peopleReadDto.getId()).get())
                .map(updatedEntity -> {
                    updatedEntity.setId(peopleReadDto.getId());
                    updatedEntity.setFullName(peopleReadDto.getFullName());
                    updatedEntity.setYearOfBirth(peopleReadDto.getYearOfBirth());
                    return peopleRepository.save(updatedEntity);
                }).map(peopleReadDtoMapper::map).get();
    }
}
