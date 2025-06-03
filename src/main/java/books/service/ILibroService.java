package books.service;


import books.model.Libro;

import java.util.List;


public interface ILibroService {

    public List<Libro> buscarLibros();

    public void guardarUnLibro (Libro libro);

    public void eliminarUnLibro (Long id);

    public Libro buscarUnLibro (Long id);

    public void editarLibro (Libro libro);
    List<Libro> buscarPorTitulo(String titulo);

}
