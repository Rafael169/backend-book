# API de Gestión de Libros

## Descripción General

Esta API REST, desarrollada con Spring Boot, tiene como objetivo gestionar un sistema de libros y sus relaciones con autores, editoriales y categorías. La API implementa relaciones complejas en la base de datos utilizando JPA: ManyToMany, OneToOne y OneToMany. Además, se utiliza un patrón DTO (Data Transfer Object) para desacoplar las entidades del modelo de presentación y controlar qué datos son visibles en cada respuesta.

---

## Entidades y Relaciones

### Libro

- **Relaciones:**
  - Muchos a muchos (ManyToMany) con `Autor` (un libro puede tener varios autores y un autor puede escribir varios libros).
  - Muchos a uno (ManyToOne) con `Editorial` (una editorial puede publicar varios libros, pero un libro tiene una única editorial).
  - Uno a uno (OneToOne) con `DetalleLibro` (para almacenar información adicional detallada).

- **Atributos:**
  - `id` (Long) - Identificador único.
  - `titulo` (String) - Título del libro.
  - `isbn` (String) - Código ISBN.
  - `fechaPublicacion` (Date) - Fecha de publicación.
  - `numeroPaginas` (int) - Número total de páginas.
  - `idioma` (String) - Idioma en que está escrito.
  - `precio` (BigDecimal) - Precio del libro.
  - `activo` (boolean) - Estado del libro (disponible o no).
  
### Autor

- **Relaciones:**
  - Muchos a muchos (ManyToMany) con `Libro`.

- **Atributos:**
  - `id` (Long) - Identificador único.
  - `nombre` (String) - Nombre completo del autor.
  - `nacionalidad` (String) - País de origen.
  - `fechaNacimiento` (Date) - Fecha de nacimiento.
  - `biografia` (String) - Breve biografía.
  - `email` (String) - Contacto del autor.

### Editorial

- **Relaciones:**
  - Uno a muchos (OneToMany) con `Libro`.

- **Atributos:**
  - `id` (Long) - Identificador único.
  - `nombre` (String) - Nombre de la editorial.
  - `direccion` (String) - Dirección física.
  - `telefono` (String) - Teléfono de contacto.
  - `email` (String) - Correo electrónico.
  - `paginaWeb` (String) - URL del sitio web.

### DetalleLibro

- **Relaciones:**
  - Uno a uno (OneToOne) con `Libro`.

- **Atributos:**
  - `id` (Long) - Identificador único.
  - `sinopsis` (String) - Resumen del contenido.
  - `formato` (String) - Formato (digital, papel).
  - `peso` (Double) - Peso en gramos.
  - `dimensiones` (String) - Dimensiones físicas.
  - `fechaCreacion` (Date) - Fecha de creación del detalle.
  - `idiomaOriginal` (String) - Idioma original del libro.

---

## Requerimientos Funcionales

- CRUD completo para `Libro`, `Autor`, `Editorial` y `DetalleLibro`.
- Capacidad para asociar y disociar autores a libros.
- Consultar libros por editorial, autor o idioma.
- Utilizar DTOs para limitar la exposición de atributos sensibles o irrelevantes en la respuesta de la API (por ejemplo, no mostrar email del autor en las respuestas públicas).
- Documentar la API usando Swagger/OpenAPI.

---

## Consideraciones Técnicas

- Utilizar Spring Boot con JPA/Hibernate para la persistencia.
- Configurar relaciones bidireccionales donde sea necesario.
- Implementar DTOs para separar la capa de persistencia de la presentación.
- Manejar excepciones y validar datos de entrada.
- Usar Lombok para reducir código boilerplate (opcional).
- Seguridad no requerida para esta versión inicial, pero dejar la puerta abierta para futuras integraciones.

---

## Endpoints Sugeridos (Ejemplos)

- `GET /api/libros` - Listar todos los libros (DTO limitado).
- `POST /api/libros` - Crear un libro nuevo.
- `PUT /api/libros/{id}` - Actualizar libro.
- `DELETE /api/libros/{id}` - Eliminar libro.
- `GET /api/libros/{id}` - Obtener detalle completo de un libro, incluyendo autores y editorial.
- `GET /api/autores/{id}/libros` - Listar libros de un autor.
- `GET /api/editoriales/{id}/libros` - Listar libros de una editorial.

---

## Ejemplo de DTO

```java
public class LibroDTO {
    private Long id;
    private String titulo;
    private String isbn;
    private Date fechaPublicacion;
    private String idioma;
    private BigDecimal precio;
    private List<String> nombresAutores; // Solo nombres para no exponer datos sensibles
    private String nombreEditorial;
}
