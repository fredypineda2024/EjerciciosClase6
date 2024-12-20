/*
 * Ejercicio 3 - Análisis de Facturas de una Empresa
Trabajas como analista de datos en una empresa y tienes un registro de 
todas las facturas emitidas durante el último trimestre. Cada factura está
 representada por una cadena de texto que contiene el número de factura, 
 el nombre del cliente, el monto total de la factura y el porcentaje de IVA aplicado,
  separados por comas. Tu tarea es procesar estos datos para obtener información útil.

Los datos de entrada son una lista de cadenas de texto, donde cada cadena 
representa una factura en el formato: "numero_factura,cliente,monto_total,iva". 
Por ejemplo:

List<String> facturas = Arrays.asList(
    "F001,ClienteA,1000.00,19",
    "F002,ClienteB,1500.00,19",
    "F003,ClienteA,2000.00,19",
    "F004,ClienteC,2500.00,19",
    "F005,ClienteB,3000.00,19"
);
Tareas
1. Calcular el Monto Total con IVA: Calcula el monto total de cada
 factura incluyendo el IVA.
2. Calcular el Ingreso Total por Cliente: Calcula el ingreso total 
generado por cada cliente.
3. Filtrar Facturas Mayores a un Valor Específico: Filtra y muestra 
las facturas cuyo monto total (sin IVA) sea mayor a un valor específico.
4. Obtener el Cliente con el Mayor Ingreso Total: Determina cuál fue 
el cliente que generó el mayor ingreso total.
 */

 import java.util.*;

 public class Ejercicio3 {
     public static void main(String[] args) {
         // Lista de facturas
         List<String> facturas = Arrays.asList(
             "F01,Cliente A,1000,19",
             "F02,Cliente B,1500,19",
             "F03,Cliente A,2000,19",
             "F04,Cliente C,2500,19",
             "F05,Cliente B,3000,19"
         );
 
         // Llamamos a cada tarea
         calcularMontoTotalConIVA(facturas);
         calcularIngresoTotalPorCliente(facturas);
         filtrarFacturasMayores(facturas, 2000.00);
         obtenerClienteConMayorIngreso(facturas);
     }
 
     // Tarea 1: Calcular el monto total con IVA
     public static void calcularMontoTotalConIVA(List<String> facturas) {
         System.out.println("Monto total con IVA por factura:");
         for (String factura : facturas) {
             // Dividimos la cadena
             String[] partes = factura.split(",");
             String numeroFactura = partes[0];
             String cliente = partes[1];
             double montoSinIVA = Double.parseDouble(partes[2]);
             double iva = Double.parseDouble(partes[3]);
 
             // Calculamos el monto con IVA
             double montoConIVA = montoSinIVA * (1 + iva / 100);
             System.out.println(numeroFactura + " (" + cliente + "): " + montoConIVA);
         }
     }
 
     // Tarea 2: Calcular el ingreso total por cliente
     public static void calcularIngresoTotalPorCliente(List<String> facturas) {
         // Usamos un mapa para acumular ingresos por cliente
         Map<String, Double> ingresosPorCliente = new HashMap<>();
 
         for (String factura : facturas) {
             String[] partes = factura.split(",");
             String cliente = partes[1];
             double montoSinIVA = Double.parseDouble(partes[2]);
             double iva = Double.parseDouble(partes[3]);
 
             // Calculamos el monto con IVA
             double montoConIVA = montoSinIVA * (1 + iva / 100);
 
             // Acumulamos el monto en el mapa
             ingresosPorCliente.put(cliente, ingresosPorCliente.getOrDefault(cliente, 0.0) + montoConIVA);
         }
 
         // Imprimimos el ingreso total por cliente
         System.out.println("\nIngreso total por cliente:");
         for (Map.Entry<String, Double> entrada : ingresosPorCliente.entrySet()) {
             System.out.println(entrada.getKey() + ": " + entrada.getValue());
         }
     }
 
     // Tarea 3: Filtrar facturas mayores a un valor específico
     public static void filtrarFacturasMayores(List<String> facturas, double valor) {
         System.out.println("\nFacturas con monto total (sin IVA) mayor a " + valor + ":");
         for (String factura : facturas) {
             String[] partes = factura.split(",");
             double montoSinIVA = Double.parseDouble(partes[2]);
 
             // Filtramos por monto
             if (montoSinIVA > valor) {
                 System.out.println(factura);
             }
         }
     }
 
     // Tarea 4: Obtener el cliente con el mayor ingreso total
     public static void obtenerClienteConMayorIngreso(List<String> facturas) {
         // Usamos el mismo mapa de la Tarea 2
         Map<String, Double> ingresosPorCliente = new HashMap<>();
 
         for (String factura : facturas) {
             String[] partes = factura.split(",");
             String cliente = partes[1];
             double montoSinIVA = Double.parseDouble(partes[2]);
             double iva = Double.parseDouble(partes[3]);
 
             // Calculamos el monto con IVA
             double montoConIVA = montoSinIVA * (1 + iva / 100);
 
             // Acumulamos el monto en el mapa
             ingresosPorCliente.put(cliente, ingresosPorCliente.getOrDefault(cliente, 0.0) + montoConIVA);
         }
 
         // Determinamos el cliente con el mayor ingreso
         String clienteMayorIngreso = null;
         double mayorIngreso = 0.0;
 
         for (Map.Entry<String, Double> entrada : ingresosPorCliente.entrySet()) {
             if (entrada.getValue() > mayorIngreso) {
                 mayorIngreso = entrada.getValue();
                 clienteMayorIngreso = entrada.getKey();
             }
         }
 
         // Imprimimos el cliente con mayor ingreso
         System.out.println("\nEl cliente con mayor ingreso total es " + clienteMayorIngreso + " con un ingreso de " + mayorIngreso);
     }
 }
 