# Gestor de Préstamos - Biblioteca

Este proyecto implementa un sistema de gestión de préstamos de libros para una biblioteca, con funcionalidades de filtrado, listado y visualización de detalles. Además, proporciona un API REST para el consumo de datos.

---

## Rutas Disponibles

### **Vistas (HTML)**

- **`GET /prestamos`**: Carga la página principal con el listado de todos los préstamos.
- **`GET /prestamos/filtrar`**: Muestra los resultados filtrados según los parámetros proporcionados.

### **API REST (JSON)**

- **`GET /prestamos/api`**: Retorna todos los préstamos en formato JSON.
- **`GET /prestamos/api/filtrar`**: Retorna los préstamos filtrados en formato JSON.

  **Parámetros opcionales:**
  - `fechaInicio`: Fecha inicial en formato `YYYY-MM-DD`.
  - `fechaFin`: Fecha final en formato `YYYY-MM-DD`.
  - `estado`: `d` para Devuelto o `p` para Pendiente.

---

## Base de Datos

Usa el siguiente script para configurar la base de datos en MySQL:

```sql
DROP DATABASE IF EXISTS m7_final_drilling;
CREATE DATABASE m7_final_drilling;
USE m7_final_drilling;

CREATE TABLE prestamos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_prestamo DATE NOT NULL,
    libro VARCHAR(200) NOT NULL,
    fecha_devolucion DATE,
    usuario VARCHAR(200) NOT NULL,
    estado CHAR NOT NULL
);

INSERT INTO prestamos (fecha_prestamo, libro, fecha_devolucion, usuario, estado)
VALUES
('2024-12-20', 'El Quijote', '2024-12-25', 'Juan Pérez', 'd'),
('2024-12-18', 'Cien Años de Soledad', '2024-12-22', 'María López', 'd'),
('2024-12-15', 'Sapiens', '2024-12-20', 'Carlos García', 'd'),
('2024-12-22', 'Breve Historia del Tiempo', '2024-12-28', 'Ana Fernández', 'd'),
('2024-12-10', 'Historia de la Humanidad', NULL, 'Juan Pérez', 'p');
```

---

## Créditos

Desarrollado por Cristopher Diaz.

