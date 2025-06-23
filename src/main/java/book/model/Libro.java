package book.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
@Entity
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_seq")
    @SequenceGenerator(name = "libro_seq", sequenceName = "libro_sequence", allocationSize = 1)
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private Date anioPublicacion;
    private String isbn;
}
