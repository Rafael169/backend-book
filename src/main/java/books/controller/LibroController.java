package books.controller;


import books.repository.IAutorRepository;
import books.service.ILibroService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @Autowired
    private IAutorRepository autorRepository;


}
