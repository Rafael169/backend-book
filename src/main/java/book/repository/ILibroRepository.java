package book.repository;



import book.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    // 2°- Implemento los metodos del CRUD con JPA Repository
}
