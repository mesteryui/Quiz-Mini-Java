import java.util.Scanner; // Importamos clase Scanner para solicitar entrada al usuario
/**
 * Declaramos la pregunta que tiene las caracteristicas de tener una respuesta correcta un contenido y una serie de puntos
 * si esta es correcta
 * @author Oscar Rodriguez
 * @version 1.0
 */
class Pregunta {
    String pregunta;
    int respuestaCorrecta;
    int puntosPregunta;
    String respuestasPosibles;

    /**
     * Construccion de cada pregunta con los requerimientos precisos
     * @param pregunta la pregunta que se le hace al usuario
     * @param respuestaCorrecta la respuesta correcta a la pregunta hecha
     * @param puntosPregunta los puntos de la pregunta
     * @param respuestasPosibles las respuestas posibles de la misma
     */
    Pregunta(String pregunta, int respuestaCorrecta, int puntosPregunta, String respuestasPosibles) { //Mediante el constructor determinamos los parametros de la clase
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.puntosPregunta = puntosPregunta;
        this.respuestasPosibles = " " + respuestasPosibles;
    }

    /**
     * Se encarga de mostrar la pregunta que se haya definido
     */
    public void mostrarPreguntaRespuestas(){
        System.out.println(pregunta);
        System.out.println(respuestasPosibles);
        System.out.println("Introduzca abajo numero de su respuesta");
    }


    /**
     * Comparamos la respuesta con la respuesta correcta
     * @param respuesta la respuesta introducida por el usuario
     * @return devuelve el valor de los puntos si es correcta
     */
   public int compararRespuesta(int respuesta) {
       if (respuesta==respuestaCorrecta) { // Si los puntos de las preguntas son distintos a 0 muestra que la respuesta es correcta
           System.out.println("La respuesta es correcta");
           return puntosPregunta;
       }
       else { // Si los puntos son 0 muestra que las respuestas son incorrectas
           System.out.println("La respuesta no es correcta");
           return 0;
       }
    }

}

/**
 * La principal gestiona el uso de lo demás para estrucutrar el programa
 * @author Oscar Rodriguez
 * @version 0.9
 */
public class MiniQuizJava {
    public static void main(String[] args) {
        int puntosTotales=0;
        String nombre;
        // Definimos un Scanner para obtener el nombre y decidir el comienzo
        Scanner datosB = new Scanner(System.in);
        // Objetos de la clase pregunta para definir las preguntas a hacer
        Pregunta[] preguntas = getPreguntas();
        // Fin de la definicion de objetos
        System.out.println("Por favor indiqueme su nombre"); // Indicamos que queremos el nombre
        nombre = datosB.next(); // Solicitamos datosB del nombre
        System.out.print("Para comenzar escriba Ya:"); // Indicamos si se quiere empezar
        String comienzo = datosB.next(); // Solicitamos la palabra ya
        do {

            if (comienzo.equalsIgnoreCase("ya")) { // Verificar si la palabra de inicio es igual a ya en cuyo caso iniciar cuestionario
                for (Pregunta pregunta : preguntas) {
                    puntosTotales += preguntasObtenerPuntos(pregunta);
                }
                comprobacionesFinales(nombre,puntosTotales); // Llamamos a las comprobaciones finales
                break;

            }
            else {
                System.out.println("Por favor introduzca la palabra ya"); // Indica que se debe introducir la palabra Ya
                comienzo = datosB.next(); // Volver a pedir la palabra de inicio
            }

        }
        while (comienzo.equalsIgnoreCase("ya")); // Bucle para si no escribimos la palabra de inicio correcta nos solicite hacerlo otra vez, todavia hay problemas
        datosB.close();

    }

    private static Pregunta[] getPreguntas() {
        Pregunta pregunta1 = new Pregunta("¿Como se declara una clase en Java?", 1, 3, "1. Usando class NombreClase\n 2. Usando clas NombreClase\n 3. Usando NombreClase");
        Pregunta pregunta2 = new Pregunta("¿Por que en Java los String se declaran en mayusculas?", 2, 2,"1 Porque son un tipo primitivo\n2. Porque son una clase\n3. Porque lo digo yo");
        Pregunta pregunta3 = new Pregunta("¿Que son los int,double,char?", 1, 1,"1. Tipos primitivos\n2. Una clase\n3. Ninguna de las anteriores");
        Pregunta pregunta4 = new Pregunta("¿Como se obtiene input desde la terminal en Java?",2,3,"1. El metodo input\n2. La clase input\n3. La clase Scanner");
        Pregunta pregunta5 = new Pregunta("¿Que es la sobrecarga de funciones?",2,1,"1. El usar una funcion una y otra vez\n2. El usar el mismo nombre de una funcion varias veces\n3. Ninguna de las anteriores");
        return new Pregunta[]{pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,new Pregunta("¿Que es la herencia?",2,1,"1. La forma de que un metodo llama a otro metodo\n2. El que una clase herede cosas de otra siendo esta otra la clase padre\n3. No existe")};
    }

    /**
     * Nos muestra las preguntas nos solicita respuesta y si acertamos nos devuelve los puntos
     * @param pregunta la pregunta para hacer
     * @return devuelve los puntos
     */
    static int preguntasObtenerPuntos(Pregunta pregunta) {
        int respuesta; //Declaramos variables para trabajar los puntos de las preguntas
        Scanner datos = new Scanner(System.in);
        pregunta.mostrarPreguntaRespuestas();  // Usamos el metodo mostrar Pregunta para revelarla por pantalla
        respuesta = datos.nextInt(); // Obtenemos una respuesta del usuaruio
        return pregunta.compararRespuesta(respuesta); // Usamos el metodo compararRespuesta para sí es correcta retornar los puntos correspondientes;
    }

    /**
     * Hacemos las comprobaciones finales para mostrar mensaje si es necesario
     * @param nombre el nombre del jugador
     * @param puntosTotales los puntos totales despues de haber hecho todas las preguntas
     */
    static void comprobacionesFinales(String nombre,int puntosTotales) {
        if (puntosTotales<5) { //Si los puntos totales son menos que 5 los conocimientos no son suficientes
            System.out.println(nombre + " ha obtenido " + puntosTotales + " sus concocimientos son algo pobres");
        } else if (puntosTotales==5) { // Si son 5 son conocimientos suficientes
            System.out.println(nombre + " ha obtenido " + puntosTotales + " sus conocimientos son de un nivel suficiente");
        } else if (puntosTotales==6) { // Si son 6 los conocimientos son buenos
            System.out.println(nombre + " ha obtenido " + puntosTotales + " sus conocimientos son de un buen nivel");
        } else if (puntosTotales<=8) { //Si son menor o igual a 8 con los anteriores excluidos entonces son notables
            System.out.println(nombre + " ha obtenido " + puntosTotales + " sus conocimientos son notables");
        } else { // En cualquier otro caso es un sobresaliente ya que es 9 o mayor
            System.out.println(nombre +" ha obtenido " + puntosTotales + " sus conocimientos son sobresalientes");
        }
    }
}
