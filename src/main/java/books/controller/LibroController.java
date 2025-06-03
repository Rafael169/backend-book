package books.controller;

import books.model.Libro;
import books.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibroController {

    @Autowired
    private ILibroService  lServ;


    @GetMapping("/libro/traer")
    public List<Libro> traerListaLibros() {

        return lServ.buscarLibros();
    }

    @PostMapping("/libro/guardar")
    public ResponseEntity<String> guardarLibro(@RequestBody Libro lib) {
        lServ.guardarUnLibro(lib);
        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha guardado el libro correctamente");
    }
    /* basico para prueba local

    @DeleteMapping("/libro/borrar/{id}")
    public String eliminarUnLibro(@PathVariable Long id){
        lServ.eliminarUnLibro(id);
        return "El libro se elimino correctamente";
    }*/

    @GetMapping("/libro/buscar")
    public ResponseEntity<List<Libro>> buscarPorTitulo(@RequestParam String titulo) {
        List<Libro> resultados = lServ.buscarPorTitulo(titulo);

        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(resultados);
    }

    @DeleteMapping("/libro/borrar/{id}")
    public ResponseEntity<String> eliminarUnLibro(@PathVariable Long id) {
        lServ.eliminarUnLibro(id); // puede lanzar ResourceNotFoundException
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT) // o HttpStatus.OK si quieres respuesta visible
                .body("El libro se eliminó correctamente");
    }
    @PutMapping("/libro/editar")
    public Libro editarLibro(@RequestBody Libro lib){
        lServ.editarLibro(lib);
        return lServ.buscarUnLibro(lib.getId());
    }

}
