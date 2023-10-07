## CODIGO
 - [x] Hacer dto para mostrar los datos
 - [x] Falta EstudianteCarreraImpl
 - [x] Probar las consultas de estudianteCarrera 
 - [x] Agregar factory
      - Falta probar si funciona
 - [x] Ver que agregar carreras permite agregar repetidas. Decidimos darlo como posible que se puedana agregar repetidas
 - [x] Revisar los toString
    - dejar mas lindos bnjitos preociosos los toString de las entidades
 - [x] **Pensar si usamos un DTO para SELECTS Customs o usamos la data sin castear**
     - Falta modificar en todos los Select de las Queries
 - [x] Revisar que los nombres sean descriptivos y que usen plural o singular segun corresponda

 - [x] Revisar que los nombres de las entidades (clases y tablas) respeten estilos de escritura: elegir camelCase o snake_case y respetarlo
 - [x] For de reporte carreras se acomodo por error de CASTEO verificar si esta bien  
 ### DTO
- En el dto Estudiante ver si va la lista de carreras que tiene estudiante.java
- En el dto de EstudianteCarrera ver si va el estudiante y la carrera que tiene la entidad


## CONSIGNAS
#### Inciso 2 
- [x] a) dar de alta un estudiante
- [x] b) matricular un estudiante en una carrera
- [X] c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
- [X] d) recuperar un estudiante, en base a su número de libreta universitaria.
- [x] e) recuperar todos los estudiantes, en base a su género.
- [x] f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
- [x] g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.


## PROYECTO
 - hacer los diagramas
   - Hacer dere
   - hacer diagrama de clases
   
## Errores/inconsistencias encontrados en los datasets
- En la tabla EstudianteCarrera la fila con id 78 tiene un año de graduación menor que el de inscripción
- En la tabla EstudianteCarrera la fila con id 91 el año es 202
- En la tabla EstudianteCarrera las filas con id 103 y 104 tienen un dni que no corresponde a ningún estudiante si no se les agrega un cero al final.
