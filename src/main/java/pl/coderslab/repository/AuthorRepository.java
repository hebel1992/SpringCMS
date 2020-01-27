package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
