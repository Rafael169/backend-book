package books.dto;

import lombok.Data;

import java.util.List;

@Data
public class LibroDTO {
    private Long id;
    private String titulo;
    private List<String> autores; // o List<AutorDTO> si quieres más detalle
}
