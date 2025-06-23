package book.controller;

import book.dto.LibroDTO;
import book.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros") // Ruta base para todos los endpoints de este controlador
public class LibroController {

        @Autowired
        private ILibroService libSer;

        @GetMapping("/traer")
        public List<LibroDTO> getTodosLosLibros() {
            return libSer.listarLibros();
        }

        @PostMapping("/guardar")
        public void guardarLibro(@RequestBody LibroDTO dto) {
            libSer.guardarLibro(dto);
        }

        @GetMapping("/buscar/{id}")
        public LibroDTO obtenerLibro(@PathVariable Long id) {
            return libSer.obtenerLibroPorId(id);
        }

        @DeleteMapping("/eliminar/{id}")
        public void eliminarLibro(@PathVariable Long id) {
            libSer.eliminarLibro(id);
        }
}
