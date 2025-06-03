package books.repository;

import books.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    // Implemento los metodos del repository


    List<Libro> findByTituloContainingIgnoreCase(String titulo);

}
