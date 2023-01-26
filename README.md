# Tickets Spring Boot Base1

Aplicación web para venta de boletos de autobús usando el IDE IntelliJ, con las dependencias Spring web, Spring Data JPA, MySQL Driver, Lombok y Mapstruct.

En esta versión se hicieron las operaciones básicas CRUD para las tablas de "Drivers" y "Stations" que tienen una relación muchos a uno (Muchos drivers asignados a una station).

1. Clonar el repositorio
2. Configurar el acceso a la base de datos MySQL en ./src/main/resources/application.properties (base de datos, usuario y contraseña).
3. Crear la base de datos.
4. Ejecutar
~~~
mvn clean
mvn spring-boot:run
~~~


