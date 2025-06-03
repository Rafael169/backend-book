package books.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_seq")
    @SequenceGenerator(
            name = "autor_seq",               // Nombre lógico del generador
            sequenceName = "autor_sequence", // Nombre de la secuencia en la BD
            allocationSize = 1              // Tamaño de asignación de bloques (1 = secuencial)
    )
    private Long id;
    private String nombre;
    private String nacionalidad;

    @ManyToMany(mappedBy = "autores")
    private Set<Libro> libros = new HashSet<>(); // El uso de set Evita duplicar informacion

    public Autor(){
        // constructor vacio
    }


    public Autor(Long id, String nombre, String nacionalidad, Set<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = libros;
    }
}
