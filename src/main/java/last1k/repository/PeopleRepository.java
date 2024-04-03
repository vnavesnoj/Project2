package last1k.repository;

import last1k.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
    Optional<People> findByFullName(String fullName);
}
