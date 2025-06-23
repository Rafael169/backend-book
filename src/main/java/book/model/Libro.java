package book.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.Date;
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_seq")
    @SequenceGenerator(name = "libro_seq", sequenceName = "libro_sequence", allocationSize = 1)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacío")
    private String autor;

    @NotNull(message = "El precio es obligatorio")
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    private Integer stock;

    public Libro() {
    }

    public Libro(Long id, String titulo, String autor, Double precio, Integer stock) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
