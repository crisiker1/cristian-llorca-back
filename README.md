# Prueba Cristian Llorca
Back de prueba proceso selección. JAVA 11

Hay aspectos que implementaría en un entorno real, y que aquí al ser una prueba, he decidido obviarlos por falta de tiempo.
Estos aspectos son:
	Lombok, para evitar la escritura de código técnico repetitivo, tal como @getters, @setters, @builder...
	Swagger, para documentación, y utilización de los servicios REST, entre otros.
	Programación Orientada a Aspectos, donde normalmente uso para la gestión de los logs, y poder visualizar de una manera mas clara las trazas, por cada método de cada clase.
	Implementación de una clase con Constantes.
	Spring Security con Tokens JWT.
A la hora de hacer la consulta, se ordena de manera descendiente filtrando por el campo prioridad, para garantizar la misma.
En el endpoint principal, he decidido implementar una solución que tolere "fallos humanos" al pasar el body, tolerando "nulos", y obteniendo un resultado basándonos en la fecha actual y no la pasada en el propio body.
He añadido comentarios para la generación de un JavaDoc, y que se puedan entender ciertas acciones y funciones. También hay comentarios y logs que ayudan a mantener el código mas limpio.
Los tests los he implementado usando la clase "Asserts.class", para comprobar que al realizar la llamada al endpoint, no devuelve un "nulo", y además para cada test saber como mínimo cuantos registros se obtienen (he puesto mínimo por si se añaden mas en un futuro, pero no se eliminan).
