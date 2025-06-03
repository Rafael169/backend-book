package books.service;

import books.model.Autor;


import java.util.List;

public interface IAutorService {


    public List<Autor> buscarAutor();

    public void guardarUnAutor (Autor aut);

    public void elimiarUnAutor (Long id);

    public Autor buscarUnAutor (Long id);

    public void editarAutor (Autor aut);
}
