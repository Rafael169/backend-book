# API de Gestión Editorial y Biblioteca Digital

## Contexto

Una editorial digital requiere una API para administrar su catálogo de libros, autores y colecciones especiales. El objetivo es facilitar la gestión de información de libros y sus autores, controlar las colecciones temáticas y mantener datos específicos que permitan realizar análisis y reportes internos.

---

## Entidades y Relaciones

### Libro

- **Relaciones:**
  - **ManyToMany** con `Autor`: Un libro puede tener múltiples autores y un autor puede estar vinculado a varios libros.
  - **OneToOne** con `Portada`: Cada libro tiene una portada con información específica (imagen, formato, tamaño).
  - **ManyToOne** con `Coleccion`: Cada libro pertenece a una colección temática (una colección puede tener muchos libros).

- **Atributos:**
  - `id` (Long)
  - `titulo` (String)
  - `sinopsis` (String)
  - `isbn` (String)
  - `fechaPublicacion` (Date)
  - `precio` (BigDecimal)
  - `idioma` (String)
  - `disponible` (boolean)

### Autor

- **Relaciones:**
  - **ManyToMany** con `Libro`

- **Atributos:**
  - `id` (Long)
  - `nombreCompleto` (String)
  - `fechaNacimiento` (Date)
  - `nacionalidad` (String)
  - `email` (String)
  - `biografia` (String)

### Coleccion

- **Relaciones:**
  - **OneToMany** con `Libro`

- **Atributos:**
  - `id` (Long)
  - `nombre` (String)
  - `descripcion` (String)
  - `fechaCreacion` (Date)
  - `activo` (boolean)

### Portada

- **Relaciones:**
  - **OneToOne** con `Libro`

- **Atributos:**
  - `id` (Long)
  - `urlImagen` (String)
  - `formato` (String)
  - `pesoKb` (Integer)
  - `descripcion` (String)

---

## Requerimientos

- CRUD para todas las entidades.
- Control estricto sobre qué atributos exponer en la API pública mediante DTOs (por ejemplo, ocultar el email del autor o el peso de la portada en respuestas públicas).
- Posibilidad de asignar y remover autores a libros.
- Consulta de libros filtrados por colección, idioma o disponibilidad.
- Soporte para agregar o modificar la portada de un libro.
- Mantener registros históricos de colecciones activas e inactivas.

---

## Objetivos

- Practicar el modelado de relaciones complejas JPA.
- Implementar DTOs para gestionar la visibilidad de datos en la API.
- Garantizar un diseño claro y modular que facilite futuras ampliaciones y mantenibilidad.

