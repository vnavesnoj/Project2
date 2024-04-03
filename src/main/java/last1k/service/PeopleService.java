package last1k.service;

import last1k.ReadDto.PeopleReadDto;
import last1k.entity.mapper.CreatePeopleMapper;
import last1k.entity.mapper.PeopleEditMapper;
import last1k.entity.mapper.PeopleReadDtoMapper;
import last1k.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private PeopleReadDtoMapper peopleReadDtoMapper;
    @Autowired
    private CreatePeopleMapper createPeopleMapper;
    @Autowired
    private PeopleEditMapper peopleEditMapper;
    public PeopleReadDto findByFullname (String fullName) {
        return peopleRepository.findByFullName(fullName)
                .map(peopleReadDtoMapper::map)
                .get();
    }

    public PeopleReadDto createPerson(PeopleReadDto peopleReadDto) {
        return Optional.of(peopleReadDto)
                .map(createPeopleMapper::map)
                .map(peopleRepository::save)
                .map(peopleReadDtoMapper::map)
                .get();
    }

    public List<PeopleReadDto> findAll() {
        return peopleRepository.findAll().stream()
                .map(peopleReadDtoMapper::map)
                .toList();
    }

    public PeopleReadDto updatePerson(PeopleReadDto peopleReadDto) {
        return peopleEditMapper.map(peopleReadDto);
    }
}
