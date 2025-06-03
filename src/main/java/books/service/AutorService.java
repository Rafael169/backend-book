package books.service;

import books.model.Autor;
import books.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IAutorService {


    @Autowired
    private IAutorRepository autRepo;
    @Override
    public List<Autor> buscarAutor() {
        List<Autor> listAutor = autRepo.findAll(); // Creo una lista y le inyecto con los metodos de jpa
        return listAutor; // luego la retorno
    }

    @Override
    public void guardarUnAutor(Autor aut) {
        autRepo.save(aut);
    }

    @Override
    public void elimiarUnAutor(Long id) {
        autRepo.deleteById(id);
    }

    @Override
    public Autor buscarUnAutor(Long id) {
        return this.autRepo.findById(id).orElse(null);
    }

    @Override
    public void editarAutor(Autor aut) {
        // A esta clase la llamo y llamo al metodo de guardar
        this.guardarUnAutor(aut);
    }
}