package book.repository;


import book.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LibroRepository extends JpaRepository <Libro, Long> {
}
