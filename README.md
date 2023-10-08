
# TPE Integrador 2 - Anotaciones JPA & Hibernate - Arquitecturas WEB - TUDAI

## Descripción del proyecto

El objetivo de este proyecto fue modelar un servicio de matriculación de estudiantes a carreras utilizando la API de Persistencia de Java (*Java Persistence API - JPA*) y Hibernate como proveedor de implementación.

Con este fin utilizamos los patrones de diseño **Repository**, **Abstract Factory**, **DTO** e implementamos consultas a base de datos utilizando el lenguaje de consultas **JPQL**.

## Diagramas
### Diagrama de clases
![Diagrama de clases](/diagramas/svg/diagrama-clases.svg)

### Diagrama de Entidad-Relación
![Diagrama de entidad relación](/diagramas/svg/dere.svg)



## Errores/inconsistencias encontrados en los datasets
- En la tabla EstudianteCarrera la fila con id 78 tiene un año de graduación menor que el de inscripción
- En la tabla EstudianteCarrera la fila con id 91 el año es 202
- En la tabla EstudianteCarrera las filas con id 103 y 104 tienen un dni que no corresponde a ningún estudiante si no se les agrega un cero al final.
