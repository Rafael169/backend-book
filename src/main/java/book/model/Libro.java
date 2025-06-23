package book.model;

import jakarta.persistence.Entity;
import lombok.Data;


import java.util.Date;
@Entity
@Data
public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private Date anioPublicacion;
    private String isbn;
}
