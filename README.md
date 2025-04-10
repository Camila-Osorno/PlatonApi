# Platon Api

## Variante Implementada

**Variante: Gestión de Inscripciones**  
Según mi número de documento que termina en un número impar, implementé la variante correspondiente a la **Gestión de Inscripciones**.

---

## Cómo Probar el Servicio

Este proyecto fue desarrollado con:

- Java + Servlets
- Apache Tomcat
- Maven
- Almacenamiento en memoria usando ArrayList
- GSON para manejo de JSON

### URL
http://localhost:8080/PlatonApi_war_exploded/inscripciones



**Ejemplo implementado en Postman (JSON):**
```json
{
  "estudiante": "Camila Osorno",
  "documento": "1011391833",
  "carrera": "Tecnología en Sistematización de Datos",
  "asignatura": "CES 3",
  "semestre": "2025-1",
  "fechaInscripcion": "2025-04-09",
  "estado": "Activa"
}


