# 📚 API REST de Gestión de Libros

Este proyecto es una API RESTful simple para gestionar libros, desarrollada con **Java + Spring Boot**. Implementa una arquitectura básica de capas: `Model → DTO → Repository → Service → Controller`.

---

## 🧱 Estructura del Proyecto

- **Model**: Clase `Libro` que representa la entidad.
- **DTO**: `LibroDTO` para transferencia de datos.
- **Repository**: Interfaz que extiende `JpaRepository`.
- **Service**: Lógica de negocio en `LibroService` e interfaz `ILibroService`.
- **Controller**: Expone endpoints REST con `@RestController`.

---

## 🔧 Tecnologías Usadas

- Java 17
- Spring Boot 3+
- Spring Data JPA
- MySQL
- Postman (para pruebas de endpoints)
- Maven

---

## 🚀 Endpoints Disponibles

| Método | Endpoint             | Descripción                   |
|--------|----------------------|-------------------------------|
| GET    | `/api/libros/traer`        | Listar todos los libros        |
| POST   | `/api/libros/guardar`      | Crear un nuevo libro           |
| GET    | `/api/libros/buscar/{id}`  | Buscar libro por ID            |
| DELETE | `/api/libros/eliminar/{id}`| Eliminar libro por ID          |
| PUT    | `/api/libros/editar`       | Editar libro existente         |

---

## 📫 Formato JSON de Ejemplo

```json
{
  "id": 1,
  "titulo": "El Principito",
  "autor": "Antoine de Saint-Exupéry",
  "precio": 45.00,
  "stock": 100
}
