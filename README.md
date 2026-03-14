Hola, muy buenos días.

Comparto la prueba técnica correspondiente al microservicio **BOM (Bill of Materials)**.

El proyecto utiliza una base de datos en memoria **H2**, por lo que la información se restablece automáticamente cada vez que se detiene o reinicia la aplicación.

Para ejecutar la aplicación es necesario contar con **Java JDK 21** y **Maven 3.9.12**. El proyecto puede iniciarse con el siguiente comando:

mvn spring-boot:run

Adicionalmente, incluyo una colección de **Postman** en formato `.json`, la cual contiene los endpoints implementados:

* Crear producto
* Agregar materiales al producto
* Calcular materiales requeridos para una producción

La colección puede importarse directamente en Postman para probar los servicios.

Quedo atento a cualquier comentario o retroalimentación.

Cordialmente,
**Sergio Urbina**

Muchas gracias.
