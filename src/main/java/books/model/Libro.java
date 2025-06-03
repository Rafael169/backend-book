package books.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_seq")
    @SequenceGenerator(name = "libro_seq",    // Nombre lógico del generador
            sequenceName = "libro_sequence", // Nombre de la secuencia en la BD
            allocationSize = 1              // Tamaño de asignación de bloques (1 = secuencial)
    )
    private Long id;
    private String titulo;
    private String isbn;

    @ManyToMany
    @JoinTable(
            name = "libro_autor", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "libro_id"),// FK hacia Libro
            inverseJoinColumns = @JoinColumn(name = "autor_id") // FK hacia Autor
    )
    private Set<Autor> autores = new HashSet<>();

    public Libro() {
    }

    public Libro(Long id, String titulo, String isbn, Set<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autores = autores;
    }
}
