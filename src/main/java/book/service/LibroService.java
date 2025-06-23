package book.service;

import book.dto.LibroDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService{
    @Override
    public List<LibroDTO> listarLibros() {
        return List.of();
    }

    @Override
    public void guardarLibro(LibroDTO libro) {

    }

    @Override
    public void eliminarLibro(Long id) {

    }

    @Override
    public void actualizarLibro(LibroDTO libro) {

    }

    @Override
    public LibroDTO obtenerLibroPorId(Long id) {
        return null;
    }
}
