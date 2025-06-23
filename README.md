# 📚 API REST - Tienda de Libros

Este proyecto es una API REST básica construida con **Java 17**, **Spring Boot** y arquitectura en capas. Permite gestionar libros con operaciones CRUD, utilizando buenas prácticas como DTOs, `ResponseEntity` y separación de responsabilidades.

---

## 🧱 Estructura del Proyecto

- **Model**: Clase `Libro` que representa la entidad.
- **DTO**: `LibroDTO` para la transferencia de datos.
- **Repository**: Interfaz que extiende `JpaRepository`.
- **Service**: Lógica de negocio en `LibroService` e interfaz `ILibroService`.
- **Controller**: Expone los endpoints REST con `@RestController`.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## 🎯 Funcionalidades

- 📖 Obtener todos los libros
- ➕ Agregar un nuevo libro
- 🔍 Buscar un libro por ID
- ✏️ Editar un libro existente
- ❌ Eliminar un libro

---

## 🧾 Endpoints disponibles

| Método | Endpoint                    | Descripción                  |
|--------|-----------------------------|------------------------------|
| GET    | `/api/libros/traer`         | Obtener todos los libros     |
| POST   | `/api/libros/guardar`       | Guardar nuevo libro          |
| GET    | `/api/libros/buscar/{id}`   | Obtener libro por ID         |
| DELETE | `/api/libros/eliminar/{id}` | Eliminar libro por ID        |
| PUT    | `/api/libros/editar`        | Actualizar libro existente   |

---

## ✅ Buenas prácticas implementadas

- ✔️ Uso de **DTOs** para desacoplar la capa de presentación de la de persistencia.
- ✔️ Arquitectura en capas: Controller → Service → Repository → Model.
- ✔️ Control de errores mediante **bloques `try-catch`**.
- ✔️ Uso de **`ResponseEntity`** para respuestas HTTP más controladas.
- ✔️ Separación clara de responsabilidades.
- ✔️ Anotaciones de Spring como `@RestController`, `@Service`, `@Repository`, `@Autowired`.

---

## 🔁 Ejemplos de Peticiones JSON

### Crear libro (`POST /api/libros/guardar`)
```json
{
  "id": 1,
  "titulo": "El Principito",
  "autor": "Antoine de Saint-Exupéry",
  "precio": 30.00,
  "stock": 45
}
