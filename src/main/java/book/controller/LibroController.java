package book.controller;

import book.dto.LibroDTO;
import book.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private ILibroService libSer;

    @GetMapping
    public ResponseEntity<List<LibroDTO>> getTodosLosLibros() {
        try {
            List<LibroDTO> libros = libSer.listarLibros();
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarLibro(@RequestBody LibroDTO dto) {
        try {
            libSer.guardarLibro(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Libro guardado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar el libro: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<LibroDTO> obtenerLibro(@PathVariable Long id) {
        try {
            LibroDTO libro = libSer.obtenerLibroPorId(id);
            if (libro != null) {
                return ResponseEntity.ok(libro);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable Long id) {
        try {
            libSer.eliminarLibro(id);
            return ResponseEntity.ok("Libro eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el libro: " + e.getMessage());
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editarLibro(@RequestBody LibroDTO dto) {
        try {
            libSer.actualizarLibro(dto);
            return ResponseEntity.ok("Libro actualizado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el libro: " + e.getMessage());
        }
    }
}
