# Mini Quiz Sobre Java

Esto es un mini proyecto para la practica de programacion orientada a objetos
usando [Java](https://dev.java/) que es lo que estoy aprendiendo

> [!IMPORTANT]
> Me he introducido a la programacion orientada a objetos un poco por mi cuenta todavia no tengo idea de bastantes cosas

Se compone de dos clases una principal que gestiona todo y otra la clase `Pregunta` que sera definida a continuacion
## Clase `Pregunta`

La clase `Pregunta` permite modelar una pregunta de opción múltiple en un cuestionario. Contiene el enunciado de la pregunta, las respuestas posibles, la respuesta correcta y el valor en puntos de la pregunta.

## Definición de la Clase

```java
class Pregunta {
    String pregunta;
    int respuestaCorrecta;
    int puntosPregunta;
    String respuestasPosibles;

    Pregunta(String pregunta, int respuestaCorrecta, int puntosPregunta, String respuestasPosibles) {
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.puntosPregunta = puntosPregunta;
        this.respuestasPosibles = " " + respuestasPosibles;
    }
}
```

Aqui os dejo un ejemplo de uso de la clase Pregunta para definir una pregunta

```java
Pregunta pregunta = new Pregunta("¿Como se declara una clase en Java?", 1, 2, "1, Usando class NombreClase\n 2. Usando clas NombreClase\n 3. Usando NombreClase");
```
Aunque aqui no se vea primero lo que hacemos es declarar en una instancia del objeto pregunta el contenido de la misma, despues declaramos cual es la respuesta correcta a la pregunta
despues de eso declaramos cuantos puntos son cada pregunta y por ultimo declaramos las posibles respuestas que esta pueda tener
## Clase `MiniQuizJava`

La clase `MiniQuizJava` implementa un mini cuestionario en Java que evalúa los conocimientos del usuario a través de preguntas de opción múltiple. Utiliza la clase `Pregunta` para definir cada pregunta, permitiendo al usuario responder y acumular puntos en función de sus respuestas correctas.
