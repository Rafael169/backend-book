package books.service;

import books.dto.LibroDTO;
import books.exeption.ResourceNotFoundException;
import books.model.Libro;
import books.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private ILibroRepository lRep;
    @Override
    public List<Libro> buscarLibros() {
        List<Libro> traerLibros = lRep.findAll();
        return traerLibros;
    }

    @Override
    public void guardarUnLibro(Libro libro) {
        lRep.save(libro);
    }

    @Override
    public void eliminarUnLibro(Long id) {
        if (!lRep.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró el libro con ID: " + id);
        }
        lRep.deleteById(id);
    }

    @Override
    public Libro buscarUnLibro(Long id) {
        return lRep.findById(id).orElse(null);
    }

    @Override
    public void editarLibro (Libro libro) {
        // A esta clase la llamo y llamo al metodo de guardar
        this.guardarUnLibro(libro);
    }
    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        return lRep.findByTituloContainingIgnoreCase(titulo);
    }


    public LibroDTO convertirALibroDTO(Libro libro) {
        LibroDTO dto = new LibroDTO();
        dto.setId(libro.getId());
        dto.setTitulo(libro.getTitulo());
        dto.setAutores(libro.getAutores()
                .stream()
                .map(autor -> autor.getNombre())
                .collect(Collectors.toList()));
        return dto;
    }


}
