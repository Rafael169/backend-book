package books.repository;

import books.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Libro, Long> {

        List<Libro> findByTituloContainingIgnoreCase(String titulo);


}
