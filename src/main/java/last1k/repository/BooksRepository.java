package last1k.repository;

import last1k.entity.Books;
import last1k.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Integer> {
    Optional<Books> findByName(String name);


    Optional<Books> findByPeople(People people);
}
