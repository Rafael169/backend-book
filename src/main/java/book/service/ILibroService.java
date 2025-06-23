package book.service;


import book.dto.LibroDTO;

import java.util.List;

public interface ILibroService {
    public List<LibroDTO> listarLibros();
    public void guardarLibro(LibroDTO libro);
    public void eliminarLibro(Long id);
    public void actualizarLibro(LibroDTO libro);
    public LibroDTO obtenerLibroPorId(Long id);

}
