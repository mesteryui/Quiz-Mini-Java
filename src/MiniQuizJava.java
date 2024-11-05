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
        return (respuesta==respuestaCorrecta) ? puntosPregunta : 0;
    }
    /**
     * Muestra si la respuesta ha sido correcta teniendo en cuenta los puntos retornados como parametro
     * @param puntos los puntos de una pregunta
     */
    public void mostrarCorrecta(int puntos) {
       if (puntos!=0) {
           System.out.println("La respuesta es correcta");
       }
       else {
           System.out.println("La respuesta no es correcta");
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
        int puntosTotales=0,puntosPregunta;
        String comienzo,nombre;
        Scanner datosB = new Scanner(System.in);
        Pregunta pregunta1 = new Pregunta("¿Como se declara una clase en Java?", 1, 3, "1. Usando class NombreClase\n 2. Usando clas NombreClase\n 3. Usando NombreClase");
        Pregunta pregunta2 = new Pregunta("¿Por que en Java los String se declaran en mayusculas?", 2, 2,"1 Porque son un tipo primitivo\n 2.Porque son una clase\n 3.Porque lo digo yo");
        Pregunta pregunta3 = new Pregunta("¿Que son los int,double,char?", 1, 1,"1. Tipos primitivos\n 2.Una clase\n 3.Ninguna de las anteriores");
        Pregunta pregunta4 = new Pregunta("¿Como se obtiene input desde la terminal en Java?",3,3,"1. El metodo input\n 2.La clase input\n 3. La clase Scanner");
        Pregunta pregunta5 = new Pregunta("¿Que es la sobrecarga de funciones?",2,1,"1. El usar una funcion una y otra vez\n 2.El usar el mismo nombre de una funcion varias veces\n 3.Ninguna de las anteriores");
        System.out.println("Por favor indiqueme su nombre"); // Indicamos que queremos el nombre
        nombre = datosB.next(); // Solicitamos datosB del nombre
        System.out.print("Para comenzar escriba Ya:"); // Indicamos si se quiere empezar
        comienzo = datosB.next(); // Solicitamos la palabra ya
        boolean comenzar;
        do {
            comenzar = comienzo.equals("Ya") || comienzo.equals("ya");
            if (comenzar || comienzo.equals("yA")) {


                puntosPregunta = preguntasObtenerPuntos(pregunta1); // Llamamos a la funcion para obtener puntos de preguntas
                pregunta1.mostrarCorrecta(puntosPregunta); // Si la respuesta es correcta lo mostramos
                puntosTotales += puntosPregunta; // Sumamos los puntos de cada pregunta a los puntos totales



                puntosPregunta = preguntasObtenerPuntos(pregunta2); // Llamamos a la funcion para obtener puntos de preguntas
                pregunta2.mostrarCorrecta(puntosPregunta); // Si la respuesta es correcta lo mostramos
                puntosTotales += puntosPregunta; // Sumamos los puntos de cada pregunta a los puntos totales


                puntosPregunta = preguntasObtenerPuntos(pregunta3);
                pregunta3.mostrarCorrecta(puntosPregunta);
                puntosTotales += puntosPregunta;


                puntosPregunta = preguntasObtenerPuntos(pregunta4);
                pregunta4.mostrarCorrecta(puntosPregunta);
                puntosTotales += puntosPregunta;


                puntosPregunta = preguntasObtenerPuntos(pregunta5);
                pregunta5.mostrarCorrecta(puntosPregunta);
                puntosTotales += puntosPregunta;

                comprobacionesFinales(nombre,puntosTotales); // Llamamos a las comprobaciones finales
               break;

            }
            else {
                System.out.println("Por favor introduzca la palabra ya"); // Indica que se debe introducir la palabra Ya
                comienzo = datosB.next();
                comenzar = comienzo.equals("Ya") || comienzo.equals("ya");
            }

        }
        while (!comenzar || !comienzo.equals("yA")); // Bucle para si no escribimos la palabra de inicio correcta nos solicite hacerlo otra vez, todavia hay problemas


    }

    /**
     * Nos muestra las preguntas nos solicita respuesta y si acertamos nos devuelve los puntos
     * @param pregunta la pregunta para hacer
     * @return devuelve los puntos
     */
    static int preguntasObtenerPuntos(Pregunta pregunta) {
        int respuesta, puntosPregunta;
        Scanner datos = new Scanner(System.in);
        pregunta.mostrarPreguntaRespuestas();  // Usamos el metodo mostrar Pregunta para revelarla por pantalla
        respuesta = datos.nextInt(); // Obtenemos una respuesta del usuaruio
        puntosPregunta = pregunta.compararRespuesta(respuesta); // Usamos el metodo compararRespuesta para sí es correcta retornar los puntos correspondientes
        return puntosPregunta;
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
