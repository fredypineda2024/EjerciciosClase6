/*
 * Ejercicio 2 - Análisis de Calificaciones de Estudiantes
Eres un analista de datos en una escuela y tienes un registro de las 
calificaciones de los estudiantes en diferentes materias. Cada registro
 está representado por una cadena de texto que contiene el nombre del
  estudiante, la materia y la calificación, separados por comas. Tu tarea 
  es procesar estos datos para obtener información útil.

Los datos de entrada son una lista de cadenas de texto, donde cada cadena 
representa una calificación en el formato: "estudiante,materia,calificacion".
 Por ejemplo:

List<String> calificaciones = Arrays.asList(
    "Juan,Matematicas,85",
    "Ana,Historia,90",
    "Pedro,Matematicas,70",
    "Juan,Historia,75",
    "Ana,Matematicas,95",
    "Pedro,Historia,80"
);
Tareas
1. Calcular el Promedio de Calificaciones por Estudiante: Calcula el promedio
de calificaciones para cada estudiante.
2. Contar Estudiantes por Materia: Cuenta cuántos estudiantes tienen calificaciones
 en cada materia.
3. Filtrar Calificaciones Mayores a un Valor Específico: Filtra y muestra las
 calificaciones que son mayores a un valor específico.
4. Obtener la Materia con el Promedio Más Alto: Determina cuál es la materia 
con el promedio de calificaciones más alto.
 */


 import java.util.*;

 public class Ejercicio2 {
     public static void main(String[] args) {
         // Lista de datos de calificaciones
         List<String> calificaciones = Arrays.asList(
             "Juan,Matematicas,85",
             "Ana,Historia,90",
             "Pedro,Matematicas,70",
             "Juan,Historia,75",
             "Ana,Matematicas,95",
             "Pedro,Historia,80"
         );
 
         // Llamamos a cada tarea
         calcularPromedioPorEstudiante(calificaciones);
         contarEstudiantesPorMateria(calificaciones);
         filtrarCalificacionesMayores(calificaciones, 80);
         obtenerMateriaConPromedioMasAlto(calificaciones);
     }
 
     // Tarea 1: Calcular el promedio de calificaciones por estudiante
     public static void calcularPromedioPorEstudiante(List<String> calificaciones) {
         // Usamos un mapa para almacenar las calificaciones de cada estudiante
         Map<String, List<Integer>> mapaEstudiantes = new HashMap<>();
 
         for (String registro : calificaciones) {
             // Dividimos el registro en estudiante, materia, calificación
             String[] partes = registro.split(",");
             String estudiante = partes[0];
             int calificacion = Integer.parseInt(partes[2]);
 
             // Agregamos la calificación al mapa
             mapaEstudiantes.putIfAbsent(estudiante, new ArrayList<>());
             mapaEstudiantes.get(estudiante).add(calificacion);
         }
 
         // Calculamos el promedio de calificaciones por estudiante
         System.out.println("Promedio de calificaciones por estudiante:");
         for (Map.Entry<String, List<Integer>> entrada : mapaEstudiantes.entrySet()) {
             String estudiante = entrada.getKey();
             List<Integer> calificacionesEstudiante = entrada.getValue();
 
             // Calculamos el promedio
             double promedio = calificacionesEstudiante.stream().mapToInt(Integer::intValue).average().orElse(0.0);
             System.out.println(estudiante + ": " + promedio);
         }
     }
 
     // Tarea 2: Contar estudiantes por materia
     public static void contarEstudiantesPorMateria(List<String> calificaciones) {
         // Usamos un mapa para almacenar las materias y los estudiantes
         Map<String, Set<String>> mapaMaterias = new HashMap<>();
 
         for (String registro : calificaciones) {
             // Dividimos el registro en estudiante, materia, calificación
             String[] partes = registro.split(",");
             String materia = partes[1];
             String estudiante = partes[0];
 
             // Agregamos el estudiante al conjunto asociado a la materia
             mapaMaterias.putIfAbsent(materia, new HashSet<>());
             mapaMaterias.get(materia).add(estudiante);
         }
 
         // Contamos los estudiantes por materia
         System.out.println("\nCantidad de estudiantes por materia:");
         for (Map.Entry<String, Set<String>> entrada : mapaMaterias.entrySet()) {
             String materia = entrada.getKey();
             int cantidadEstudiantes = entrada.getValue().size();
             System.out.println(materia + ": " + cantidadEstudiantes + " estudiantes");
         }
     }
 
     // Tarea 3: Filtrar calificaciones mayores a un valor específico
     public static void filtrarCalificacionesMayores(List<String> calificaciones, int valor) {
         System.out.println("\nCalificaciones mayores a " + valor + ":");
         for (String registro : calificaciones) {
             // Dividimos el registro en estudiante, materia, calificación
             String[] partes = registro.split(",");
             String estudiante = partes[0];
             String materia = partes[1];
             int calificacion = Integer.parseInt(partes[2]);
 
             // Comprobamos si la calificación es mayor al valor especificado
             if (calificacion > valor) {
                 System.out.println(estudiante + " en " + materia + ": " + calificacion);
             }
         }
     }
 
     // Tarea 4: Obtener la materia con el promedio más alto
     public static void obtenerMateriaConPromedioMasAlto(List<String> calificaciones) {
         // Usamos un mapa para almacenar las calificaciones por materia
         Map<String, List<Integer>> mapaMaterias = new HashMap<>();
 
         for (String registro : calificaciones) {
             // Dividimos el registro en estudiante, materia, calificación
             String[] partes = registro.split(",");
             String materia = partes[1];
             int calificacion = Integer.parseInt(partes[2]);
 
             // Agregamos la calificación al mapa
             mapaMaterias.putIfAbsent(materia, new ArrayList<>());
             mapaMaterias.get(materia).add(calificacion);
         }
 
         // Determinamos la materia con el promedio más alto
         String materiaConPromedioMasAlto = null;
         double maxPromedio = 0.0;
 
         for (Map.Entry<String, List<Integer>> entrada : mapaMaterias.entrySet()) {
             String materia = entrada.getKey();
             List<Integer> calificacionesMateria = entrada.getValue();
 
             // Calculamos el promedio
             double promedio = calificacionesMateria.stream().mapToInt(Integer::intValue).average().orElse(0.0);
 
             // Actualizamos el promedio máximo si corresponde
             if (promedio > maxPromedio) {
                 maxPromedio = promedio;
                 materiaConPromedioMasAlto = materia;
             }
         }
 
         // Mostramos el resultado
         System.out.println("\nLa materia con el promedio más alto es " + materiaConPromedioMasAlto + " con un promedio de " + maxPromedio);
     }
 }
 
