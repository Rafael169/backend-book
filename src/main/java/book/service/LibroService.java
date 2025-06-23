package book.service;

import book.dto.LibroDTO;
import book.model.Libro;
import book.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private ILibroRepository libRep;

    @Override
    public List<LibroDTO> listarLibros() {
        List<Libro> libros = libRep.findAll();
        List<LibroDTO> librosDTO = new ArrayList<>();

        for (Libro libro : libros) {
            LibroDTO dto = new LibroDTO();
            dto.setId(libro.getId());
            dto.setTitulo(libro.getTitulo());
            dto.setAutor(libro.getAutor());
            dto.setPrecio(libro.getPrecio());
            dto.setStock(libro.getStock());
            librosDTO.add(dto);
        }
        return librosDTO;
    }


    @Override
    public void guardarLibro(LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setPrecio(libroDTO.getPrecio());
        libro.setStock(libroDTO.getStock());

        libRep.save(libro);
    }

    @Override
    public void eliminarLibro(Long id) {
        libRep.deleteById(id);
    }

    @Override
    public void actualizarLibro(LibroDTO libroDTO) {
        // 1. Verificar que el DTO tiene un ID válido
        if (libroDTO.getId() == null) {
            throw new IllegalArgumentException("El ID del libro no puede ser nulo");
        }

        // 2. Buscar el libro por ID
        Optional<Libro> libroExistenteOpt = libRep.findById(libroDTO.getId());

        if (libroExistenteOpt.isPresent()) {
            // 3. Obtener el libro existente
            Libro libroExistente = libroExistenteOpt.get();

            // 4. Actualizar sus campos con los valores del DTO
            libroExistente.setTitulo(libroDTO.getTitulo());
            libroExistente.setAutor(libroDTO.getAutor());
            libroExistente.setPrecio(libroDTO.getPrecio());
            libroExistente.setStock(libroDTO.getStock());

            // 5. Guardar los cambios
            libRep.save(libroExistente);

        } else {
            // 6. Si no existe, lanzar una excepción o manejarlo según tu caso
            throw new NoSuchElementException("No se encontró el libro con ID: " + libroDTO.getId());
        }
    }

    @Override
    public LibroDTO obtenerLibroPorId(Long id) {
        Optional<Libro> libroOpt = libRep.findById(id);

        if (libroOpt.isPresent()) {
            Libro libro = libroOpt.get();

            LibroDTO dto = new LibroDTO();
            dto.setId(libro.getId());
            dto.setTitulo(libro.getTitulo());
            dto.setAutor(libro.getAutor());
            dto.setPrecio(libro.getPrecio());
            dto.setStock(libro.getStock());

            return dto;
        } else {
            // Puedes retornar null o lanzar una excepción si prefieres
            return null;
        }
    }

}
