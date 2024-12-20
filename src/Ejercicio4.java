/*
 * Ejercicio 4 - Generador de ID para los empleados (Intermedio)
La empresa ABCD tiene hasta 100 empleados. La compañía decide crear 
un número de identificación único UID para cada uno de sus empleados. 
La compañía le ha asignado la tarea de validar los UIDs generados aleatoriamente.
Un UID válido debe cumplir con las siguientes reglas:

Debe contener por lo menos dos letras mayúsculas en el alfabeto inglés.
Debe tener por lo menos 3 dígitos.
Contener únicamente dígitos alfanuméricos.
No tener repeticiones.
Contener exactamente 10 caracteres.
El dato de entrada es una lista con los UID que desea validar. Por ejemplo:

List<String> uids = Arrays.asList(
    "B1CD102354",
    "B1CDEF2354"
);
Y las salidas deberían ser:

B1CD102354 - Inválido
B1CDEF2354 - Válido
 */

 import java.util.*;

 public class Ejercicio4 {
     public static void main(String[] args) {
         // Lista de UIDs a validar
         List<String> uids = Arrays.asList(
             "B1CD102354",
             "B1CDEF2354",
             "AB12CD3E45",
             "ABCDE12345",
             "1234567890"
         );
 
         // Validar cada UID
         for (String uid : uids) {
             if (esUIDValido(uid)) {
                 System.out.println(uid + " - Válido");
             } else {
                 System.out.println(uid + " - Inválido");
             }
         }
     }
 
     // Método para validar si un UID es válido
     public static boolean esUIDValido(String uid) {
         // Regla 5: Debe tener exactamente 10 caracteres
         if (uid.length() != 10) {
             return false;
         }
 
         // Regla 3: Contener solo caracteres alfanuméricos
         if (!uid.matches("[a-zA-Z0-9]+")) {
             return false;
         }
 
         // Regla 4: No debe tener repeticiones
         Set<Character> caracteres = new HashSet<>();
         for (char c : uid.toCharArray()) {
             if (!caracteres.add(c)) { // Si no puede agregar un carácter, es repetido
                 return false;
             }
         }
 
         // Regla 1: Al menos 2 letras mayúsculas
         long mayusculas = uid.chars().filter(Character::isUpperCase).count();
         if (mayusculas < 2) {
             return false;
         }
 
         // Regla 2: Al menos 3 dígitos
         long digitos = uid.chars().filter(Character::isDigit).count();
         if (digitos < 3) {
             return false;
         }
 
         // Si pasa todas las reglas, el UID es válido
         return true;
     }
 }
 