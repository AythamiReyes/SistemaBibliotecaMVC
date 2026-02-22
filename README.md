# SistemaBibliotecaMVC
En este proyecto creamos un sistema de biblioteca con MVC, utilizando clases bajo el patrón MVC, el sistema controla y permite gestionar libros y usuarios, prestamos y devoluciones, implementa metodos para manipular los datos y mostrarlos de manera estructurada aplicando como en el proyecto anterior, clases, objetos, enum, atributos y validaciones. Clases como libro, usuario, prestamoLibro y controladores como GestorBiblioteca.

¿Cómo ejecutamos el programa?.

mkdir proyecto

Compilamos.

javac -d proyecto src/com/daw/app/main.java src/com/daw/controller/*.java src/com/daw/model/*.java src/com/daw/view/*.java

Ejecutamos. 

java -cp proyecto com.daw.app.main

Reparto de tareas.
Aythami Reyes: Creacion del patron MVC, su jerarquía, el main, GestorLibro, GestorPedidos, EstadoLibro y el README.
Alejandro Acosta: Creacion de la clases Consola, Pedido, Genero, Producto, Usuario.